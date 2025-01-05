class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int m=s.length();
        int pre[]=new int[m];
        for(int[] shift: shifts){
            int start=shift[0];
            int end=shift[1];
            int dir=shift[2];
            for(int i=start;i<=end;i++){
              pre[i] += (dir == 0) ? -1 : 1;
            }
        }
        StringBuilder sb = new StringBuilder(s);
         for (int i = 0; i < m; i++) {
            int shift = pre[i] % 26;
            if (shift < 0) shift += 26; 
            char newChar = (char) ((s.charAt(i) - 'a' + shift) % 26 + 'a');
            sb.setCharAt(i, newChar);
        }

        return sb.toString();
    }
}