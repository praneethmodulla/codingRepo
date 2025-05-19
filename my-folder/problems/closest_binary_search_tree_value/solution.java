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
    public int closestValue(TreeNode root, double target) {
        double diff = Double.MAX_VALUE;
        int[] ans = new int[1];
        recurse(root, target, diff, ans);
        return ans[0];
    }

    public void recurse(TreeNode node, double target, double diff, int[] ans){
        if(node == null)
        {
            return;
        }
        double difference = Math.abs(target - node.val);
        if(diff > difference){
            ans[0] = node.val;
            diff = difference;
        } else if(diff == difference){
            if(ans[0] > node.val){
                ans[0] = node.val;
            }
        }
        if(node.val > target){
            recurse(node.left, target, diff, ans);
        } else {
            recurse(node.right, target, diff, ans);
        }
        return;
    }
}