class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;
        int outdegree[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
         List<Integer> ans = new ArrayList<>();
         Map<Integer,List<Integer>> map = new HashMap<>();
         for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
         }
        for(int i=0;i<n;i++){
                outdegree[i]+=graph[i].length;
                if(outdegree[i]==0){
                    q.offer(i);
                    ans.add(0,i);
                }
                for(int j=0;j<graph[i].length;j++){
                   List<Integer> neigh = map.get(graph[i][j]);
                   neigh.add(i);
                   map.put(graph[i][j],neigh);
                }
        }
       
        while(!q.isEmpty()){
        int curr = q.poll();
        for(int nei:map.get(curr)){
            outdegree[nei]-=1;
            if(outdegree[nei]==0){
                q.offer(nei);
                ans.add(nei);
            }
        }
        }
        Collections.sort(ans);
        return ans;
    }
}