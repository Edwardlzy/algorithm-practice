public class Solution {
    public int romanToInt(String s) {
        int count = 0;
        // Assume the longest roman numeral under 4000 has length of 15.
        int[] raw = new int[15];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I' :
                    raw[i] = 1;
                    break;
                case 'V' :
                    raw[i] = 5;
                    break;
                case 'X' :
                    raw[i] = 10;
                    break;
                case 'L' :
                    raw[i] = 50;
                    break;
                case 'C' :
                    raw[i] = 100;
                    break;
                case 'D' :
                    raw[i] = 500;
                    break;
                case 'M' :
                    raw[i] = 1000;
                    break;
                default :
                    break;
            }
            count++;
        }
        
        int result = 0;
        int temp = raw[0];
        for (int i = 1; i < count; i++) {
            if (raw[i] > temp) temp = -temp;
            result += temp;
            temp = raw[i];
        }
        result += temp;
        return result;
    }
}