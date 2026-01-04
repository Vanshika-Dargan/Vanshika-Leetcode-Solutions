class Solution {
    public boolean isValid(int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m ||j>=n) return false;
        return true;
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean v[][] = new boolean[m][n];
        LinkedList<int[]> q = new LinkedList<>();
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && (i==0 || j==0 || i==m-1 || j==n-1)){
                    q.offer(new int[]{i,j});
                    v[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            int node[]=q.poll();
            for(int d[]:dir){
                int new_i = d[0]+node[0];
                int new_j = d[1]+node[1];
                if(isValid(new_i,new_j,m,n) && board[new_i][new_j]=='O' && !v[new_i][new_j]){
                    q.offer(new int[]{new_i,new_j});
                    v[new_i][new_j]=true;
                }
            }
        }
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(board[i][j]=='O' && !v[i][j]){
                    board[i][j]='X';
                }
            }
        }
        }
}