class Solution {
    public int minimumTime(int[][] grid) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int m=grid.length;
        int n=grid[0].length;
         boolean [][] v = new boolean[m][n];
        pq.offer(new int[]{0,0,0});
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
          if (grid[0][1] > 1 && grid[1][0] > 1){           
            return -1;
        }

        while(!pq.isEmpty()){
            int node[] =pq.poll();
            int i=node[0];
            int j=node[1];
            int time=node[2];
            if(i==grid.length-1 && j==grid[0].length-1) return time;
            if(v[i][j]) continue;
            v[i][j]=true;
            for(int d[]:dir){
                int new_i=d[0]+i;
                int new_j=d[1]+j;

                if(new_i>=0 && new_j>=0 && new_i<grid.length && new_j<grid[0].length && !v[new_i][new_j]){
                    int new_time=0;
                    int diff=grid[new_i][new_j]-time;
                    if(diff<=1) new_time=time+1;
                    else new_time=time+1+(diff/2)*2;
                    pq.offer(new int[]{new_i,new_j,new_time});
                }
            }
        }

        return -1;

    }
}