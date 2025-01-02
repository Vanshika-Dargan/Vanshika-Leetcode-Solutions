class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] pre = new int[n];

        for(int i=0;i<n;i++){
            pre[i]=i-1>=0?pre[i-1]:0;
        if(startEndWithVowel(words[i])){
            pre[i]+=1;
        }
        }
        int res[] = new int[queries.length];
        int i=0;
        for(int[] q: queries){
        if(q[0]!=0){
            res[i++]=pre[q[1]]-pre[q[0]-1];
        }
        else{
              res[i++]=pre[q[1]];
        }
        }

        return res;
    }
    boolean startEndWithVowel(String word){
    if(isVowel(word.charAt(0)) && isVowel(word.charAt(word.length()-1))) return true;
    return false;
    }
    boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') return true;
        return false;
    }
}