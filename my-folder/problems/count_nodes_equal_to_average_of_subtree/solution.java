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
    int sum;
    int num; 
    public Pair(int sum, int num){
        this.sum = sum;
        this.num = num;
    }
}
class Solution {
    public int averageOfSubtree(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = 0;
        recurse(root, ans);
        return ans[0];
    }

    public Pair recurse(TreeNode root, int[] ans){
        if(root == null){
            return new Pair(0, 0);
        }
        if(root.left == null && root.right == null){
            ans[0]+= 1;
            return new Pair(root.val, 1);
        }
        Pair left = recurse(root.left, ans);
        Pair right = recurse(root.right, ans);
        if(root.val == (left.sum + right.sum + root.val)/(left.num + right.num + 1)){
            ans[0]++;
        }
        Pair retPair = new Pair(left.sum + right.sum + root.val, left.num + right.num + 1);
        return retPair;
    }
}