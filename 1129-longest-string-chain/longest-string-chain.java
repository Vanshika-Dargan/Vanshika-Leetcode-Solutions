class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPre(words[i], words[j]) && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }

    public boolean isPre(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len2 >= len1)
            return false;
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(j);
            if (c1 == c2) {
                count++;
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (count == len2 && len1 - len2 == 1)
            return true;
        return false;

    }
}
