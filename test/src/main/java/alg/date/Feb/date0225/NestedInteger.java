package alg.date.Feb.date0225;

import java.util.List;

public class NestedInteger {

    private Integer value;
    private List<NestedInteger> list;


    boolean isInteger() {
        return value != null;
    }


    Integer getInteger() {
        return value;
    }


    List<NestedInteger> getList() {
        return list;
    }
}
