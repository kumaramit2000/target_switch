package com.example.cache;

import java.util.HashMap;

class Node<K,V>{
    K key;
    V val;
    Node<K, V> prev;
    Node<K, V> next;
    Node(K key, V val){
        this.key = key;
        this.val = val;
        this.next=null;
        this.prev=null;
    }
}

public class LRU<K,V> implements Cache<K,V> {

    int capacity;
    public Node<K,V> left;
    public Node<K,V> right;
    HashMap<K, Node<K, V>> pres;

    public LRU(int c){
        this.capacity = c;
        left = new Node<>(null,null);
        right = new Node<>(null,null);
        pres = new HashMap<>();
        left.next = right;
        right.prev = left;
        left.prev = right;
        right.next = left;
    }

    @Override
    public V get(K key) {
        if(pres.containsKey(key)){
            Node<K, V> node = pres.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        System.out.println("Key - "+ key +" is not present in cache.");
        return null;
    }

    @Override
    public void put(K key, V value) {
        int sz = pres.size();
        if(pres.containsKey(key)){
            // present hai tab...
            System.out.println("Key "+ key + " is already present in cache.");
            Node<K, V> temp = pres.get(key);
            remove(temp);
            Node<K, V> newTemp = new Node<>(key,value);
            pres.put(key,newTemp);
            insert(newTemp);
            System.out.println("For Key "+ key + " updated the value in cache.");
        } else {
            // nhi present hai key tab...
            System.out.println("Added Key "+ key + " into the cache.");
            if(sz == capacity){
                // cache is full...
                pres.remove(left.next.key);
                remove(left.next);
            }
            Node<K, V> temp = new Node<>(key,value);
            pres.put(key,temp);
            insert(temp);
        }
    }

    @Override
    public int size() {
        return pres.size();
    }

    public void remove(Node<K, V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node<K, V> node){
        Node<K, V> last = right.prev;
        right.prev = node;
        node.prev = last;
        last.next = node;
        node.next = right;
    }
}
