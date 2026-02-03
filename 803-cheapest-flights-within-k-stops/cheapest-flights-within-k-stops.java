class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        LinkedList<int[]> q = new LinkedList<>();
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int f[]: flights){
        adj.get(f[0]).add(new int[]{f[1],f[2]});
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        q.offer(new int[]{src,0,0});
        while(!q.isEmpty()){
        int node[]=q.poll();
        int no = node[0];
        int d = node[1];
        int stops = node[2];

        if(stops>k) continue;
        for(int ne[]:adj.get(no)){
            int dest = ne[0];
            int cost = ne[1];
            if(dist[dest]>d+cost){
                dist[dest]=d+cost;
                q.offer(new int[]{dest,dist[dest],stops+1});
            }
        }
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];

    }
}