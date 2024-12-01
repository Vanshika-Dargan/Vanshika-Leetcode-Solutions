class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        Map<Integer,Integer> in=new HashMap<>();
        Map<Integer,Integer> out=new HashMap<>();

        Map<Integer,Stack<Integer>> neighbours = new HashMap<>();


        for(int p[]:pairs){

            int first=p[0];
            int second=p[1];

            out.put(first,out.getOrDefault(first,0)+1);
            in.put(second,in.getOrDefault(second,0)+1);

           neighbours.computeIfAbsent(first,k->new Stack<>()).add(second);
        }
        int start=-1;
        
        for(int node: out.keySet()){
        if(out.get(node) == in.getOrDefault(node,0)+1){
            start=node;
            break;
        }
        }
        if(start == -1) start=pairs[0][0];
        List<Integer> result = new ArrayList<>();
        postOrderDfs(start,neighbours,result);
        
        int ans[][]=new int[pairs.length][2];
        Collections.reverse(result);
        for(int i=0;i<result.size()-1;i++){
        
        ans[i][0]=result.get(i);
        ans[i][1]=result.get(i+1);
        }

        return ans;
    }

    void postOrderDfs(int start,Map<Integer,Stack<Integer>> neighbours,List<Integer> result){

        Stack<Integer> nList=neighbours.get(start);

        while(nList!=null && !nList.isEmpty()){
            int next=nList.pop();
            postOrderDfs(next,neighbours,result);
        }
        result.add(start);
    }
}