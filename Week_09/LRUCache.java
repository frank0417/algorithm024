import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    /*
     * 题 目：LRU 缓存机制
     * 链 接：https://leetcode-cn.com/problems/lru-cache
     * 描 述：运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.post = tail;
        tail.pre = head;
        head.pre = null;
        tail.post = null;
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node != null) {
            move2Tail(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            if (capacity == cache.size()) {
                DLinkNode head=popHead();
                cache.remove(head.key);

            }
            node = new DLinkNode(key, value);
            addNode(node);
            cache.put(key, node);
        } else {
            node.value = value;
            move2Tail(node);
        }
    }

    private void move2Tail(DLinkNode node) {
        remove(node);
        addNode(node);
    }

    private void addNode(DLinkNode node) {
        node.pre=tail.pre;
        node.post=tail;

        tail.pre.post=node;
        tail.pre=node;
    }

    private void remove(DLinkNode node) {
        DLinkNode pre=node.pre;
        DLinkNode post=node.post;

        pre.post=post;
        post.pre=pre;
    }

    private DLinkNode popHead(){
        DLinkNode node=head.post;
        DLinkNode pre=head;
        DLinkNode post=head.post.post;
        pre.post=post;
        post.pre=pre;
        return node;
    }


    int capacity;
    Map<Integer, DLinkNode> cache = new HashMap<>();
    DLinkNode head;
    DLinkNode tail;

    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
    }

}

class DLinkNode {
    DLinkNode pre;
    DLinkNode post;
    int value;
    int key;

    public DLinkNode() {
    }

    public DLinkNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
