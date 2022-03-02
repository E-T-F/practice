package alg.date.Feb.date0225;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class NestedIterator implements Iterator<Integer> {

    Iterator<Integer> it;
    LinkedList<Integer> res = new LinkedList<>();
    //一次性算出了所有叶子节点的值，全部装到result列表，也就是内存中.
    // next和hasNext方法只是在对result列表做迭代。
    // 如果输入的规模非常大，构造函数中的计算就会很慢，而且很占用内存。

    //一般的迭代器求值应该是「惰性」的
    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger nest : nestedList) {
            traverse(nest);
        }
        it = res.iterator();
    }

    private void traverse(NestedInteger nest) {
        if (nest.isInteger()) {
            //叶子节点
            res.add(nest.getInteger());
            return;
        }

        for (NestedInteger nested : nest.getList()) {
            traverse(nested);
        }
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}