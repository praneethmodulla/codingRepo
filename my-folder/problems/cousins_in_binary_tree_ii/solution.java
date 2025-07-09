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
class Pair {
    TreeNode node;
    int parentSum;

    public Pair(TreeNode _node, int _sum){
        this.node = _node;
        this.parentSum = _sum; 
    }
}
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null){
            return root;
        }
        int level = 0;
        Queue<Pair> queue = new ArrayDeque<Pair>();
        root.val = 0;
        queue.add(new Pair(root, 0));
        int prevSum = 0;
        int levelSum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            prevSum = levelSum; 
            levelSum = 0;
            for(int i = 0; i < size; i++){
                Pair p = queue.poll();
                TreeNode node = p.node;
                if(level == 1){
                    node.val = 0;
                } else if(level > 1){
                    node.val = prevSum - p.parentSum;
                }
                int sum = 0;
                if(node.left != null){
                    sum += node.left.val;
                }
                if(node.right != null){
                    sum += node.right.val;
                }
                levelSum += sum;
                if(node.left != null){
                    queue.add(new Pair(node.left, sum));
                }
                if(node.right != null){
                    queue.add(new Pair(node.right, sum));
                }
            }
            level++;
        }
        return root;
    }
}