package alg.leet;

/**
 * 比赛中的配对次数
 */
public class NumberOfMatches {

    public static void main(String[] args) {
        System.out.println(new NumberOfMatches().numberOfMatches(4));
    }
    int res = 0;
    public int numberOfMatches(int n) {
        if (n <= 1) {
            return res;
        }
        if (n == 2) {
            res += 1;
            return res;
        }

        int match;
        if (n % 2 == 0) {
            match = n / 2;
            res += match;
        } else {
            match = (n - 1) / 2;
            res += match + 1;
        }
        numberOfMatches(match);
        return res;
    }
}
