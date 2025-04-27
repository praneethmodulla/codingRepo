/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        recurse(root, map);
        int maxFreq = 0;
        for(int i : map.keySet()){
            if(maxFreq < map.get(i)){
                maxFreq = map.get(i);
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i : map.keySet()){
            if(map.get(i) == maxFreq){
                res.add(i);
            }
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

    public int recurse(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null){
            return 0;
        }
        int leftSum = recurse(root.left, map);
        int rightSum = recurse(root.right, map);
        int sum = leftSum + rightSum + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}