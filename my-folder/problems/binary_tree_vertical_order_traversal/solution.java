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
    TreeNode node;
    int col;
    public Pair(TreeNode root, int colVal){
        this.node = root;
        this.col = colVal;
    }
}
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        TreeMap<Integer, List<Integer>> hMap = new TreeMap<Integer, List<Integer>>();
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair pair = queue.poll();
                int col = pair.col;
                TreeNode node = pair.node;
                List<Integer> res = new ArrayList<Integer>();
                if(hMap.containsKey(col)){
                    res = hMap.get(col);
                    res.add(node.val);
                } else {
                    res.add(node.val);
                }
                hMap.put(col, res);
                if(node.left != null){
                    queue.add(new Pair(node.left, col - 1));
                }
                if(node.right != null){
                    queue.add(new Pair(node.right, col + 1));
                }
            }
        }
        for(int k : hMap.keySet()){
            result.add(hMap.get(k));
        }
        return result;
    }
}