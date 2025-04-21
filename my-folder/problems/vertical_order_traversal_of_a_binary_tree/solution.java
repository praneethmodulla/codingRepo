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
    int row;
    int col;
    TreeNode node;

    public Pair(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> queue = new ArrayDeque<Pair>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tMap = new TreeMap<>();
        queue.add(new Pair(root, 0, 0));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair p = queue.poll();
                TreeNode node = p.node;
                int row = p.row;
                int col = p.col;
                if(node.left != null){
                    queue.add(new Pair(node.left, row + 1, col - 1));
                }
                if(node.right != null){
                    queue.add(new Pair(node.right, row + 1, col + 1));
                }
                if(!tMap.containsKey(col)){
                    tMap.put(col, new TreeMap<>());
                }
                if(!tMap.get(col).containsKey(row)){
                    tMap.get(col).put(row, new PriorityQueue<Integer>());
                }
                tMap.get(col).get(row).add(node.val);
            }
        }
        for(int col : tMap.keySet()){
            List<Integer> colValues = new ArrayList<Integer>();
            for(int row : tMap.get(col).keySet()){
                while(!tMap.get(col).get(row).isEmpty()){
                    colValues.add(tMap.get(col).get(row).poll());
                }
            }
            result.add(colValues);
        }
        return result;
    }
}