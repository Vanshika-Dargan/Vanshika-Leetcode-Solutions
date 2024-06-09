class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int n=nums.length;
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
        sum+=nums[i];
        int mod=sum%k;
        if(map.containsKey(mod)){
            int j=map.get(mod);
            if(i-j>1) return true;
        }
        else{
        map.put(mod,i);
        }
        }
        return false;
    }
}