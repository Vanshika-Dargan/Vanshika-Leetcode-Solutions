class Solution {
    public int maximumSum(int[] nums) {
        
        int sumRange[] = new int[82];
        int ans=-1;
        for(int n:nums){
            int sum=0;
            for(int curr=n;curr!=0;curr/=10){
                sum+=curr%10;
            }
            if(sumRange[sum]>0){
                ans = Math.max(ans,sumRange[sum]+n);
            }
            sumRange[sum]=Math.max(sumRange[sum],n);
        }
        return ans;
    }
}