class Solution {
    public int countTriplets(int[] arr) {

       int i=0;
       int count=0;
       int n=arr.length;
        int a=arr[i];
        while(i<n){
        a=arr[i];
        int j=i+1;
       while(j<n){
         int b=arr[j];
        if(a==b) count++;
        for(int k=j+1;k<n;k++){
            b=b^arr[k];
           if(a==b) count++;
        }
        a=a^arr[j];
        j++;
       }
       i++;
        }
       return count;
    }
}