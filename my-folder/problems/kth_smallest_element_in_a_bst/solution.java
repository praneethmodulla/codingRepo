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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        int[] cnt = new int[1];
        recurse(root, res, k, cnt);
        return res.get(0);
    }

    public void recurse(TreeNode node, List<Integer> res, int k, int[] cnt){
        if(node == null){
            return;
        }
        recurse(node.left, res, k, cnt);
        cnt[0]++;
        if(cnt[0] == k){
            res.add(node.val);
        }
        recurse(node.right, res, k, cnt);
        return;
    }
}