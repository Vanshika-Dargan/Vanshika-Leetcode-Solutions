class Solution {
    int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);

        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;

                int node = i*n+j;

                for(int[] d:dir){
                    int ni=i+d[0], nj=j+d[1];
                    if(ni>=0 && nj>=0 && ni<n && nj<n && grid[ni][nj]==1){
                        ds.union(node,ni*n+nj);
                    }
                }
            }
        }

        // Step 2: Find current max island
        int ans = 0;
        for(int i=0;i<n*n;i++){
            if(ds.findPar(i)==i)
                ans=Math.max(ans,ds.size[i]);
        }

        // Step 3: Try flipping each 0
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;

                HashSet<Integer> set = new HashSet<>();
                int size = 1;

                for(int[] d:dir){
                    int ni=i+d[0], nj=j+d[1];
                    if(ni>=0 && nj>=0 && ni<n && nj<n && grid[ni][nj]==1){
                        int parent = ds.findPar(ni*n+nj);
                        if(set.add(parent))
                            size += ds.size[parent];
                    }
                }

                ans=Math.max(ans,size);
            }
        }

        return ans==0? n*n:ans;
    }
}

class DisjointSet{
    int[] par;
    int[] size;

    DisjointSet(int n){
        par=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            size[i]=1; // mistake 1
        }
    }

    int findPar(int x){
        if(par[x]==x) return x;
        return par[x]=findPar(par[x]);
    }

    void union(int x,int y){
        int px=findPar(x);
        int py=findPar(y);

        if(px==py) return;

        if(size[px]<size[py]){
            par[px]=py;
            size[py]+=size[px];
        }else{
            par[py]=px;
            size[px]+=size[py];
        }
    }
}
