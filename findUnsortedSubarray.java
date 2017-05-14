public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int begin = 0;
        int end = nums.length;
        int max = nums[0];
        int min = nums[0];
        Boolean sorted = true;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                begin = i;
                sorted = false;
                max = nums[i];
                min = nums[i + 1];
                end = i + 1;
                break;
            }
        }
        
        for (int i = begin; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
            if (max > nums[i]) end = i;
        }
        
        for (int i = end; i >= 0; i--) {
            if (i < begin) {
                if (nums[i] > min) begin--;
            }
        }
        
        if (sorted == false) return end - begin + 1;
        return 0;
    }
}