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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null){
            return result;
        }
        queue.add(root);
        int k = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> row = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                row.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(k % 2 == 0){
                result.add(row);
            } else {
                List<Integer> reverseRow = new ArrayList<>();
                for(int j = row.size() - 1; j >= 0; j--){
                    reverseRow.add(row.get(j));
                }
                result.add(reverseRow);
            }
            k++;
        }
        return result;
    }
}