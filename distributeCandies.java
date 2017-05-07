public class Solution {
    public int distributeCandies(int[] candies) {
        HashMap hm = new HashMap();
        int num = candies.length / 2;
        int kind = 0;
        for (int i = 0; i < candies.length; i++) {
            if (hm.get(candies[i]) == null) {
                hm.put(candies[i], 1);
                kind++;
            }
        }
        return Math.min(kind, num);
    }
}