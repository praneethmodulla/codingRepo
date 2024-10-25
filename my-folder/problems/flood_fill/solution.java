class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor == color){
            return image;
        }
        recurse(image, sr, sc, originalColor, color);
        return image;
    }

    public void recurse(int[][] image, int sr, int sc, int originalColor, int color){
        if(sr >= image.length || sr < 0){
            return;
        }
        if(sc >= image[0].length || sc < 0){
            return;
        }
        if(image[sr][sc] == originalColor){
            image[sr][sc] = color;
            recurse(image, sr + 1, sc, originalColor, color);
            recurse(image, sr - 1, sc, originalColor, color);
            recurse(image, sr, sc + 1, originalColor, color);
            recurse(image, sr, sc - 1, originalColor, color);
        }
        return;
    }
}