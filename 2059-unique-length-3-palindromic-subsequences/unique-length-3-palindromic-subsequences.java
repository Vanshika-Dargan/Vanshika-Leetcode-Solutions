class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int left[] = new int[26];
        int total[] = new int[26];
        boolean visited[][] = new boolean[26][26];

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            total[ch] += 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int mid = s.charAt(i) - 'a';
            for (char range = 'a'; range <= 'z'; range++) {
                int r = range - 'a';
                boolean exp = false;
                if (r == mid) {
                    exp = total[r] - 1 - left[r]>0;
                } else {
                    exp = total[r] - left[r]>0;
                }
                if (!visited[r][mid] && left[r] > 0 && exp) {
                    count += 1;
                    visited[r][mid] = true;

                }
            }
            left[mid] += 1;
        }

        return count;
    }
}
