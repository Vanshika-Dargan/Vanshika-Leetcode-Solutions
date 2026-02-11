class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet dj = new DisjointSet(n);
       for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++){
            if(isConnected[i][j]==1)
           dj.union(i,j);
        }
       }
       int cnt = 0;
       for(int i=0;i<n;i++){
        if(dj.par[i]==i) cnt++;
       }
       return cnt;
    }
}
    class DisjointSet{
    
    int n;
    int par[];
    int rank[];
    
    DisjointSet(int n){
        this.n = n;
        par= new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=0;
        }
    }
    
    int findPar(int node){
       if(node == par[node]) return node;
       return par[node]=findPar(par[node]);
    }
    void union(int u,int v){
        int pu = findPar(u);
        int pv = findPar(v);
        if(pu == pv) return;
        if(rank[pu]<rank[pv]){
            par[pu]=pv;
        }
        else if(rank[pv]<rank[pu]){
            par[pv]=pu;
        }
        else{
          rank[pv]++;
          par[pu]=pv;
        }
    }
}