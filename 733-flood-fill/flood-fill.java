class Solution {
    public boolean isValid(int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n) return false;
        return true;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int originalColor = image[sr][sc];
         image[sr][sc]=color;
        while(!q.isEmpty()){
            int node[]=q.poll();
            for(int d[]:dir){
                int new_i=d[0]+node[0];
                int new_j = d[1]+node[1];
                if(isValid(new_i,new_j,m,n) && image[new_i][new_j]==originalColor && image[new_i][new_j]!=color){
                    image[new_i][new_j]=color;
                    q.offer(new int[]{new_i,new_j});
                }
            }
        }
    return image;
    }
}