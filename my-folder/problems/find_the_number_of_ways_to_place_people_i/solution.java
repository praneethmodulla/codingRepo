class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a,b) -> {
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });
        int count = 0;
        for(int i = 0; i < points.length; i++){
            int minY = Integer.MIN_VALUE;
            for(int j = i + 1; j < points.length; j++){
                if(points[i][1] >= points[j][1]){
                    if(points[j][1] > minY){
                        count++;
                        minY = points[j][1];
                    }
                }
            }
        }
        return count;
    }
}