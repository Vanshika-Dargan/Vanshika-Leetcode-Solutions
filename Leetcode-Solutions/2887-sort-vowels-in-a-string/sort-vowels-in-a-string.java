class Solution {
    public String sortVowels(String s) {
        int n=s.length();
        List<Character> vowels=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isVowel(s.charAt(i)))
            {
            vowels.add(s.charAt(i));
            }
        }
        Collections.sort(vowels,(a,b)->a-b);
        StringBuilder sb=new StringBuilder();
        int j=0;
        for(int i=0;i<n;i++){
        if(isVowel(s.charAt(i))){
            sb.append(vowels.get(j++));
        }
        else{
            sb.append(s.charAt(i));
        }
        }
        return sb.toString();
    }
       boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'
        || ch=='A' || ch=='E' || ch=='I'|| ch=='O' || ch=='U'
        )
        return true;
        return false;
    }
}
