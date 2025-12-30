class Solution {
    static int dir[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    public boolean isValid(int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n) return false;
        return true;
    }
    public int[][] dfs(int[][] image, int i, int j, int m, int n,int color,int originalColor) {
        image[i][j]=color;
                for(int d[]:dir){
                    int new_i=d[0]+i;
                    int new_j = d[1]+j;
                    if(isValid(new_i,new_j,m,n) && image[new_i][new_j]==originalColor && image[new_i][new_j]!=color){
                        dfs(image,new_i,new_j,m,n,color,originalColor);
                    }
                }
                return image;
            }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        return dfs(image,sr,sc,m,n,color,image[sr][sc]);
    }
}