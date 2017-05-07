public class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        // first nut
        int raw = 0;
        for (int i = 0; i < nuts.length; i++) {
            raw += distance(nuts[i], tree) * 2;
        }
        int first[] = firstNut(tree, squirrel, nuts);
        raw -= distance(first, tree);
        raw += distance(squirrel, first);
        return raw;
    }
    
    public int[] firstNut(int[] tree, int[] squirrel, int[][] nuts) {
        int result[] = nuts[0];
        for (int i = 0; i < nuts.length; i++) {
            if ((distance(squirrel, nuts[i]) - distance(nuts[i], tree)) < 
                (distance(squirrel, result) - distance(result, tree))) {
                result = nuts[i];
            }
        }
        return result;
    }
    
    public int distance(int[] s, int[] t) {
        return Math.abs(t[0] - s[0]) + Math.abs(t[1] - s[1]);
    }
}