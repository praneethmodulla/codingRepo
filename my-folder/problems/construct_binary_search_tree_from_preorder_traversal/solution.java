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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[1]);
    }

    public TreeNode bstFromPreorder(int[] preorder, int upbound, int[] cnt){
        if(cnt[0] == preorder.length || preorder[cnt[0]] > upbound){
            return null;
        }
        TreeNode root = new TreeNode(preorder[cnt[0]++]);
        root.left = bstFromPreorder(preorder, root.val, cnt);
        root.right = bstFromPreorder(preorder, upbound, cnt);
        return root;
    }
}