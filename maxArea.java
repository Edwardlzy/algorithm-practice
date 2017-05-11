public class Solution {
    public int maxArea(int[] height) {
        // int max = 0;
        // Brute force
        // for (int i = 0; i < height.length - 1; i++) {
        //    for (int j = i + 1; j < height.length; j++) {
        //        int temp = getArea(height[i], height[j], i, j);
        //        max = (temp > max) ? temp : max;
        //    }
        //}

        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int temp = Math.min(height[l], height[r]) * (r - l);
            maxarea = (temp > maxarea) ? temp : maxarea;
            if (height[l] < height[r])
                l++;
            else
                r--;
        }


        return maxarea;
    }
    
    public int getArea(int n1, int n2, int index1, int index2) {
        int width = Math.abs(index2 - index1);
        return Math.min(n1, n2) * width;
    }
}