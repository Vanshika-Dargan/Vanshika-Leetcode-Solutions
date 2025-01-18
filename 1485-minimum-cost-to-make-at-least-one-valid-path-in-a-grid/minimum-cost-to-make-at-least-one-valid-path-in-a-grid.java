class Solution {
     int dir[][]= {{0,1},{0,-1},{1,0},{-1,0}};
     int mapping[] = {1,2,3,4};
    public int minCost(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean v[][] = new boolean[m][n];
    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
    pq.offer(new Pair(0,0,0));
    
    while(!pq.isEmpty()){
        Pair p = pq.poll();
        if(p.i==m-1 && p.j==n-1) return p.cost;
        if(v[p.i][p.j]) continue;
        v[p.i][p.j] = true;
        for(int i=0;i<dir.length;i++){
            int new_i = p.i + dir[i][0];
            int new_j = p.j + dir[i][1];
            int curr = p.cost;
            if(new_i>=0 && new_i<m && new_j>=0 && new_j<n && !v[new_i][new_j]){
            if(grid[p.i][p.j]== mapping[i]){
                pq.offer(new Pair(new_i,new_j,curr));
            }
            else{
                pq.offer(new Pair(new_i,new_j,curr+1));
            }
            }
        }
    }
    return 0;
    }
    class Pair{
        int i;
        int j;
        int cost;
        Pair(int i,int j,int cost){
        
        this.i=i;
        this.j=j;
        this.cost=cost;
        }
    }
}