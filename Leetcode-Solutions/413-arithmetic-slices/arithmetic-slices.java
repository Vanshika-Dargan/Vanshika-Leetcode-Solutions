class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if(n<3) return 0;
        final int min=-1002;
        int curr=min;
        int count=0;
        int ans=0;
        for(int i=1;i<n;i++){ 
            int diff=nums[i]-nums[i-1];
            if(curr==min){
                curr=diff;
                count=1;
            }
            else if(curr==diff){
            count++;
            }
            else{
                ans+=((count-1)*(count))/2;
                count=1;
                curr=diff;
            }
        }
         ans+=((count-1)*(count))/2;
        return ans;
    }
}