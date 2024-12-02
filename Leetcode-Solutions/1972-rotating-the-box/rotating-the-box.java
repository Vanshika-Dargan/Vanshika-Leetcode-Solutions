import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public char[][] rotateTheBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        char[][] boxGrid = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boxGrid[i][j] = grid[m - 1 - j][i];
            }
        }

        for (int j = 0; j < m; j++) {
            int emptyRow = n - 1; 
            for (int i = n - 1; i >= 0; i--) {
                if (boxGrid[i][j] == '#') {
                    boxGrid[i][j] = '.';
                    boxGrid[emptyRow][j] = '#';
                    emptyRow--;
                } else if (boxGrid[i][j] == '*') {
                    emptyRow = i - 1;
                }
            }
        }

        return boxGrid;
    }
}
