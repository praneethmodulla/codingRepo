class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[][] dp = new int[books.length][shelfWidth + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return recurse(books, shelfWidth, 0, shelfWidth, 0, dp);
    }

    public int recurse(int[][] books, int shelfWidthAvail, int idx, int shelfWidth, int levelHeight, int[][] dp){
        if(idx >= books.length){
            return levelHeight;
        }
        if(dp[idx][shelfWidthAvail] != -1){
            return dp[idx][shelfWidthAvail];
        }
        int take = Integer.MAX_VALUE;
        int notTake = Integer.MAX_VALUE;
        if(shelfWidthAvail - books[idx][0] >= 0){
            int newLevelHeight = Math.max(levelHeight, books[idx][1]);
            take = recurse(books, shelfWidthAvail - books[idx][0], idx + 1, shelfWidth, newLevelHeight, dp);
        }
        notTake = levelHeight + recurse(books, shelfWidth - books[idx][0], idx + 1, shelfWidth, books[idx][1], dp);
        return dp[idx][shelfWidthAvail] = Math.min(take, notTake);
    }
}