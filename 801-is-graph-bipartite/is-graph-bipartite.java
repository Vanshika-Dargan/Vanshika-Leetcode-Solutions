class Solution {
    public boolean dfs(int curr, int[] v, int[][] graph, int prev){
        v[curr] = 1-v[prev];
        for(int n: graph[curr]){
            if(v[n] == -1){
                if(!dfs(n,v,graph,curr)) return false;
            }
            else if(v[n]==v[curr]) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int v[] = new int[n+1];
        for(int i=0;i<=n;i++){
            v[i]=-1;
        }
        v[n]=0;
        for(int i=0;i<graph.length;i++){
            if(v[i]==-1){
                if(!dfs(i,v,graph,n)) return false;
            }
        }
        return true;
    }
}