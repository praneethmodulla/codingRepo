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
class Tuple{
    TreeNode node;
    int x;
    int y;
    public Tuple(TreeNode root, int col, int level){
        node = root;
        x = col;
        y = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        queue.add(new Tuple(root, 0, 0));
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        while(!queue.isEmpty()){
                Tuple tup = queue.poll();
                TreeNode node = tup.node;
                int x = tup.x;
                int y = tup.y;
                if(node.left != null){
                    queue.add(new Tuple(node.left, x - 1, y + 1));
                }
                if(node.right != null){
                    queue.add(new Tuple(node.right, x + 1, y + 1));
                }

                if(!map.containsKey(x)){
                    map.put(x, new TreeMap<>());
                }
                if(!map.get(x).containsKey(y)){
                    map.get(x).put(y, new PriorityQueue<Integer>());
                }
                map.get(x).get(y).add(node.val);
        }
        for(Integer x : map.keySet()){
            TreeMap<Integer, PriorityQueue<Integer>> tMap = map.get(x);
            List<Integer> res = new ArrayList<Integer>();
            for(Integer y : tMap.keySet()){
                PriorityQueue<Integer> vals = tMap.get(y);
                while(!vals.isEmpty()){
                    res.add(vals.remove());
                }
            }
            result.add(res);
        }
        return result;
    }
}