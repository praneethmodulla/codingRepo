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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> Double.compare(Math.abs(a - target), Math.abs(b - target)));
        List<Integer> res = new ArrayList<Integer>();
        recurse(root, target, minHeap);
        while(!minHeap.isEmpty() && k > 0){
            res.add(minHeap.poll());
            k--;
        }
        return res;
    }

    public void recurse(TreeNode node, double target, PriorityQueue<Integer> heap){
        if(node == null){
            return;
        }
        heap.add(node.val);
        recurse(node.left, target, heap);
        recurse(node.right, target, heap);
        return;
    }
}