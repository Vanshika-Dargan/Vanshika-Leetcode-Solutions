class Solution {
    public int countServers(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    row[j]++;
                    col[i]++;
                }
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                   if(row[j]>1 || col[i]>1){
                    ans++;
                   }
                }
            }
        }
        return ans;
        
    }
}