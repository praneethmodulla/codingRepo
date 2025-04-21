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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        TreeMap<Integer, Integer> tMap = new TreeMap<Integer, Integer>();
        recurse(root, tMap, 0);
        for(int i : tMap.keySet()){
            result.add(tMap.get(i));
        }
        return result;
    }

    public void recurse(TreeNode root, TreeMap<Integer, Integer> tMap, int level){
        if(root == null){
            return;
        }
        if(!tMap.containsKey(level)){
            tMap.put(level, root.val);
        }
        recurse(root.right, tMap, level + 1);
        recurse(root.left, tMap, level + 1);
        return;
    }
}