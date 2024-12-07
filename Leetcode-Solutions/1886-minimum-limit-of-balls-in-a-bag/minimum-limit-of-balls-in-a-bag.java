class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        

        int left=1;
        int right=0;
        for(int n:nums){
        right=Math.max(right,n);
        }
       
       while(left<right){
        int mid=(left+right)/2;
        if(isPossible(mid,nums,maxOperations)){
            right=mid;
        }
        else{
            left=mid+1;
        }
       }

       return left;
    }
    boolean isPossible(int maxBalls,int[] nums,int maxOpr){
        int opr=0;
        for(int n:nums){
            opr+=(int)Math.ceil(n/(double)maxBalls)-1;
            if(opr>maxOpr) return false;
        }
        return true;
    
    }

   

}