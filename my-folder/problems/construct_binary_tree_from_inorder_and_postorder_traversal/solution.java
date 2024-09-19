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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
        return root;
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }
        TreeNode node = new TreeNode(postorder[postEnd]);
        int rootIdx = map.get(node.val);
        int numRight = inEnd - rootIdx;
        node.right = build(inorder, rootIdx + 1, inEnd, postorder, postEnd - numRight, postEnd - 1, map);
        node.left = build(inorder, inStart, rootIdx - 1, postorder, postStart, postEnd - numRight - 1, map);
        return node;
    }
}