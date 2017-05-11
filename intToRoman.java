public class Solution {
    public String intToRoman(int num) {
        if (num <= 0) return "";
        // Using recursion
        String result = "";
        if (num / 1000 != 0) {
            int temp = num / 1000;
            for (int i = 0; i < temp; i++) {
                result += "M";
            }
            result += intToRoman(num - 1000 * temp);
        } else {
            // num < 1000
            if (num % 1000 >= 900) result += "CM" + intToRoman(num - 900);
            else if (num % 1000 >= 500) result += 'D' + intToRoman(num - 500);
            else {
                // num < 500
                if (num % 500 >= 400) result += "CD" + intToRoman(num - 400);
                else if (num % 500 >= 100) result += 'C' + intToRoman(num - 100);
                else {
                    // num < 100
                    if (num % 100 >= 90) result += "XC" + intToRoman(num - 90);
                    else if (num % 100 >= 50) result += "L" + intToRoman(num - 50);
                    else {
                        // num < 50
                        if (num % 50 >= 40) result += "XL" + intToRoman(num - 40);
                        else if (num % 50 >= 10) result += "X" + intToRoman(num - 10);
                        else {
                            // num < 10
                            if (num % 10 >= 9) result += "IX" + intToRoman(num - 9);
                            else if (num % 10 >= 5) result += "V" + intToRoman(num - 5);
                            else {
                                // num < 5
                                if (num == 4) result += "IV";
                                else {
                                    for (int i = 0; i < num; i++) {
                                        result += "I";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}