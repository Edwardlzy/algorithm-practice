public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap hm = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hm.get(nums[i]) == null) {
                int[] arr = new int[2];
                arr[0] = i;
                hm.put(nums[i], arr);
            }
            else {
                int[] arr = (int[])hm.get(nums[i]);
                arr[1] = i;
                hm.put(nums[i], arr);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (hm.get(target - nums[i]) != null) {
                if (((int[])hm.get(target - nums[i]))[1] == 0) {
                    if (((int[])hm.get(target - nums[i]))[1] != i) {
                        result[0] = Math.min(i, ((int[])hm.get(target - nums[i]))[0]);
                        result[1] = Math.max(i, ((int[])hm.get(target - nums[i]))[0]);
                        return result;
                    } else { continue; }
                } else {
                    result = (int[])hm.get(target - nums[i]);
                    return result;
                }
            }
        }
        return result;
    }
}