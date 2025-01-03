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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        recurse(root, sb);
        return sb.toString();
    }

    public void recurse(TreeNode root, StringBuilder sb){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sb.append(root.val);
            return;
        }
        sb.append(root.val);
        if(root.left == null){
            sb.append("()");
        } else if(root.left != null){
            sb.append("(");
            recurse(root.left, sb);
            sb.append(")");
        }

        if(root.right != null){
            sb.append("(");
            recurse(root.right, sb);
            sb.append(")");
        }
        return;
    }
}