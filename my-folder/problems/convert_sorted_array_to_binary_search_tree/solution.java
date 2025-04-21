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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 1){
            TreeNode res = new TreeNode(nums[0]);
            return res;
        }
        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(0, mid - 1, nums);
        root.right = buildTree(mid + 1, nums.length - 1, nums);
        return root;
    }
    
    public TreeNode buildTree(int startIdx, int endIdx, int[] nums){
        if(endIdx < startIdx){
            return null;
        }
        int mid = (startIdx + endIdx)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(startIdx, mid - 1, nums);
        node.right = buildTree(mid + 1, endIdx, nums);
        return node;
    }
}