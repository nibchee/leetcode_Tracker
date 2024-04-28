class LRUCache {

    class Node {
        int val;
        Node next;
        Node prev;
        int key;

        Node(int val,int key){
            this.val=val;
            this.key=key;
        }
    }

    class DLL {

        Node head;
        Node tail;

        public void addFirst(Node node) {
            if (head ==null) {
                // firstNode
                head = node;
                tail = node;
                return;
            }

            node.next = head;
            head.prev = node;
            head = node;

        }

        public Node remove(Node node) {
            if (node == head) {
                head = head.next;
            } else {
                node.prev.next = node.next;
            }

            if (node == tail)
                tail = tail.prev;
            else
                node.next.prev = node.prev;

            node.next = null;
            node.prev = null;
            return node;
        }
    }

    DLL dll = new DLL();
    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dll = new DLL();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node=map.get(key);
            dll.remove(node);
            dll.addFirst(node);
            return map.get(key).val;
        } else
            return -1;
    }

    public void put(int key, int value) {
           if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            dll.remove(node);
            dll.addFirst(node);
           }else{
            Node node=new Node(value,key);
            map.put(key,node);
            dll.addFirst(node);
            if(map.size()>capacity){
                map.remove(dll.tail.key);
                dll.remove(dll.tail);
            }
           }
    }  
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */