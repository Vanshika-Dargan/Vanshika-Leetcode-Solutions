class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        
        HashMap<Integer,int[]> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }

        int rowCount[] = new int[m];
        int colCount[] = new int[n];

        for(int i=0;i<arr.length;i++){

            int[] c = map.get(arr[i]);
            rowCount[c[0]]+=1;
            colCount[c[1]]+=1;
            if(rowCount[c[0]]==n || colCount[c[1]] ==m)
            return i;
        }
        return -1;
    }
}