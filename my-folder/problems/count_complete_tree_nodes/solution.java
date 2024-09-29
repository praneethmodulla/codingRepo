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
    public int countNodes(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if(leftHeight == rightHeight){
            return (int)(Math.pow(2, leftHeight)) - 1;
        }
        return countNodes(root.right) + countNodes(root.left) + 1;
    }

    public int getLeftHeight(TreeNode node){
        int count = 0;
        while(node != null){
            count++;
            node = node.left;
        }
        return count;
    }

    public int getRightHeight(TreeNode node){
        int count = 0;
        while(node != null){
            count++;
            node = node.right;
        }
        return count;
    }

}