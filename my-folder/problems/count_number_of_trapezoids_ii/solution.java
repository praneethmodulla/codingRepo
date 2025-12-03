class Solution {
    public int countTrapezoids(int[][] points) {
        double inf = 1e9 + 7;
        HashMap<Double, List<Double>> slope = new HashMap<>();
        HashMap<Integer, List<Double>> mid = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i + 1; j < points.length; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                double dx = x1 - x2;
                double dy = y1 - y2;
                double k = 0;
                double b = 0;
                if(x2 == x1){
                    k = inf;
                    b = x1;
                } else {
                    k = (double)(y2 - y1)/(double)(x2 - x1);
                    b = (y1 * dx - x1 * dy)/dx;
                }
                if(k == -0.0){
                    k = 0.0;
                }
                if(b == -0.0){
                    b = 0.0;
                }
                int midpoint = (x1 + x2) * 10000 + (y1 + y2);
                if(!slope.containsKey(k)){
                    slope.put(k, new ArrayList<Double>());
                }
                slope.get(k).add(b);
                if(!mid.containsKey(midpoint)){
                    mid.put(midpoint, new ArrayList<Double>());
                }
                mid.get(midpoint).add(k);
            }
        }
        int ans = 0;
        for(double k : slope.keySet()){
            List<Double> intercept = slope.get(k);
            if(intercept.size() == 1){
                continue;
            }
            Map<Double, Integer> cnt = new TreeMap<>();
            for(double b : intercept){
                cnt.put(b, cnt.getOrDefault(b, 0) + 1); 
            }
            int sum = 0;
            for(double b : cnt.keySet()){
                int count = cnt.get(b);
                ans += sum * count;
                sum += count;
            }
        }

        for(int midpoint : mid.keySet()){
            List<Double> slopes = mid.get(midpoint);
            if(slopes.size() == 1){
                continue;
            }
            Map<Double, Integer> cnt = new TreeMap<>();
            for(double k : slopes){
                cnt.put(k, cnt.getOrDefault(k, 0) + 1);
            }
            int sum = 0;
            for(double k : cnt.keySet()){
                int count = cnt.get(k);
                ans -= sum * count;
                sum += count;
            }
        }
        return ans;
    }
}