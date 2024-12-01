class Solution {
    private final int[][] dir = {
        { 0, 1 },
        { 0, -1 },
        { 1, 0 },
        { -1, 0 },
    };
    public int minimumObstacles(int[][] grid) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
      
        int m=grid.length;
        int n=grid[0].length;
        int min[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                min[i][j]=Integer.MAX_VALUE;
            }
        }
        min[0][0]=grid[0][0];
        pq.add(new int[]{0,0,0});
        
        while(!pq.isEmpty()){
         
         int[] node=pq.poll();
         int row=node[0];
         int col=node[1];
         int obstacles=node[2];

         if(row==m-1 && col==n-1) return obstacles;

         for(int d[]:dir){
            int new_row=row+d[0];
            int new_col=col+d[1];
            
            if(new_row>=0 && new_row<m && new_col>=0 && new_col<n){

                
                 int new_obstacles = obstacles + grid[new_row][new_col];
                 if(new_obstacles<min[new_row][new_col]){
                    min[new_row][new_col]=new_obstacles;
                pq.add(new int[]{new_row,new_col,obstacles+grid[new_row][new_col]});
                 }
            }

         }
        }
        return -1;
    }
}