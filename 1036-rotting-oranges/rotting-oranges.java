class Solution {
    public boolean isValid(int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n) return false;
        return true;
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
        LinkedList<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        q.add(new int[]{-1,-1});
        int time=-1;
        while(!q.isEmpty()){
            int[] node = q.pop();
            if(node[0]==-1 && node[1]==-1){
                time++;
                if(!q.isEmpty()){
                q.add(new int[]{-1,-1});
                }
                continue;
            }
            for(int d[]:dir){
                int new_i = d[0]+node[0];
                int new_j = d[1]+node[1];
                if(isValid(new_i,new_j,m,n) && grid[new_i][new_j]==1){
                    grid[new_i][new_j]=2;
                    q.add(new int[]{new_i,new_j});
                }
            }
        }
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
    }
}