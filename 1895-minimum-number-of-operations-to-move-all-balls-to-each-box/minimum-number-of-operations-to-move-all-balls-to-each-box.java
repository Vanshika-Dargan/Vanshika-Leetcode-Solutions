class Solution {
    public int[] minOperations(String boxes) {
        

        int n = boxes.length();
        int ans[] = new int[n];
        int leftBallCount=0,leftCount=0,rightBallCount=0,rightCount=0;
        for(int i=0;i<n;i++){
         ans[i]+=leftCount;
         leftBallCount+=boxes.charAt(i)-'0';
         leftCount+=leftBallCount;

         ans[n-i-1]+=rightCount;
         rightBallCount+=boxes.charAt(n-i-1)-'0';
         rightCount+=rightBallCount;
        }
        return ans;
    }
}