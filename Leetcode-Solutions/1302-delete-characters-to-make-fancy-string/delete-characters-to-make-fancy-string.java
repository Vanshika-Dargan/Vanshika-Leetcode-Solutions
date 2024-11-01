class Solution {
    public String makeFancyString(String s) {

       StringBuffer sb = new StringBuffer();

       for(int i=0;i<s.length();){
        char ch = s.charAt(i);
        int j = i+1;
        while(j<s.length() && s.charAt(j)==ch){
        j++;
        }
        if(j-i >1) {
            sb.append(ch);
            sb.append(ch);
        }
        else{
            sb.append(ch);
        }
        i=j;
       }
       return sb.toString();
    }
}