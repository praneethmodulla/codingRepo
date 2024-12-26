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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int maxIdx = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[maxIdx] < nums[i]){
                maxIdx = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = recurse(nums, 0, maxIdx - 1);
        root.right = recurse(nums, maxIdx + 1, nums.length - 1);
        return root;
    }

    public TreeNode recurse(int[] nums, int startIdx, int endIdx){
        if(endIdx < startIdx){
            return null;
        }
        int maxIdx = startIdx;
        for(int i = startIdx; i <= endIdx; i++){
            if(nums[maxIdx] < nums[i]){
                maxIdx = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxIdx]);
        node.left = recurse(nums, startIdx, maxIdx - 1);
        node.right = recurse(nums, maxIdx + 1, endIdx);
        return node;
    }
}