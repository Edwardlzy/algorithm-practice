public class Solution {
    public static int removeElement(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }
    
    // The tricky part of this problem is to remove "in-place".
    // One approach is to maintain two pointers (slow and fast)
    // which modify the array as they traverse.
}