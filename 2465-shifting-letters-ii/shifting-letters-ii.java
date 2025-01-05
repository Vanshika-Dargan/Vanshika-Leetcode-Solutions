class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int m=s.length();
        int pre[]=new int[m+1];
        for(int[] shift: shifts){
            int start=shift[0];
            int end=shift[1];
            int dir=shift[2];
            if(dir==1){
            pre[start]+=1;
            pre[end+1]-=1;
            }
            else{
            pre[start]-=1;
            pre[end+1]+=1;
            }
        }
        int noOfShifts=0;
        StringBuilder sb = new StringBuilder(s);
         for (int i = 0; i < m; i++) {    
             noOfShifts=noOfShifts + pre[i];
            int shift = noOfShifts % 26;
            if (shift < 0) shift += 26; 
            char newChar = (char) ((s.charAt(i) - 'a' + shift) % 26 + 'a');
            sb.setCharAt(i, newChar);
        }

        return sb.toString();
    }
}