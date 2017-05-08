public class Solution {
    public int reverse(int x) {
        String input = Integer.toString(Math.abs(x));
        String result = "";
        int len = input.length();
        for (int i = len - 1; i >= 0; i--) {
            result += input.charAt(i);
        }
        if (result.length() >= 10) {
            if (result.compareTo("2147483648") > 0) return 0;
        }
        if (x < 0) {
            result = "-" + result;
        }
        return Integer.parseInt(result);
    }
}