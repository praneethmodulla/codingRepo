class Solution {
    public int largestIsland(int[][] grid) {
        int area = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int areaLabel = 2;
        boolean has = false;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int islandSize = recurse(grid, i, j, areaLabel);
                    map.put(areaLabel, islandSize);
                    areaLabel++;
                }
                if(grid[i][j] == 0){
                    has = true;
                }
            }
        }
        if(!has){
            return grid.length * grid.length;
        }
        int[] dRow = new int[]{-1, 1, 0, 0};
        int[] dCol = new int[]{0, 0, -1, 1};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> visited = new HashSet<>();
                    int areaSum = 1;
                    for(int k = 0; k < 4; k++){
                        int nRow = i + dRow[k];
                        int nCol = j + dCol[k];
                        if(nRow < 0 || nCol < 0 || nRow >= grid.length || nCol >= grid.length){
                            continue;
                        }
                        int label = grid[nRow][nCol];
                        if(label > 1 && !visited.contains(label)){
                            areaSum += map.get(label);
                            visited.add(label);
                        }
                    }
                    area = Math.max(area, areaSum);
                }
            }
        }
        return area;
    }

    public int recurse(int[][] grid, int row, int col, int areaLabel){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return 0;
        }
        if(grid[row][col] == 0 || grid[row][col] == areaLabel){
            return 0;
        }
        grid[row][col] = areaLabel;
        int area = 1;
        int up = recurse(grid, row - 1, col, areaLabel);
        int down = recurse(grid, row + 1, col, areaLabel);
        int left = recurse(grid, row, col - 1, areaLabel);
        int right = recurse(grid, row, col + 1, areaLabel);
        area += up + down + left + right;
        return area;
    }
}