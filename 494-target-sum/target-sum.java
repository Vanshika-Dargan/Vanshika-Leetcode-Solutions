class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int res[]=new int[1];
        helper(0,nums,target,0,res);
        return res[0];
    }

    void helper(int i,int[] nums,int target,int curr,int[] res){
        if(i==nums.length && curr!=target){
            res[0]+=0;
            return;
        }
        else if(i==nums.length && curr==target) {
            res[0]+=1;
            return;
        }

        helper(i+1,nums,target,curr+nums[i],res);
        helper(i+1,nums,target,curr-nums[i],res);
    }
}