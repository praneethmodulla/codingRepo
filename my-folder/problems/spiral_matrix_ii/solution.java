class Solution {
    public int[][] generateMatrix(int n) {
        int k = 1;
        int j = 0;
        int i = 0;
        int colLimit = n - 1;
        int leftCol = 0;
        int topRow = 0;
        int rowLimit = n - 1;
        int[][] board = new int[n][n];
        boolean right = true;
        boolean down = false;
        boolean left = false;
        boolean up = false;
        while(k <= n * n){
            if(right){
                while(j >= leftCol && j <= colLimit){
                    board[i][j] = k;
                    j++;
                    k++;
                }
                right = false;
                down = true;
                i++;
                topRow++;
                j = colLimit;
            } else if(down){
                while(i >= topRow && i <= rowLimit){
                    board[i][j] = k;
                    i++;
                    k++;
                }
                down = false;
                left = true;
                colLimit--;
                j = colLimit;
                i = rowLimit;
            } else if(left){
                while(j >= leftCol && j <= colLimit){
                    board[i][j] = k;
                    j--;
                    k++;
                }
                rowLimit--;
                i = rowLimit;
                left = false;
                up = true;
                j = leftCol;
            } else if(up){
                while(i >= topRow && i <= rowLimit){
                    board[i][j] = k;
                    i--;
                    k++;
                }
                leftCol++;
                j = leftCol;
                right = true;
                up = false;
                i = topRow;
            }
        }
        return board;
    }
}