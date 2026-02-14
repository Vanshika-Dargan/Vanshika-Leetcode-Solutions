class Solution {
    public int removeStones(int[][] stones) {
        
        int maxRow=0;
        int maxCol =0;
        int n = stones.length;
        for(int s[]:stones){
            maxRow = Math.max(maxRow,s[0]);
            maxCol = Math.max(maxCol,s[1]);
        }
        DisjointSet dj = new DisjointSet(maxRow + maxCol + 2);
       Set<Integer> used = new HashSet<>();
        
         for(int s[]:stones){
                    dj.union(s[0],s[1]+maxRow+1);
                    used.add(s[0]);
                    used.add(s[1]+maxRow+1);
            }
            int cnt =0;
        for(int node: used){
            if(dj.findPar(node) == node) cnt++;
        }

        return n - cnt;
    
    }
}

class DisjointSet {
    int n;
    int par[];
    int size[];

DisjointSet(int n){
    this.n = n;
    par=new int[n];
    size=new int[n];
    for(int i=0;i<n;i++){
        par[i]=i;
        size[i]=1;
    }
}

    int findPar(int x){
        if(par[x]==x) return x;
        return par[x]=findPar(par[x]);
    }

    boolean union(int x, int y){
        int px = findPar(x);
        int py = findPar(y);

        if(px == py) return false;

        if(size[px]<size[py]){
            par[px]=py;
            size[py]+=size[px];
        }
        else{
            par[py]=px;
            size[px]+=size[py];
        }
        return true;
    }
}