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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int i = 0;
        int depth = 0;
        TreeNode root = null;
        while(i < traversal.length()){
            StringBuilder number = new StringBuilder();
            while(i < traversal.length() && traversal.charAt(i) != '-'){
                number.append(traversal.charAt(i));
                i++;
            }
            TreeNode node = new TreeNode(Integer.parseInt(number.toString()));
            if(depth == 0){
                root = node;
            }
            if(stack.size() == depth){    
                if(stack.isEmpty()){
                    stack.push(node);
                } else {
                    stack.peek().left = node;
                    stack.push(node);
                }
            } else if(stack.size() > depth){
                while(stack.size() > depth){
                    stack.pop();
                }
                stack.peek().right = node;
                stack.push(node);
            }
            depth = 0;
            while(i < traversal.length() && traversal.charAt(i) == '-'){
                i++;
                depth++;
            }
        }
        return root;
    }
}