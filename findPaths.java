public class Solution {
    HashMap hm = new HashMap();
    public int findPaths(int m, int n, int N, int i, int j) {
        // Base case
        if (i < 0 || j < 0 || i >= m || j >= n) return 0;
        if (m - 1 - i >= N && n - 1 - j >= N && i >= N && j >= N) return 0;
        if (N == 0) return 0;
        
        if (N == 1) {
            String pos = String.format("%d, %d", i, j);
            hm.put(pos, 1);
            int count = 0;
            if (i - N < 0) count++;
            if (i + N == m) count++;
            if (j - N < 0) count++;
            if (j + N == n) count++;
            return count;
        } else {
            int count = 0;
            while (N >= 1) {
                String pos1 = String.format("%d, %d", i - 1, j);
                String pos2 = String.format("%d, %d", i + 1, j);
                String pos3 = String.format("%d, %d", i, j - 1);
                String pos4 = String.format("%d, %d", i, j + 1);
                if (hm.get(pos1) == null) count += findPaths(m, n, N - 1, i - 1, j);
                if (hm.get(pos2) == null) count += findPaths(m, n, N - 1, i + 1, j);
                if (hm.get(pos3) == null) count += findPaths(m, n, N - 1, i, j - 1);
                if (hm.get(pos4) == null) count += findPaths(m, n, N - 1, i, j + 1);
                count += findPaths(m, n, N - 1, i, j);
                N--;
            }
            return count;
        }
    }
}