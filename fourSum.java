public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int s = j + 1, t = nums.length - 1;
                while (s < t) {
                    int sum = nums[i] + nums[j] + nums[s] + nums[t];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[s]);
                        temp.add(nums[t]);
                        result.add(temp);
                        while (s < t && nums[s] == nums[s + 1]) s++;
                        while (s < t && nums[t] == nums[t - 1]) t--;
                        s++;
                        t--;
                    } else if (sum < target) s++;
                    else t--;
                }
            }
        }
        return result;
    }
}