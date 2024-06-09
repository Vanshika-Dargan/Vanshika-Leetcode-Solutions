class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int n=nums.length;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int prefixSum=0;
        for(int i=0;i<n;i++){
        prefixSum+=nums[i];
        int rem=prefixSum%k;
        if(rem<0){
           rem+=k;
        }

        if(map.containsKey(rem)){
            count+=map.get(rem);
        }
        map.put(rem,map.getOrDefault(rem,0)+1);
                
                }

        return count;
        
    }
}