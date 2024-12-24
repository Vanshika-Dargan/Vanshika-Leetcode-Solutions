class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
     
     int d1[]=helper(edges1);
     int d2[]=helper(edges2);
     int diameter1=d1[0]==2?d1[1]*2+1:d1[1]*2;
     int diameter2=d2[0]==2?d2[1]*2+1:d2[1]*2;
     int radius1=d1[0]==2?d1[1]+1:d1[1];
     int radius2=d2[0]==2?d2[1]+1:d2[1];
     return Math.abs(diameter1-diameter2)>2?Math.max(diameter1,diameter2):radius1+radius2+1;
    }

    int[] helper(int[][] edges){

     int n = edges.length+1;
     int indegree[] = new int[n];

     Map<Integer,List<Integer>> graph = new HashMap<>();
     Queue<Integer> q = new LinkedList<>();
     
     for(int i=0;i<n;i++){
        graph.put(i,new ArrayList<>());
     }

     for(int e[]:edges){
        int src=e[0];
        int dest=e[1];
        indegree[src]++;
        indegree[dest]++;
        graph.get(src).add(dest);
        graph.get(dest).add(src);
     }

     for(int i=0;i<n;i++){
        if(indegree[i]==1){
            q.offer(i);
        }
     }
     int cnt=0;
     int level=0;
     while(n-cnt>2){
        int size = q.size();
        level++;
        for(int i=0;i<size;i++){
        int leaf=q.poll();
         cnt++;
        for(int neigh:graph.get(leaf)){
            indegree[neigh]--;
            if(indegree[neigh]==1){   
                q.offer(neigh);
            }
        }
        }
     }
    return new int[]{q.size(),level};
    }
    
}