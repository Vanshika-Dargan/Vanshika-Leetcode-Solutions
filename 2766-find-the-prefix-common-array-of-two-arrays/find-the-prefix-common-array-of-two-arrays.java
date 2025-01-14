class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int[] freq = new int[51];
        int n = A.length;
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            freq[A[i]] += 1;
            freq[B[i]] += 1;
            
            if(freq[A[i]]==2) ans[i]+=1;
            if(freq[B[i]]==2) ans[i]+=1;
            if(A[i]==B[i]) ans[i]-=1;
            ans[i]+=i-1>=0?ans[i-1]:0;
            }
        return ans;
    }
}