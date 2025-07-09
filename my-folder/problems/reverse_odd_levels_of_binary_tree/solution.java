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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null){
            return root;
        }
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int level = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                if(level % 2 == 0){
                    TreeNode node = queue.poll();
                    if(node.left != null){
                        queue.add(node.left);
                        stack.push(node.left.val);
                    }
                    if(node.right != null){
                        queue.add(node.right);
                        stack.push(node.right.val);
                    }
                } else {
                    TreeNode node = queue.poll();
                    node.val = stack.pop();
                    if(node.left != null){
                        queue.add(node.left);
                    }
                    if(node.right != null){
                        queue.add(node.right);
                    }
                }
            }
            level++;
        }
        return root;
    }
}