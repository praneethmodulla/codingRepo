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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Long> map = new HashMap<Long, Long>();
        map.put(0l, 1l);
        int[] cnt = new int[1];
        recurse(root, targetSum, map, cnt, 0);
        return cnt[0];
    }

    public void recurse(TreeNode root, int targetSum, HashMap<Long, Long> map, int[] cnt, long sum){
        if(root == null){
            return;
        }
        sum += root.val;
        if(map.containsKey(sum - targetSum)){
            cnt[0] += map.get(sum - targetSum);
        }
        map.put(sum, map.getOrDefault(sum, 0l) + 1l);
        recurse(root.left, targetSum, map, cnt, sum);
        recurse(root.right, targetSum, map, cnt, sum);
        map.put(sum, map.getOrDefault(sum, 0l) - 1l);
        sum -= root.val;
        return;
    }
}