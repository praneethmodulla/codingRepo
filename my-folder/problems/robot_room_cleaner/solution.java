/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
    Robot robot;
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void backtrack(int row, int col, int d){
        visited.add(new Pair(row, col));
        robot.clean();
        for(int i = 0; i < 4; i++){
            int newD = (d + i)%4;
            int nRow = row + directions[newD][0];
            int nCol = col + directions[newD][1];

            if(!visited.contains(new Pair(nRow, nCol)) && robot.move()){
                backtrack(nRow, nCol, newD);
                goBack();
            }
            robot.turnRight();
        }
    }
    public void goBack(){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}