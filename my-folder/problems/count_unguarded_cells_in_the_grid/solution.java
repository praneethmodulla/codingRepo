class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        for(char[] row : grid){
            Arrays.fill(row, '1');
        }
        for(int i = 0; i < guards.length; i++){
            int row = guards[i][0];
            int col = guards[i][1];
            grid[row][col] = 'G';
        }

        for(int i = 0; i < walls.length; i++){
            int row = walls[i][0];
            int col = walls[i][1];
            grid[row][col] = 'W';
        }

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 'G'){
                    write(i, j, grid);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 'G' && grid[i][j] != 'W' && grid[i][j] != 'O'){
                    count++;
                }
            }
        }
        return count;
    }

    public void write(int row, int col, char[][] grid){
        // Go down
        int i = row + 1;
        int j = col;
        while(i < grid.length){
            if(grid[i][j] == '1'){
                grid[i][j] = 'O';
            } else if(grid[i][j] == 'O'){
                i++;
                continue;
            } else {
                break;
            }
            i++;
        }

        i = row - 1;
        // gO uP
        while(i >= 0){
            if(grid[i][j] == '1'){
                grid[i][j] = 'O';
            } else if(grid[i][j] == 'O'){
                i--;
                continue;
            } else {
                break;
            }
            i--;
        }
        i = row;
        // Go left
        j = col - 1;
        while(j >= 0){
            if(grid[i][j] == '1'){
                grid[i][j] = 'O';
            } else if(grid[i][j] == 'O'){
                j--;
                continue;
            } else {
                break;
            }
            j--;
        }
        j = col + 1;
        // go right
        while(j < grid[0].length){
            if(grid[i][j] == '1'){
                grid[i][j] = 'O';
            } else if(grid[i][j] == 'O'){
                j++;
                continue;
            } else {
                break;
            }
            j++;
        } 
    }
}