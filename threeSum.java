public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) return result;
        
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum < target) j++;
                else if (sum > target) k--;
                // Found qualified indices. Make List<Integer>.
                else {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    
                    while (j < k && nums[j] == temp.get(1)) j++;
                    while (j < k && nums[k] == temp.get(2)) k--;
                }
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
        return result;
    }
}