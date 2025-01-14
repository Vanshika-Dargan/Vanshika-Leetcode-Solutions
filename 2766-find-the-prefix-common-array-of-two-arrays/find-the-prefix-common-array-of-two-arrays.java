class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        int[] freq = new int[51];
        int n = A.length;
        int ans[] = new int[n];
        ans[0]=0;
        for(int i=0;i<n;i++){
        freq[A[i]]+=1;
        freq[B[i]]+=1;
        for(int j=1;j<51;j++){
        if(freq[j]%2==0){
            ans[i]+=freq[j]/2;
        }
        }
        
        }
        return ans;
    }
}