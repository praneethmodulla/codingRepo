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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<TreeNode>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < to_delete.length; i++){
            set.add(to_delete[i]);
        }

        root = recurse(set, forest, root);
        if(root != null){
            forest.add(root);
        }
        return forest;
    }

    public TreeNode recurse(HashSet<Integer> set, List<TreeNode> forest, TreeNode node){
        if(node == null){
            return null;
        }
        node.left = recurse(set, forest, node.left);
        node.right = recurse(set, forest, node.right);

        if(set.contains(node.val)){
            if(node.left != null){
                forest.add(node.left);
            }
            if(node.right != null){
                forest.add(node.right);
            }
            return null;
        }
        return node;
    }
}

