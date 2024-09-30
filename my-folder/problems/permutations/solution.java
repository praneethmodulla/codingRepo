class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
        result = recurse(result, set, nums, visited);
        return result;
    }

    public List<List<Integer>> recurse(List<List<Integer>> result, List<Integer> set, int[] nums, int[] visited){
        if(set.size() == nums.length){
            result.add(new ArrayList<Integer>(set));
            return result;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i] != 1){
                set.add(nums[i]);
                visited[i] = 1;
                result = recurse(result, set, nums, visited);
                set.remove(set.size() - 1);
                visited[i] = 0;
            }
        }

        return result;
    }
}