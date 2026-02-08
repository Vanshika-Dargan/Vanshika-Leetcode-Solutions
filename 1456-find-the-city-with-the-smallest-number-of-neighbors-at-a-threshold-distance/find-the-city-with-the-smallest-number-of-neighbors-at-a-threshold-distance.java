class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int cost[][]=new int[n][n];

        for(int row[]:cost){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            cost[i][i]=0;
        }
        for(int edge[]:edges){
            cost[edge[0]][edge[1]]=edge[2];
            cost[edge[1]][edge[0]]=edge[2];
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if (cost[i][k] != Integer.MAX_VALUE && cost[k][j] != Integer.MAX_VALUE){
                    cost[i][j]=Math.min(cost[i][j],cost[i][k]+cost[k][j]);
                    }
                }
            }
        }
        int ans = -1;
        int min = n;
        for(int i=0;i<n;i++){
            int curr = 0;
            for(int j=0;j<n;j++){
                if(i!=j && cost[i][j]<=distanceThreshold){
                    curr+=1;
                }
            }
            if(curr<=min) {
            ans = i;
            min = curr;
            }
        }
    return ans;
    }
}