class Solution {
    public long maxMatrixSum(int[][] matrix) {
       
       int countNegative=0;
       int lowestNegative=Integer.MAX_VALUE;
       long sum=0;
       for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
           sum+=Math.abs(matrix[i][j]);
            if(matrix[i][j]<0) 
            {

                countNegative+=1;
            }
           lowestNegative=Math.min(lowestNegative,Math.abs(matrix[i][j]));
          
        }
       }
     
       if(countNegative%2==0) return sum;

       return sum-2*lowestNegative;


    }
}