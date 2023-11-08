class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0;
        int count=0;
        int last=nums[0];
        for(int i=0;i<nums.length;i++){
        if(nums[i]==last && count<2){
            int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
            count++;
            j++;
        }
        else if(nums[i]!=last){
            last=nums[i];
            int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
            j++;
            count=1; 
        }
        }
        return j;
    }
}