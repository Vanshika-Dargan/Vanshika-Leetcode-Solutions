class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        int in[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int p[]:prerequisites){
            adj.get(p[1]).add(p[0]);
            in[p[0]]++;
        }
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                q.offer(i);
            }
        }
        int courses=0;
        while(!q.isEmpty()){
            int node = q.poll();
            courses++;
            for(int n: adj.get(node)){
                in[n]--;
                if(in[n]==0){
                    q.offer(n);
                }
            }
        }

        return numCourses == courses;

    }
}