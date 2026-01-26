class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++){
            minDiff = Math.min(arr[i + 1] - arr[i], minDiff);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i + 1] - arr[i] == minDiff){
                List<Integer> res = new ArrayList<Integer>();
                res.add(arr[i]);
                res.add(arr[i + 1]);
                result.add(res);
            }
        }
        return result;
    }
}