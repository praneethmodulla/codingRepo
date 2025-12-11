class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int ans = 0;
        HashMap<Integer, int[]> xmap = new HashMap<>();
        HashMap<Integer, int[]> ymap = new HashMap<>();
        for(int i = 0; i < buildings.length; i++){
            int xVal = buildings[i][0];
            int yVal = buildings[i][1];
            if(xmap.containsKey(xVal)){
                int[] values = xmap.get(xVal);
                if(yVal < values[0]){
                    int temp = values[0];
                    values[0] = yVal;
                    if(values[1] < temp){
                        values[1] = temp;
                    }
                }
                if(yVal > values[1]){
                    values[1] = yVal;
                }
                xmap.put(xVal, values);
            } else {
                int[] values = new int[2];
                values[0] = yVal;
                values[1] = -1;
                xmap.put(xVal, values);
            }

            if(ymap.containsKey(yVal)){
                int[] values = ymap.get(yVal);
                if(xVal < values[0]){
                    int temp = values[0];
                    values[0] = xVal;
                    if(values[1] < temp){
                        values[1] = temp;
                    }
                }
                if(xVal > values[1]){
                    values[1] = xVal;
                }
                ymap.put(yVal, values);
            } else {
                int[] values = new int[2];
                values[0] = xVal;
                values[1] = -1;
                ymap.put(yVal, values);
            }
        }
        for(int i = 0; i < buildings.length; i++){
            int x = buildings[i][0];
            int y = buildings[i][1];
            int[] yVal = xmap.getOrDefault(x, new int[]{-1, -1});
            int[] xVal = ymap.getOrDefault(y, new int[]{-1, -1});
            if(x > xVal[0] && x < xVal[1]){
                if(y > yVal[0] && y < yVal[1]){
                    ans++;
                }
            }
        }
        return ans;
    }
}