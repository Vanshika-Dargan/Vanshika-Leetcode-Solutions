class Solution {
    public String longestDiverseString(int a, int b, int c) {
       PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(y.count, x.count));
        if (a > 0) pq.offer(new Pair(a, 'a'));
        if (b > 0) pq.offer(new Pair(b, 'b'));
        if (c > 0) pq.offer(new Pair(c, 'c'));
        
        String ans="";

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int count = p.count;
            char ch = p.ch;

                if(ans.length()>=2 && ch == ans.charAt(ans.length()-1) && ch == ans.charAt(ans.length()-2)){
                    if(pq.isEmpty()) break;
                Pair new_p = pq.poll();
                ans+=new_p.ch;
                if(new_p.count-1>0){
                    pq.add(new Pair(new_p.count-1,new_p.ch));
                }
                }
                else{
                    count--;
                   ans+=p.ch; 
                }
                if(count>0){
                pq.offer(new Pair(count,ch));
                }
                }
        return ans;
    }
    class Pair{
        int count;
        char ch;
        Pair(int count,char ch){
            this.count=count;
            this.ch=ch;
        }
    }
}