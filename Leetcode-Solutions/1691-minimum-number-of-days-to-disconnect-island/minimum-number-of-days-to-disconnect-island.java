class Solution {

    private static final int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int minDays(int[][] grid) {
             int m=grid.length;
        int n=grid[0].length;
        int intialCount=noOfIslands(grid);
        if(intialCount !=1) return 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    int newCount=noOfIslands(grid);
                    grid[i][j]=1;
                    if(newCount!=1) return 1;
                }
            }
        }
        return 2;
        
    }

    private int noOfIslands(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int no=0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    dfs(grid,visited,i,j);
                    no+=1;
                }
            }
        }
        return no;
    }

    private void dfs(int[][] grid,boolean[][] visited,int i,int j){
        
        visited[i][j]=true;
        for(int k=0;k<dir.length;k++){
            int new_i=dir[k][0]+i;
            int new_j=dir[k][1]+j;
            if(new_i>=0 && new_i<grid.length && new_j>=0 && new_j<grid[0].length && !visited[new_i][new_j] && grid[new_i][new_j]==1){
            dfs(grid,visited,new_i,new_j);
            }
        }
    }
}