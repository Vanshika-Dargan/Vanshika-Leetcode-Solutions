class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<List<Integer>> adjRev = new ArrayList<>();
        int V = graph.length;
        int in[] = new int[V];
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjRev.get(graph[i][j]).add(i);
                in[i]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int n : adjRev.get(node)) {
                in[n]--;
                if (in[n] == 0)
                    q.offer(n);
            }
        }
        Collections.sort(res);
        return res;

    }
}