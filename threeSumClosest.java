public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(min - target)) {
                    min = sum;
                    if (sum < target) j++;
                    else k--;
                } else {
                    if (sum > target) k--;
                    else j++;
                }
            }
        }
        return min;
    }
}