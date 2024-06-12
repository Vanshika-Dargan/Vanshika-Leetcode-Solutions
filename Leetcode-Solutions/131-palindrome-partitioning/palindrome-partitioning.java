class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result=new ArrayList<>();
        backtrack(s,new ArrayList<>(),result);
        return result;
    }

    void backtrack(String s,List<String> curr,List<List<String>> result){
        if(s.length()==0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String temp=s.substring(0,i);
            if(isPalindrome(temp)){
            curr.add(temp);

            backtrack(s.substring(i),curr,result);

            curr.remove(curr.size()-1);
            }


        }
    }

    boolean isPalindrome(String s){

        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(s.charAt(i++)!= s.charAt(j--)) return false;
        }
        return true;
    }
}