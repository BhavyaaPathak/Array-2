// TC - O(m*n)
// SC - O(1)
class GameOfLife {

    int[][] dirs;
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int cnt = countAlive(board, i, j, m, n);
                if(board[i][j] == 1 && (cnt < 2 || cnt > 3)) {
                    board[i][j] = 2;
                }
                if(board[i][j] == 0 && cnt == 3) {
                    board[i][j] = 3;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public int countAlive(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        for(int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 2)) {
                count++;
            }
        }
        return count;
    }
}