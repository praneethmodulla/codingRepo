class Pair {
    String board;
    int steps;
    public Pair(String _board, int _steps){
        this.board = _board;
        this.steps = _steps;
    }
}
class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        HashSet<String> set = new HashSet<>();
        String start = buildString(board);
        set.add(start);
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> Integer.compare(a.steps, b.steps));
        queue.add(new Pair(start, 0));
        int[] delta = new int[]{-1, 1};
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.board.equals(target)){
                return p.steps;
            }
            int[][] interBoard = new int[2][3];
            int k = 0;
            int zeroRow = 0;
            int zeroCol = 0;
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 3; j++){
                    interBoard[i][j] = p.board.charAt(k) - '0';
                    k++;
                    if(interBoard[i][j] == 0){
                        zeroRow = i;
                        zeroCol = j;
                    }
                }
            }

            for(int i = 0; i < delta.length; i++){
                int newRow = zeroRow + delta[i];
                if(newRow == 2 || newRow < 0){
                    continue;
                }
                int temp = interBoard[newRow][zeroCol];
                interBoard[zeroRow][zeroCol] = temp;
                interBoard[newRow][zeroCol] = 0;
                String config = buildString(interBoard);
                interBoard[zeroRow][zeroCol] = 0;
                interBoard[newRow][zeroCol] = temp;
                if(!set.contains(config)){
                    set.add(config);
                    queue.add(new Pair(config, p.steps + 1));
                }
            }
            for(int i = 0; i < delta.length; i++){
                int newCol = zeroCol + delta[i];
                if(newCol == 3 || newCol < 0){
                    continue;
                }
                int temp = interBoard[zeroRow][newCol];
                interBoard[zeroRow][zeroCol] = temp;
                interBoard[zeroRow][newCol] = 0;
                String config = buildString(interBoard);
                interBoard[zeroRow][zeroCol] = 0;
                interBoard[zeroRow][newCol] = temp;
                if(!set.contains(config)){
                    set.add(config);
                    queue.add(new Pair(config, p.steps + 1));
                }
            }
        }
        return -1;
    }

    public String buildString(int[][] board){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                sb.append(String.valueOf(board[i][j]));
            }
        }
        return sb.toString();
    }
}