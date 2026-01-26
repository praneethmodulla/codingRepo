class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b) -> {
            double d1 = (double)(a[0] + 1)/(a[1] + 1) - (double)(a[0])/(a[1]);
            double d2 = (double)(b[0] + 1)/(b[1] + 1) - (double)(b[0])/(b[1]);
            return Double.compare(d2, d1);
        });

        for(int i = 0; i < classes.length; i++){
            heap.add(new int[]{classes[i][0], classes[i][1]});
        }

        while(extraStudents > 0){
            int[] pass = heap.poll();
            pass[0] += 1;
            pass[1] += 1;
            heap.add(pass);
            extraStudents--;
        }

        double result = 0;
        while(!heap.isEmpty()){
            int[] pass = heap.poll();
            result += (double)(pass[0])/(pass[1]);
        } 
        return (double)result/classes.length;
    }
}