class Solution {
    public void sortColors(int[] nums) {
       
       int forward=0;
       int zero=0;
       int two=nums.length-1;

       while(forward<=two){

        if(nums[forward]==0){
            int temp=nums[forward];
            nums[forward]=nums[zero];
            nums[zero]=temp;
            forward++;
            zero++;
        }
        else if(nums[forward]==1){
            forward++;
        }
        else{
            int temp=nums[forward];
            nums[forward]=nums[two];
            nums[two]=temp;
            two--;
        }
       }
    }
}