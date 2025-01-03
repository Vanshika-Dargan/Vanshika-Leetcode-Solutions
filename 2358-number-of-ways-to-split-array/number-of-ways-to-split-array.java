class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        long pre[]=new long[n];
        long suf[]=new long[n];
        pre[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        suf[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suf[i]=suf[i+1] + nums[i];
        }
       int count=0;
       
        for(int i=0;i<n-1;i++){
            if(pre[i]>=suf[i+1]) count+=1;
        }
        return count;
    }
}