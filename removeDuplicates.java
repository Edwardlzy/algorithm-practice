public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = (nums.length > 0) ? 1 : 0;
        for (int item : nums) {
            if (item > nums[i - 1]) {
                nums[i++] = item;
            }
        }
        return i;
    }
}