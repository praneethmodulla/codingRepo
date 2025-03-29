class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0; 
        int j = 0;
        List<int[]> res = new ArrayList<int[]>();
        while(i < firstList.length && j < secondList.length){
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);
            if(low <= high){
                res.add(new int[]{low, high});
            }
            if(firstList[i][1] > secondList[j][1]){
                j++;
            } else {
                i++;
            }
        }
        int[][] ans = new int[res.size()][2];
        for(int k = 0; k < res.size(); k++){
            ans[k][0] = res.get(k)[0];
            ans[k][1] = res.get(k)[1];
        }
        return ans;
    }
}