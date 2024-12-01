class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

      
      List<List<Integer>> list = new ArrayList<>();


      for(int i=0;i<n;i++){
         list.add(i,new ArrayList<>());
        list.get(i).add(i+1);
      }

      int[] res = new int[queries.length];
      int j=0;
      for(int[] q:queries){
        list.get(q[0]).add(q[1]);
        res[j++]=shortestPath(n,list);
      }
        return res;
    }

    int shortestPath(int n,List<List<Integer>> list){
        Queue<int[]> q = new LinkedList<>();
        boolean[] v=new boolean[n];
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int node[]=q.poll();
            int next=node[0];
            int length=node[1];
           if(next == n-1) return length;

           for(int nei:list.get(node[0])){
            if(!v[nei]){
                q.offer(new int[]{nei,length+1});
                v[nei]=true;
            }
           }
        }
        return -1;
    }
}