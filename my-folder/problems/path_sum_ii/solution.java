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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        result = recurse(root, targetSum, 0, set, result);
        return result;
    }

    public List<List<Integer>> recurse(TreeNode node, int target, int sum, List<Integer> set, List<List<Integer>> result){
        if(node == null){
            return result;
        }
        if(node.left == null && node.right == null){
            sum += node.val;
            set.add(node.val);
            if(target == sum){
                List<Integer> copySet = new ArrayList<Integer>();
                for(int i = 0; i < set.size(); i++){
                    copySet.add(set.get(i));
                }
                result.add(copySet);
            }
            sum -= node.val;
            set.remove(set.size() - 1);
            return result;
        }
        sum += node.val;
        set.add(node.val);
        result = recurse(node.left, target, sum, set, result);
        result = recurse(node.right, target, sum, set, result);
        sum -= node.val;
        set.remove(set.size() - 1);
        return result;
    }
}