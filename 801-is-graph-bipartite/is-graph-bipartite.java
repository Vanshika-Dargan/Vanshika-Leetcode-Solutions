class Solution {
    public boolean isComponentBipartite(LinkedList<Integer> q, int v[], int [][] graph, int start){
        q.offer(start);
        v[start]=0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int ne: graph[node]){
                if(v[ne]==-1){
                    v[ne]= 1 - v[node];
                    q.offer(ne);
                }
                else if (v[ne] == v[node]) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) { 
        int n = graph.length;
        int v[]=new int[n];
        for(int i=0;i<n;i++){
            v[i]=-1;
        }
        LinkedList<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(v[i]==-1)
            if(!isComponentBipartite(q,v,graph,i)) return false;
        }
        return true;

    }
}