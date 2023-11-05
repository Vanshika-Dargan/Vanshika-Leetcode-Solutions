class Solution {
    public int getWinner(int[] arr, int k) {
        
    int max=arr[0];
    for(int i=0;i<arr.length;i++){
        max=Math.max(max,arr[i]);
    }
    int curr_winner=arr[0];
    int count=0;
    for(int i=1;i<arr.length;i++){
    if(curr_winner>arr[i]){
        count++;
    }
    else{
        curr_winner=arr[i];
        count=1;
    }
    if(count==k || curr_winner==max) return curr_winner;
    }
    return -1;
    }
}