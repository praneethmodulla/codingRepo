/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, Integer> vis = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            vis.put(nums[i], 0);
        }
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            if(!map.containsKey(temp.val)){
                List<Integer> grp = new ArrayList<Integer>();
                if(temp.next != null){
                    grp.add(temp.next.val);
                }
                if(prev != null){
                    grp.add(prev.val);
                }
                map.put(temp.val, grp);
            }
            prev = temp;
            temp = temp.next;
        }
        int connectedComponents = 0;
        for(Integer key : vis.keySet()){
            if(vis.get(key) != 1){
                recurse(map, vis, key);
                connectedComponents++;
            }
        }
        return connectedComponents; 
    }

    public void recurse(HashMap<Integer, List<Integer>> map, HashMap<Integer, Integer> vis, int key){
        if(!vis.containsKey(key)){
            return;
        }
        if(vis.get(key) == 1){
            return;
        }
        vis.put(key, 1);
        List<Integer> connect = map.get(key);
        for(int i = 0; i < connect.size(); i++){
            recurse(map, vis, connect.get(i));
        }
        return;
    }
}