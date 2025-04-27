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
    public double maximumAverageSubtree(TreeNode root) {
        double[] max = new double[1];
        recurse(root, max);
        return max[0];
    }

    public double[] recurse(TreeNode node, double[] max){
        if(node == null){
            return new double[]{0, 0};
        }
        double[] left = recurse(node.left, max);
        double[] right = recurse(node.right, max);
        max[0] = Math.max(max[0], (left[0] + right[0] + node.val)/(left[1] + right[1] + 1));
        return new double[]{left[0] + right[0] + node.val, left[1] + right[1] + 1};
    }
}