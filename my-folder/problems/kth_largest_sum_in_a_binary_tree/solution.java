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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> heap = new PriorityQueue<Long>((a,b) -> Long.compare(b,a));
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        if(root == null){
            return -1;
        }
        queue.add(root);
        int numLevels = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            long levelSum = 0;
            numLevels++;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                levelSum += node.val;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            heap.add(levelSum);
        }
        if(numLevels < k){
            return -1;
        }
        while(k > 1 && !heap.isEmpty()){
            k--;
            heap.poll();
        }
        return heap.poll();
    }
}