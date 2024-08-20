class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for(int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(!res.isEmpty() && start <= res.get(res.size() - 1).get(1)){
                end = Math.max(end, res.get(res.size() - 1).get(1));
                res.get(res.size() - 1).remove(1);
                res.get(res.size() - 1).add(end);
            } else {
                List<Integer> indInterval = new ArrayList<>();
                indInterval.add(start);
                indInterval.add(end);
                res.add(indInterval); 
            }
        }

        int[][] result = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            result[i][0] = res.get(i).get(0);
            result[i][1] = res.get(i).get(1);
        }
        return result;
    }
}