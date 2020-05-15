package com.etf.utils;

import com.etf.annotation.MyAnnotation;
import com.etf.annotation.MyColumn;
import com.etf.constants.QueryConstant;
import com.etf.dto.BaseRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @Auther: etf
 * @Date: 2020-05-15 10:57
 * @Description:
 */
@Slf4j
public class
QueryUtils {


    /**
     * 生成 query 语句
     *
     * @param paramMap
     * @return
     */
    public static String generateQuery(Map<String, Object> paramMap) {
        String query = "";
        if (MapUtils.isNotEmpty(paramMap)) {
            StringBuffer q = new StringBuffer();
            for (Map.Entry<String, Object> map : paramMap.entrySet()) {
                q.append(QueryConstant.AND);
                q.append(" ");
                q.append(map.getKey()).append(":").append(map.getValue());
                q.append(" ");
            }
            query = q.substring(QueryConstant.AND.length());
        }
        return query;
    }


    /**
     * 生成区间匹配
     * 格式： param:[100，200]
     *
     * @param paramMap
     * @return
     */
    public static List<String> generateFInterval(Map<String, Object[]> paramMap) {

        List<String> list = new ArrayList<>();

        if (MapUtils.isNotEmpty(paramMap)) {
            for (Map.Entry<String, Object[]> map : paramMap.entrySet()) {
                StringBuffer f = new StringBuffer();
                Object[] objs = map.getValue();
                if (objs != null && objs.length >= 2) {
                    f.append(map.getKey()).append(" ")
                            .append("[").append(objs[0])
                            .append(",").append(objs[1]).append("]");
                    list.add(f.toString());
                }
            }
        }
        return list;
    }

    /**
     * 生成 in 匹配
     * 格式： param:[100，200]
     *
     * @param paramMap
     * @return
     */
    public static List<String> generateFIn(Map<String, Object[]> paramMap) {

        List<String> list = new ArrayList<>();

        if (MapUtils.isNotEmpty(paramMap)) {
            for (Map.Entry<String, Object[]> map : paramMap.entrySet()) {
                StringBuffer fin = new StringBuffer();
                Object[] objs = map.getValue();
                if (objs != null && objs.length > 0) {
                    fin.append(map.getKey()).append(":")
                            .append("{");
                    for (Object obj : objs) {
                        fin.append(obj).append(",");
                    }
                    fin.deleteCharAt(fin.length() - 1);
                    fin.append("}");
                    list.add(fin.toString());
                }
            }
        }

        return list;
    }


    public static String generateSearchParamDTO(BaseRequestDto model) {
        Class clazz = model.getClass();

        if (null == clazz) {
            return null;
        }

        Field[] fields = getAllDeclaredFields(clazz);
        if (ArrayUtils.isNotEmpty(fields)) {
            Map<String, Object> qmap = new HashMap<>();
            Map<String, Object[]> fmap = new HashMap<>();
            Map<String, Object[]> inmap = new HashMap<>();

            for (Field field : fields) {
                Annotation annotation = field.getAnnotation(MyColumn.class);
                if (annotation != null && annotation instanceof MyColumn) {
                    field.setAccessible(true);
                    try {
                        MyColumn column = (MyColumn) annotation;
                        String name = field.getName();
                        Object value = field.get(model);
                        if (value != null) {
                            if (column.type() == MyColumn.Type.Q) {
                                qmap.put(name, value);
                            } else if (column.type() == MyColumn.Type.F) {
                                fmap.put(name, (Object[]) value);
                            } else if (column.type() == MyColumn.Type.IN) {
                                inmap.put(name, (Object[]) value);
                            }
                            if (column.sort() != MyColumn.Sort.none) {
                                model.setSortKey(name);
                                model.setSortType(column.sort());
                            }
                        }
                    } catch (IllegalAccessException e) {
                        log.error("", e);
                    }
                }
            }

            String sort = "";
            /**
             * 指定了排序则覆盖
             */
            if (StringUtils.isNotBlank(model.getSortKey()) && model.getSortType() != MyColumn.Sort.none) {
                sort = model.getSortKey() + " " + model.getSortType();
            }

            String query = generateQuery(qmap);
            List<String> f = new ArrayList<>();
            f.addAll(generateFIn(inmap));
            f.addAll(generateFInterval(fmap));

            /**
             * 获取类注解 key
             */
            String tableName = "default";
            if (clazz.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation table = (MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
                String tableKey = table.value();
                // 获取 K -> V
                tableName = tableKey;
            }
            StringBuffer build = new StringBuffer();
            build.append("tableName: ").append(" ")
                    .append(tableName).append(" limit : ").append(model.getLimit());
            if (StringUtils.isNotBlank(query)) {
                build.append(" q -> { ").append(query).append(" }");
            }
            if (CollectionUtils.isNotEmpty(f)) {
                build.append(" f -> { ").append(f).append(" }");
            }
            if (StringUtils.isNotBlank(sort)) {
                build.append(" sort -> { ").append(sort).append(" }");
            }
            return build.toString();
        }
        return null;

    }

    private static Field[] getAllDeclaredFields(Class clazz) {
        List<Field> fields = new ArrayList<>();

        while (clazz != null && !clazz.getName().toLowerCase().equals("java.lang.object")) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields.toArray(new Field[fields.size()]);
    }
}
