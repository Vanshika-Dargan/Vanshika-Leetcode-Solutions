class Solution {
    public String sortVowels(String s) {
        int count[]=new int[256];
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i)))
            count[s.charAt(i)]++;
        }
        StringBuilder sb=new StringBuilder();
        int j=0;
        String sorted="AEIOUaeiou";
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                while(count[sorted.charAt(j)]==0) j++;
            sb.append(sorted.charAt(j));
            count[sorted.charAt(j)]--;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
     boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i'
                || c == 'A' || c == 'E' || c == 'O'|| c == 'U'|| c == 'I';
    }
}