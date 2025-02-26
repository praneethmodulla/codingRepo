class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {

    int capacity;
    HashMap<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, ListNode>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            ListNode oNode = map.get(key);
            remove(oNode);
        }
        
        ListNode newNode = new ListNode(key, value);
        map.put(key, newNode);
        add(newNode);

        if(map.size() > capacity){
            ListNode temp = head.next;
            remove(temp);
            map.remove(temp.key);
        }
    }

    public void remove(ListNode node){
        if(node.next != null){
            node.next.prev = node.prev;
        }
        if(node.prev != null){
            node.prev.next = node.next;
        }
    }

    public void add(ListNode node){
        ListNode prevEnd = tail.prev;
        prevEnd.next = node;
        node.prev = prevEnd;
        node.next = tail;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */