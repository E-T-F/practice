package alg.SwordOffer;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * @Auther: etf
 * @Date: 2021-02-22 21:14
 * @Description:
 */
public class ReplaceSpace {


    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new ReplaceSpace().replaceSpace2("     "));
    }
    public String replaceSpace2(String s) {

        StringBuffer sb = new StringBuffer(s);

        int oldLen = s.length() - 1;
        for (int i = 0; i <= oldLen; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("  ");
            }
        }

        int newLen = sb.length() - 1;
        while (oldLen >= 0 && newLen > oldLen) {
            char c = sb.charAt(oldLen--);
            if (c == ' ') {
                sb.setCharAt(newLen--, '0');
                sb.setCharAt(newLen--, '2');
                sb.setCharAt(newLen--, '%');
            } else {
                sb.setCharAt(newLen--, c);
            }
        }
        return sb.toString();
    }
}