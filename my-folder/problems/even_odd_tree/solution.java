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
    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int prev = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                if(level % 2 == 0){
                    if(node.val % 2 != 1){
                        return false;
                    }
                    if(prev != 0 && prev >= node.val){
                        return false;
                    }
                    prev = node.val;
                } else {
                    if(node.val % 2 != 0){
                        return false;
                    }
                    if(prev != 0 && prev <= node.val){
                        return false;
                    }
                    prev = node.val;
                }
            }
            level++;
        }
        return true;
    }
}