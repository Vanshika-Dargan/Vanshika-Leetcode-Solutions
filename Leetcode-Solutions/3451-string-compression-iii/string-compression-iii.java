class Solution {
    public String compressedString(String word) {
        
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<word.length();){
            char ch = word.charAt(i);
            int count=1;
            int j=i+1;
            for(;j<word.length();j++){
                char ch2=word.charAt(j);
                if(ch==ch2 && count<9) count+=1;
                else break;
            }
            i=j;
            sb.append(count);
            sb.append(ch);
        }
        return sb.toString();
    }
}