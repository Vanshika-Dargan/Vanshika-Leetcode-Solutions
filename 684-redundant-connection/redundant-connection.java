class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int i=1;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }
        int[] ans =null;
        for(int edge[]:edges){
            int src=edge[0];
            int dest=edge[1];
            boolean visited[] = new boolean[n];
            if(pathExists(src,dest,graph,visited)){
             ans=new int[]{src,dest};
            }
            else{
                graph.get(src).add(dest);
                graph.get(dest).add(src);
            }
        }

        return ans;

    }
    boolean pathExists(int src,int dest,Map<Integer,List<Integer>> graph,boolean[] v){
        if(src==dest) return true;
     v[src-1]=true;
     for(int n:graph.get(src)){
      if(!v[n-1])
      if(pathExists(n,dest,graph,v)) return true;
     }

     return false;
     

    }
}