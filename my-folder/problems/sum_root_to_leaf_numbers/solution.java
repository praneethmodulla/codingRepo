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
    public int sumNumbers(TreeNode root) {
        List<String> numbers = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        recurse(root, sb, numbers);
        int sum = 0;
        for(int i = 0; i < numbers.size(); i++){
            sum += Integer.parseInt(numbers.get(i));
        }
        return sum;
    }

    public void recurse(TreeNode root, StringBuilder sb, List<String> nums){
        if(root.left == null && root.right == null){
            sb.append(root.val);
            nums.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append(root.val);
        if(root.left != null){
            recurse(root.left, sb, nums);
        }
        if(root.right != null){
            recurse(root.right, sb, nums);
        }
        sb.deleteCharAt(sb.length() - 1);
        return;
    }
}