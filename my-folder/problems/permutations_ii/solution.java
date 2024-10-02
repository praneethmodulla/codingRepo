class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
        result = recurse(result, set, nums, 0, visited);
        return result;
    }

    public List<List<Integer>> recurse(List<List<Integer>> result, List<Integer> set, int[] nums, int idx, int[] visited){
        if(set.size() == nums.length){
            result.add(new ArrayList<Integer>(set));
            return result;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i] != 1){
                set.add(nums[i]);
                visited[i] = 1;
                result = recurse(result, set, nums, i + 1, visited);
                visited[i] = 0;
                set.remove(set.size() - 1);
                while(i < nums.length - 1 && nums[i] == nums[i + 1]){
                    i++;
                }
            }
        }
        return result;
    }
}