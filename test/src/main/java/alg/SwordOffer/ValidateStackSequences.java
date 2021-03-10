package alg.SwordOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 *
 * @Auther: etf
 * @Date: 2021-03-09 22:26
 * @Description:
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        int[] pushed = {1, 0, 3, 2};
        int[] popped = {0, 1, 2, 3};
        System.out.println(new ValidateStackSequences().validateStackSequences(pushed, popped));
    }


    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();

        int cur = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);

            while (!stack.isEmpty() && stack.peek() == popped[cur]) {
                stack.pop();
                cur++;
            }

        }

        return stack.isEmpty();

    }


    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        HashMap<Integer, Integer> pushedMap = new HashMap<>();
        HashMap<Integer, Integer> poppedMap = new HashMap<>();

        for (int i = 0; i < pushed.length; i++) {
            pushedMap.put(pushed[i], i);
            poppedMap.put(popped[i], i);
        }

        for (int i = 0; i < popped.length; i++) {
            Integer index = pushedMap.get(popped[i]);
            ArrayList<Integer> existed = new ArrayList<>();
            //之前压栈的元素必须保持顺序
            for (int j = 0; j < index; j++) {
                int popIndex = poppedMap.get(pushed[j]);
                if (popIndex > i) {
                    //右侧的需有序
                    long count = existed.stream().filter(m -> (m < popIndex)).count();
                    if (count > 0) {
                        return false;
                    }
                    existed.add(popIndex);
                }
            }

        }
        return true;

    }

}
