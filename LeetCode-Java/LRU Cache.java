public class LRUCache {
    
    class CacheNode
    {
        int key;
        int value;
        CacheNode pre,next;
        public CacheNode(int valKey,int val)
        {
            key = valKey;
            value = val;
            pre = null;
            next = null;
        }
    }
    
    CacheNode head = null;
    CacheNode tail = null;
    int limit = 0;
    int count = 0;
    
    HashMap<Integer, CacheNode> record = new HashMap<Integer, CacheNode>();
    
    void moveToFront(CacheNode temp)
    {
        if(temp == head)
            return;
        if(temp.pre != null)
            temp.pre.next = temp.next;
        if(temp.next != null)
            temp.next.pre = temp.pre;
        else
            tail = temp.pre;
        temp.pre = null;
        temp.next = head;
        if(head != null)
            head.pre = temp;
        head = temp;
    }
    
    public LRUCache(int capacity) {
        limit = capacity;
    }
    
    public int get(int key) {
        if(record.containsKey(key))
        {
            moveToFront(record.get(key));
            return record.get(key).value;
        }
        else
            return -1;
    }
    
    public void set(int key, int value) {
        if(record.containsKey(key))
        {
            record.get(key).value = value;
            moveToFront(record.get(key));
        }
        else
        {
            CacheNode tempNode = new CacheNode(key, value);
            record.put(key, tempNode);
            tempNode.next = head;
            if(head != null)
                head.pre = tempNode;
            head = tempNode;
            count ++;
            
            if(tail == null)
                tail = tempNode;
            
            if(count > limit)
            {
                if(tail.pre != null)
                    tail.pre.next = null;
                record.remove(tail.key);
                
                tail = tail.pre;
                count --;
            }
        }
    }
}