class Solution {
    public boolean isValid(int i, int j, int m, int n){
        return !(i<0 || j<0 || i>=m || j>=n);
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
        boolean v[][]=new boolean[m][n];
        LinkedList<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && (i==0 || i==m-1 || j==0 || j==n-1)){
                q.offer(new int[]{i,j});
                v[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            int node[]=q.poll();
            for(int d[]:dir){
                int new_i=node[0]+d[0];
                int new_j=node[1]+d[1];
                if(isValid(new_i,new_j,m,n) && grid[new_i][new_j]==1 && !v[new_i][new_j]){
                    v[new_i][new_j]=true;
                    q.offer(new int[]{new_i,new_j});
                }
            }
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !v[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}