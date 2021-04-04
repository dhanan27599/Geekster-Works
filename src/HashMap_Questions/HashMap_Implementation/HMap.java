package HashMap_Questions.HashMap_Implementation;

import java.util.*;

public class HMap<K, V>{
    private class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private LinkedList<Node>[] bucket;
    private int size;
    public HMap() {
        bucket = new LinkedList[4];
        for(int i = 0 ; i < bucket.length ; i++) {
            bucket[i] = new LinkedList<>();
        }
    }

    public V get(K key) {
        int idx = hash(key);
        Node node = findInBucket(idx, key);
        if(node == null) {
            return null;
        } else {
            return node.value;
        }
    }

    private int hash(K key) {
        int idx = key.hashCode();
        return Math.abs(idx) % bucket.length;
    }

    private Node findInBucket(int idx, K key) {
        for(int i = 0 ; i < bucket[idx].size() ; i++) {
            Node node = bucket[idx].get(i);
            if(node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        int idx = hash(key);
        Node node = findInBucket(idx, key);
        if(node == null) {
            bucket[idx].add(new Node(key, value));
            this.size += 1;
        } else {
            node.value = value;
        }
        double lambda = (this.size * 1.0) / bucket.length;
        if(lambda > 2.0) {
            rehash();
        }
    }

    private void rehash() {
        LinkedList<Node>[] otherBucket = bucket;
        bucket = new LinkedList[2 * bucket.length];
        for(int i = 0 ; i < bucket.length ; i++) {
            bucket[i] = new LinkedList<>();

        }

        this.size = 0;

        for(int i = 0 ; i < otherBucket.length ; i++) {
            for(Node node : otherBucket[i]) {
                put(node.key, node.value);
            }
        }
    }

    public boolean containsKey(K key) {
        int idx = hash(key);
        Node node = findInBucket(idx, key);
        if(node == null) {
            return false;
        } else {
            return true;
        }
    }

    public V remove(K key) {
        int idx = hash(key);
        Node node = findInBucket(idx, key);
        if(node == null) {
            return null;
        } else {
            removeFromBucket(idx, key);
            this.size -= 1;
            return node.value;
        }
    }

    private void removeFromBucket(int idx, K key) {
        for(int i = 0 ; i < bucket[idx].size() ; i++) {
            Node node = bucket[idx].get(i);
            if(node.key.equals(key)) {
                bucket[idx].remove(i);
                return;
            }
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for(int i = 0 ; i < bucket.length ; i++) {
            for(Node node : bucket[i]) {
                keys.add(node.key);
            }
        }

        return keys;
    }
//    public void display() {
//        System.out.println("``````````````````````````````````");
//        for(int i = 0 ; i < bucket.length ; i++){
//            System.out.println("B" + i + "- ");
//            for(Node node : bucket[i]){
//                System.out.print("{" + node.key + "=" + node.value + "}, ");
//            }
//            System.out.println();
//        }
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for(int i = 0 ; i < bucket.length ; i++) {
            sb.append(" B" + (i+1) + " -> (");
            for(Node node : bucket[i]) {
                sb.append(" [" + node.key + "=" + node.value + "] ");
            }
            sb.append(") \n");
        }
        return sb.append("}").toString().trim();
    }



}
