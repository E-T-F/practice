package alg.labuladong;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 *
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 *
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 */
public class OpenLock {

    public int openLock(String[] deadends, String target) {
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visitedSet = new HashSet<>();
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        queue.offer("0000");
        visitedSet.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (deadSet.contains(cur)) {
                    continue;
                }
                if (target.equals(cur)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visitedSet.contains(up)) {
                        queue.offer(up);
                        visitedSet.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visitedSet.contains(down)) {
                        queue.offer(down);
                        visitedSet.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }


    /**
     * 如果知道明确的目标，可以双向（时间复杂度一样，但空间复杂度会减少
     * @param deadends
     * @param target
     * @return
     */
    public int openLockWithOpt(String[] deadends, String target) {
        Set<String> head = new HashSet<>();
        Set<String> tail = new HashSet<>();

        Set<String> visitedSet = new HashSet<>();
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        head.add("0000");
        tail.add(target);
        int step = 0;
        while (!head.isEmpty() && !tail.isEmpty()) {
            Set<String> temp = new HashSet<>();
            if (head.size() > tail.size()) {
                temp = head;
                head = tail;
                tail = temp;
            }
            temp = new HashSet<>();
            for (String cur : head) {
                if (deadSet.contains(cur)) {
                    continue;
                }
                if (tail.contains(cur)) {
                    return step;
                }
                visitedSet.add(cur);

                for (int i = 0; i < 4; i++) {
                    String up = plusOne(cur, i);
                    if (!visitedSet.contains(up)) {
                        temp.add(up);
                    }
                    String down = minusOne(cur, i);
                    if (!visitedSet.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            step++;
            //双向扫描
            head = tail;
            tail = temp;
        }
        return -1;
    }


    private String plusOne(String cur, int j) {
        char[] chars = cur.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] += 1;
        }
        return new String(chars);
    }

    private String minusOne(String cur, int j) {
        char[] chars = cur.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j] -= 1;
        }
        return new String(chars);
    }

}
