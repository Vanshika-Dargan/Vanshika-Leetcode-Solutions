class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean v[]=new boolean[V];
        boolean p[]=new boolean[V];
        int check[] = new int[V];
        for(int i=0;i<V;i++){
            if(!v[i]){
                dfs(i,v,p,graph,check);
            }
        }
        List<Integer> safeNode = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]==1) safeNode.add(i);
        }
        return safeNode;
    }
    public boolean dfs(int node, boolean[] v, boolean[] p, int[][] graph, int[] check){
        v[node]=true;
        p[node]=true;
        for(int n: graph[node]){
            if(!v[n]){
                if(dfs(n,v,p,graph,check)) {
                    check[node]=0;
                    return true;
                }
            }
            else if(p[n]) {
                check[node]=0;
                return true;
            }
        }
        check[node]=1;
        p[node]=false;
        return false;
    }
}