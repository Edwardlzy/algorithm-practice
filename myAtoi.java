public class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) return 0;
        String result = "";
        boolean neg = false;
        int end = str.length();
        for (int i = str.length(); i > 0; i--) {
            if (str.substring(0, i).matches("^( *(\\-|\\+)?\\d+)$")) {
                end = i;
                break;
            }
        }
        if (end == str.length() && !str.matches("^( *(\\-|\\+)?\\d+)$")) return 0;
        String trimmed = str.substring(0, end);
        
        for (int i = 0; i < trimmed.length(); i++) {
            if (trimmed.charAt(i) == '-') neg = true;
            if (trimmed.charAt(i) != ' ' && trimmed.charAt(i) != '+' && trimmed.charAt(i) != '-') {
                result += trimmed.substring(i);
                break;
            }
        }
        
        if (result.length() > 10) {
            if (neg) return -2147483648;
            else return 2147483647;
        }
        if (result.length() == 10) {
            if (result.compareTo("2147483648") > 0) {
                if (!neg) return 2147483647;
                else return -2147483648;
            }
            if (result.compareTo("2147483648") == 0) {
                if (!neg) return 2147483647;
                else return -2147483648;
            }
        }
        if (neg) result = "-" + result;
        return Integer.parseInt(result);
    }
}