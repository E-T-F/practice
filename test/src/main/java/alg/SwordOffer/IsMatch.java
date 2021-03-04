package alg.SwordOffer;

/**
 * 剑指 Offer 19. 正则表达式匹配
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * @Auther: etf
 * @Date: 2021-03-02 22:08
 * @Description:
 */
public class IsMatch {


    /**
     * p[j] != '*',  f[i, j] = f[i-1, j-1]   match -> p[j] = s[i] or p[j] = '.'
     *                false                  otherwise
     *
     * p[j] == '*',  f[i, j] = f[i−1][j] or f[i][j−2] match -> p[j-1] = s[i]
     *               f[i, j] = f[i][j−2]              match -> p[j-1] != s[i]
     *
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {


        int m = s.length();
        int n = p.length();
        boolean[][] res = new boolean[m + 1][n + 1];
        res[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    res[i][j] = res[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        res[i][j] = res[i][j - 2] || res[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        res[i][j] = res[i - 1][j - 1];
                    }
                }
            }
        }



    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }

        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "a.a";
        String p = "ab*ac*a";
        s = "aab";
        p = "c*a*b";
        s = "a";
        p = "ab*";
//        s = "aaa";
//        p = "ab*a*c*a";
        s = "bbba";
        p = ".*a";
        System.out.println(new IsMatch().isMatch(s, p));
    }

    public boolean isMatch2(String s, String p) {

        if (s == null || s.length() <= 0) {
            if (p == null || p.equals(".")) {
                return true;
            } else {
                return false;
            }
        }
        int cursor = 0;
        char pre = ' ';
        boolean flag = false;
        int i = 0;
        for (; i < s.length(); i++) {
            if (cursor >= p.length()) {
                return false;
            }
            char current = s.charAt(i);
            char cmp = p.charAt(cursor);
            if (cmp == '*' && pre == ' ') {
                return false;
            }
            if (cmp == current || cmp == '.') {
                cursor++;
                pre = cmp;
                continue;
            }

            if (cmp == '*' && (pre == '.' || pre == current)) {
                flag = true;
                continue;
            } else if (cmp == '*') {
                cursor++;
                if (cursor >= p.length()) {
                    return false;
                }
                if (p.charAt(cursor) == current || p.charAt(cursor) == '.') {
                    pre = p.charAt(cursor);
                    cursor++;
                    continue;
                }
            }

            cursor++;
            i--;
            pre = cmp;
        }

        if (i == s.length()) {
            if ((cursor == p.length() - 1 && p.charAt(p.length() - 1) == '*')
                    || cursor == p.length()) {
                return true;
            } else if (cursor < (p.length() - 1)) {
                if (p.charAt(++cursor) == pre) {
                    while (cursor < p.length()) {
                        if (p.charAt(cursor) != pre) {
                            return false;
                        }
                        cursor++;

                    }
                } else if (cursor == (p.length() - 1) && p.charAt(cursor) == '*') {
                    return true;
                } else if (cursor < (p.length() - 1) && p.charAt(++cursor) == '*') {
                    cursor++;
                    while (cursor < p.length()) {
                        if (p.charAt(cursor) != pre) {
                            return false;
                        }
                        cursor++;

                    }
                }

                if (cursor == p.length()) {
                    return true;
                }
            }

        }
        return false;
    }


}
