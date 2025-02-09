class Solution {
    public long countBadPairs(int[] nums) {
        long badPairs=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff=nums[i]-i;
            int goodPairs=map.getOrDefault(diff,0);
            badPairs+=i-goodPairs;
            map.put(diff,goodPairs+1);
        }
            return badPairs;
    }


}