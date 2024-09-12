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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null){
            return result;
        }
        stack.push(root);
        TreeNode node = stack.peek();
        while(!stack.isEmpty()){
            while(node != null && node.left != null){
                stack.push(node.left);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
            if(node != null){
                stack.push(node);
            }
        }
        return result;
    }
}