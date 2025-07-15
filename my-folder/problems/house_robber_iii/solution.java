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
    public int rob(TreeNode root) {
        HashMap<TreeNode, List<Integer>> hMap = new HashMap<TreeNode, List<Integer>>();
        return recurse(root, 0, hMap);
    }

    public int recurse(TreeNode node, int pick, HashMap<TreeNode, List<Integer>> map){
        if(node == null){
            return 0;
        }
        if(map.containsKey(node)){
            if(pick == 1){
                return map.get(node).get(1);
            } else {
                return map.get(node).get(0);
            }
        }
        int notTake = 0;
        int take = 0;
        if(pick == 0){
            notTake = 0 + recurse(node.left, 0, map) + recurse(node.right, 0, map);
            take = node.val + recurse(node.left, 1, map) + recurse(node.right, 1, map);
        } else {
            notTake = 0 + recurse(node.left, 0, map) + recurse(node.right, 0, map);
        }
        List<Integer> val = new ArrayList<Integer>();
        val.add(take);
        val.add(notTake);
        map.put(node, val);
        return Math.max(take, notTake);
    }
}