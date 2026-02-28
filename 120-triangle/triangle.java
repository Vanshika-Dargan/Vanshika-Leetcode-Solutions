class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        List<Integer> dp = new ArrayList<>();
        for(int i:t.get(t.size()-1)){
            dp.add(i);
        }
        for (int i = t.size()-2; i >=0;i--) {
            for (int j = 0; j < t.get(i).size(); j++) {
                int curr = t.get(i).get(j);
                int min = Math.min(dp.get(j), dp.get(j + 1));
                curr += min;
               dp.set(j, curr);
            }
        }
        return dp.get(0);
    }

    int fn(List<List<Integer>> t, int i, int j, List<List<Integer>> dp) {
        if (i == t.size())
            return Integer.MAX_VALUE;
        List<Integer> list = t.get(i);
        if (j >= list.size())
            return Integer.MAX_VALUE;
        List<Integer> curr_dp = dp.get(i);
        if (j <= curr_dp.size() - 1)
            return curr_dp.get(j);
        int curr = list.get(j);
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        left = fn(t, i + 1, j, dp);
        right = fn(t, i + 1, j + 1, dp);
        int min = Math.min(left, right);
        int ans = curr;
        if (min != Integer.MAX_VALUE)
            curr += min;
        curr_dp.add(curr);
        return curr;
    }
}