package alg.run0522;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }
        int cursor = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                cursor++;
            } else {
                nums[i - cursor] = nums[i];
            }
        }
        return nums.length - cursor;
    }


    //最多出现2次
    public static int removeDuplicatesTwice(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int cnt = 0;
        int cursor = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt < 2) {
                nums[cursor++] = nums[i];
            }
        }
        return cursor;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4};
        System.out.println(removeDuplicatesTwice(nums));
    }
}
