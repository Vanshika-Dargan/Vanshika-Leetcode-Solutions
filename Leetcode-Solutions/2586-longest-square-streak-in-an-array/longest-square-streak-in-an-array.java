class Solution {
    public int longestSquareStreak(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],1);
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(seen.contains(nums[i])) continue;
            long searchDouble = (long)nums[i]* nums[i];
            
            int searchHalf=-1;
            int sqrt= (int)Math.sqrt(nums[i]);
            if(sqrt * sqrt == nums[i]){
                searchHalf = sqrt;
            }
            if(map.containsKey(searchHalf)){
              map.put(nums[i],map.get(searchHalf));
            }
            if((searchDouble)<1e5 && map.containsKey((int)searchDouble)){
                map.put(nums[i],(map.get(nums[i])+map.get((int)searchDouble)));
            }
            seen.add(nums[i]);
          
            max = Math.max(max,map.get(nums[i]));
             
        }
        return max==1?-1:max;
    }
}