class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
    if(n==1) return 1;
    Map<Integer,List<Integer>> adj = new HashMap();
    Queue<Integer> q = new LinkedList<>();
    int in[]=new int[n];
    long value[]=new long[n];
    for(int i=0;i<n;i++){
        value[i]=values[i];
    }
    
    for(int i=0;i<n;i++){
        adj.put(i,new ArrayList<>());

    }
    for(int e[]:edges){
        adj.get(e[0]).add(e[1]);
        adj.get(e[1]).add(e[0]);
        in[e[0]]++;
        in[e[1]]++;
    }

    for(int i=0;i<n;i++){
    if(in[i]==1){
        q.offer(i);
    }
    }

    int ans=0;

    while(!q.isEmpty()){
        int node = q.poll();
        long sum=0;
        sum+=value[node];
        if(sum%k==0) ans++;

        for(int parent:adj.get(node)){
         value[parent]+=value[node];
            in[parent]--;

      
      
        if(in[parent]==1){
            q.offer(parent);
        }
       
    }
    }

    return ans;
    }

    }