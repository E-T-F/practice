package alg.date.Feb.date0225;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class NestedIteratorOpt implements Iterator<Integer> {

    LinkedList<NestedInteger> nestedList;

    //一般的迭代器求值应该是「惰性」的
    public NestedIteratorOpt(List<NestedInteger> nestedList) {
        nestedList = new LinkedList<>(nestedList);
    }

    //调用next方法之前一定需调用hasNext方法
    @Override
    public Integer next() {
        return nestedList.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!nestedList.isEmpty() && !nestedList.get(0).isInteger()) {
            // 当列表开头第一个元素是列表类型时，进入循环
            List<NestedInteger> temp = nestedList.remove(0).getList();
            //列表打平顺序放入 （放入列表前面，需倒序
            for (int i = temp.size() - 1; i >= 0; i--) {
                nestedList.addFirst(temp.get(i));
            }
        }
        return !nestedList.isEmpty();
    }
}