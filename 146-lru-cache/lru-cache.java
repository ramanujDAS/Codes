class LRUCache {
    private static int capacity;
    private static Queue<Integer> q;
    private static HashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        q = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            q.remove(key);
            q.add(key);
            return value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            q.remove(key);
            q.add(key);
        } else {
            if (map.size() == capacity) {
                map.remove(q.poll());
                q.add(key);
                map.put(key, value);
            } else {
                q.add(key);
                map.put(key, value);
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