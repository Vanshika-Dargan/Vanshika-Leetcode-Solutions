class Solution {
    public int maxUniqueSplit(String s) {
        
        Set<String> set = new HashSet<>();
        return backtrack(set,s,0);

    }
    int backtrack(Set<String> set,String s,int start){
        if(start==s.length()) return 0;
        int max=0;
        for(int end=start+1;end<=s.length();end++){
            String str = s.substring(start,end);
            if(!set.contains(str)){
            set.add(str);
            int front=backtrack(set,s,end);
            set.remove(str);
            max = Math.max(max, 1+front);
            }
        }
        return max;

    }
}