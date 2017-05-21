public class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int result = 0;
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        for (int key : hm.keySet()) {
            if (hm.containsKey(key + 1)) {
                result = (hm.get(key + 1) + hm.get(key) > result) ? hm.get(key + 1) + hm.get(key) : result;
            }
        }
        return result;
    }
}