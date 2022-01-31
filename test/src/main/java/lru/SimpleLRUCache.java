package lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleLRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int CACHE_SIZE;

    public SimpleLRUCache(int cacheSize) {
        // 容量为最大值/0.75，即最大负载容量为maxSize
        // accessOrder=true  根据查询排序，即最近被使用的放到后面
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    /**
     * 此方法为钩子方法，map插入元素时会调用此方法
     * 此方法返回true则证明删除最老的因子
     *
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }
}
