class LRUCache {
    private static int capacity;
    private Node head = new Node(0, 0);
    private Node last = new Node(-1, -1);

    private static HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head.next = last;
        last.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            
        }
        if (map.size() == capacity) {
            remove(last.prev);
        }
       insert(new Node(key, value));
    }

    class Node {
        int val;
        Node next;
        Node prev;
        int key;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

        void insert(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            map.put(node.key, node);
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            map.remove(node.key);

        }

    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */