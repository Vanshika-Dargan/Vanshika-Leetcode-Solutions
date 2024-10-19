class Solution {
    public char findKthBit(int n, int k) {
       StringBuilder sb = new StringBuilder("0");

       for(int i=1;i<=n && k>sb.length();i++){
        sb.append('1');
        for(int j=sb.length()-2;j>=0;j--){
            char ch = sb.charAt(j) == '0' ? '1': '0';
            sb.append(ch);
        }
       }

       return sb.charAt(k-1);
    }
}