class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();

        for(String word: words){
            for(String other: words){
                if(word == other) continue;
                if(isSubstring(word,other)){
                    ans.add(word);
                    break;
                }
            }
        }
        return ans;
    }

    private boolean isSubstring(String sub,String main){
        for(int i=0;i<main.length();i++){
            boolean subFits=true;
            for(int j=0;j<sub.length();j++){
                if(i+j>=main.length() || main.charAt(i+j)!=sub.charAt(j)){
                    subFits=false;
                    break;
                }
            }
            if(subFits){
                return true;
            }
        }
        return false;
    }
}