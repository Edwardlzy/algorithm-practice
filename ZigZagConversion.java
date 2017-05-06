public class Solution {
    public String convert(String s, int numRows) {
        if (s.length() < 2) return s;
        if (numRows == 1) return s;
        int len = s.length();
        String result = "";
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index < len) {
                int temp = index;
                result += s.charAt(index);
                index += (numRows - 1) * 2;
                int offset = index - 2 * i;
                if ((offset > temp) && (offset < len) && (offset != index)) {
                    result += s.charAt(offset);
                }
            }
        }
        return result;
    }
}