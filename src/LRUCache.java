import java.util.HashMap;

public class LRUCache {
    class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        Node head, tail;
        int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            this.head.next = tail;
            this.tail.prev = head;
            this.size = 0;
        }

        //1.尾部增加节点
        public void addLast(Node x) {
            tail.prev.next = x;
            x.prev = tail.prev;
            tail.prev = x;
            x.next = tail;
            size++;
        }

        //2.移除某个存在的节点
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        //3.删除头结点并返回
        public Node removeFirst() {
            if (head.next == tail) return null;
            //复用代码
            Node first = head.next;
            remove(first);
            return first;
        }

        //4.返回长度
        public int size() {
            return this.size;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    DoubleList list = new DoubleList();
    int cap;

    //结合map
    //1.把某个key变得常用
    public void makeRecent(int key) {
        Node x = map.get(key);
        list.remove(x);
        list.addLast(x);
    }

    //2.新增一个k-v
    public void addRecent(int key, int val) {
        Node x = new Node(key, val);
        list.addLast(x);
        map.put(key, x);
    }

    //3.删除某个key
    public void deleteKey(int key) {
        Node x = map.get(key);
        list.remove(x);
        map.remove(x);
    }

    //4.删除最久未使用
    public void deleteFirst() {
        Node x = list.removeFirst();
        map.remove(x.key);
    }


    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        makeRecent(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            deleteKey(key);
            addRecent(key, value);
            return;
        }
        if (cap <= list.size()) {
            deleteFirst();
        }
        addRecent(key, value);
    }
}
