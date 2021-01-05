package ds.array.basic.index;

/**
 * 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x96n4v/
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * @Auther: etf
 * @Date: 2021-01-05 23:18
 * @Description:
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxVolume = 0;
        while (left < right) {
            boolean lmtr = height[left] > height[right];
            int min = lmtr ? height[right] : height[left];
            int current = min * (right - left);
            if (maxVolume < current) {
                maxVolume = current;
            }
            if (lmtr) {
                right--;
            } else {
                left++;
            }
        }
        return maxVolume;

    }

    public static int maxArea2(int[] height) {

        int maxVolume = 0;
        int beforeHeight = 0;
        for (int left = 0; left < height.length; left++) {
            for (int right = height.length - 1; right > left; right--) {
                int min = height[left] > height[right] ? height[right] : height[left];
                if (beforeHeight >= min) {
                    continue;
                }
                beforeHeight = min;
                int volume = (right - left) * min;
                if (maxVolume < volume) {
                    maxVolume = volume;
                }
            }
        }
        return maxVolume;
    }


    public int maxArea3(int[] height) {
        int maxVolume = 0;

        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                int min = height[left] > height[right] ? height[right] : height[left];
                int volume = (right - left) * min;
                if (maxVolume < volume) {
                    maxVolume = volume;
                }
            }
        }
        return maxVolume;
    }


    public static int maxArea4(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxVolume = 0;
        while (left < right) {
            maxVolume = height[left] < height[right] ?
                    Math.max(maxVolume, (right - left) * height[left++]) :
                    Math.max(maxVolume, (right - left) * height[right--]);
        }
        return maxVolume;
    }
}
