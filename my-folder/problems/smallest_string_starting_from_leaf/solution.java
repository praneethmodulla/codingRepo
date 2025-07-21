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
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<String> stringList = new ArrayList<String>();
        recurse(root, sb, stringList);
        Collections.sort(stringList);
        return stringList.get(0);
    }

    public void recurse(TreeNode node, StringBuilder sb, List<String> stringList){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            sb.append((char)('a' + node.val));
            stringList.add(sb.reverse().toString());
            sb.reverse();
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append((char)('a' + node.val));
        recurse(node.left, sb, stringList);
        recurse(node.right, sb, stringList);
        sb.deleteCharAt(sb.length() - 1);
        return;
    }
}