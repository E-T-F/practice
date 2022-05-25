package alg.run0522;

public class BinarySearch {


    public static int binarySearch(int[] nums, int val) {
        return binarySearch(nums, 0, nums.length - 1, val);
    }

    /**
     * 不存在重复的
     *
     * @param nums
     * @param start
     * @param end
     * @param val
     * @return
     */
    private static int binarySearch(int[] nums, int start, int end, int val) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == val) {
                return mid;
            } else if (nums[mid] > val) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    //1. 查找第一个值等于给定值的元素
    private static int binarySearchFirst(int[] nums, int start, int end, int val) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (val > nums[mid]) {
                start = mid + 1;
            } else if (val < nums[mid]) {
                end = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] != val) {
                    return mid;
                }
                end = mid - 1;
            }
        }
        return -1;
    }


    //2、查找最后一个值等于给定值的元素
    private static int binarySearchLast(int[] nums, int start, int end, int val) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (val > nums[mid]) {
                start = mid + 1;
            } else if (val < nums[mid]) {
                end = mid - 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != val) {
                    return mid;
                }
                start = mid + 1;
            }
        }
        return -1;
    }


    //3、查找第一个大于等于给定值的元素
    private static int binarySearchFistGE(int[] nums, int start, int end, int val) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (val > nums[mid]) {
                start = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] < val) {
                    return mid;
                }
                end = mid - 1;
            }
        }
        return -1;
    }

    //4、查找最后一个小于等于给定值的元素
    private static int binarySearchLastLE(int[] nums, int start, int end, int val) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (val < nums[mid]) {
                end = mid - 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] > val) {
                    return mid;
                }
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 5, 7, 7, 8, 9};
        // 非递归查找
        int r1 = binarySearchLastLE(nums, 0, nums.length - 1, 6);
        System.out.println(r1);
    }
}
