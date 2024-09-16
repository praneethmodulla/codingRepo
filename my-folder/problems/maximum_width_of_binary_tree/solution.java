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
class Tuple {
    TreeNode node;
    int idx;
    public Tuple(TreeNode root, int val){
        node = root;
        idx = val;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<Tuple> queue = new ArrayDeque<>();
        if(root == null){
            return maxWidth;
        }
        queue.add(new Tuple(root, 0));
        while(!queue.isEmpty()){
            int size = queue.size();
            int minVal = queue.peek().idx;
            int minIdx = 0;
            int maxIdx = 0;
            for(int i = 0; i < size; i++){
                Tuple tup = queue.poll();
                TreeNode node = tup.node;
                int idx = tup.idx;
                idx = idx - minVal;
                if(node.left != null){
                    queue.add(new Tuple(node.left, (2 * idx) + 1));
                }
                if(node.right != null){
                    queue.add(new Tuple(node.right, (2 * idx) + 2));
                }
                if(i == 0){
                    minIdx = idx;
                }
                if(i == size - 1){
                    maxIdx = idx;
                }
            }
            maxWidth = Math.max(maxWidth, (maxIdx - minIdx + 1));
        }
        return maxWidth;
    }
}