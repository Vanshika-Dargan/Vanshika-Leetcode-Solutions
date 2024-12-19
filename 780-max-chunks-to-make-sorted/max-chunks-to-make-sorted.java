class Solution {
    public int maxChunksToSorted(int[] arr) {
     
     int n=arr.length;
     int min=0;
     int max=-1;
     int currSize=0;
     int size=0;
     int res=0;
     for(int i=0;i<arr.length;i++){
        min=Math.min(min,arr[i]);
        max=Math.max(max,arr[i]);
        size=max-min+1;
        if(min<=arr[i] && arr[i]<=max){
            currSize+=1;
        }
        if(currSize==size){
            res+=1;
            currSize=0;
            if(i+1<arr.length){
                min=i+1;
            }
        }
     }
     return res;



    }
}