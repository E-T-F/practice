package alg.run0522;

import java.util.Arrays;

/**
 * 给定一个数组 nums ，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


    //[0,1,0,3,12]
    public static void moveZeroes(int[] nums) {

        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[current] = nums[i];
                current++;
            }
        }
        while (current < nums.length) {
            nums[current++] = 0;
        }
    }

}
