public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int len = 0;
        int target = 0;
        int temp1[] = new int[2];
        int temp2[] = new int[2];
        
        if ((p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]) > len) {
            len = (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
            target = 2;
        }
        if ((p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1]) > len) {
            len = (p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1]);
            target = 3;
        }
        if ((p4[0] - p1[0]) * (p4[0] - p1[0]) + (p4[1] - p1[1]) * (p4[1] - p1[1]) > len) {
            len = (p4[0] - p1[0]) * (p4[0] - p1[0]) + (p4[1] - p1[1]) * (p4[1] - p1[1]);
            target = 4;
        }
        
        if (len == 0) return false;
        
        if (target == 2) {
            if (((p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1])) != 
                ((p3[0] - p2[0]) * (p3[0] - p2[0]) + (p3[1] - p2[1]) * (p3[1] - p2[1])))
                return false;
            int other = (p3[0] - p4[0]) * (p3[0] - p4[0]) + (p3[1] - p4[1]) * (p3[1] - p4[1]);
            if (other != len) return false;
            temp1[0] = p3[0] - p4[0];
            temp1[1] = p3[1] - p4[1];
            temp2[0] = p2[0] - p1[0];
            temp2[1] = p2[1] - p1[1];
            if (temp1[0] * temp2[0] + temp1[1] * temp2[1] != 0) return false;
        }
        
        if (target == 3) {
            if (((p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1])) != 
                ((p3[0] - p2[0]) * (p3[0] - p2[0]) + (p3[1] - p2[1]) * (p3[1] - p2[1])))
                return false;
            int other = (p2[0] - p4[0]) * (p2[0] - p4[0]) + (p2[1] - p4[1]) * (p2[1] - p4[1]);
            if (other != len) return false;
            temp1[0] = p2[0] - p4[0];
            temp1[1] = p2[1] - p4[1];
            temp2[0] = p3[0] - p1[0];
            temp2[1] = p3[1] - p1[1];
            if (temp1[0] * temp2[0] + temp1[1] * temp2[1] != 0) return false;
        }
        
        if (target == 4) {
            if (((p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1])) != 
                ((p3[0] - p4[0]) * (p3[0] - p4[0]) + (p3[1] - p4[1]) * (p3[1] - p4[1])))
                return false;
            int other = (p3[0] - p2[0]) * (p3[0] - p2[0]) + (p3[1] - p2[1]) * (p3[1] - p2[1]);
            if (other != len) return false;
            temp1[0] = p3[0] - p2[0];
            temp1[1] = p3[1] - p2[1];
            temp2[0] = p4[0] - p1[0];
            temp2[1] = p4[1] - p1[1];
            if (temp1[0] * temp2[0] + temp1[1] * temp2[1] != 0) return false;
        }
        return true;
    }
}