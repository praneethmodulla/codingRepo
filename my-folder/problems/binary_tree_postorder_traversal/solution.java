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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();
        if(root == null){
            return result;
        }
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode node = st1.pop();
            st2.push(node);
            if(node.left != null){
                st1.push(node.left);
            }
            if(node.right != null){
                st1.push(node.right);
            }
        }
        while(!st2.isEmpty()){
            result.add(st2.pop().val);
        }
        return result;
    }
}