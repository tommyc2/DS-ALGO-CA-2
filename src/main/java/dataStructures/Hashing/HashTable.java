package dataStructures.Hashing;

import dataStructures.CustomLinkedList.Node;

public class HashTable<K,T> {

    /* Hash Table using Linear Probing technique */
    /* Uses primitive array to store objects of a specified type */
    /* Written by: Tommy Condon */
    /* Open Addressing */
    private T[] hashTable;
    private K[] keys;

    public HashTable(int size){
        hashTable = (T[]) new Object[size];
        keys = (K[]) new Object[size];
    }

    public int hashFunction(int key) {
        return key % hashTable.length;
    }

    public boolean add(K k, T data){
        int key = Math.abs(k.hashCode());
        int location = hashFunction(key);
        int startLoc = location;
        int probe = 1;
        do {
            if(hashTable[location]==null) {
                hashTable[location] = data;
                keys[location] = k;
                return true;
            }
            else {
                location = (location + 1) % hashTable.length;
            }

        } while(location!=startLoc);
        return false;
    }

    // Returns value pair of key
    public T getValuePair(K key) {
        int map = Math.abs(key.hashCode());
        int location = hashFunction(map);
        int startLoc = location;

        do {

            if (keys[location] == null){
                return null;
            }

            if(keys[location].equals(key)) {
                return hashTable[location];
            }
            else{
                location = (location+1) % keys.length;
            }
        } while(location!=startLoc);

        return null;
    }

    public String listTableElements(){
        String list = "";
        for(int id = 0; id < hashTable.length; id++){
            if(hashTable[id]!=null){
                list += "(" + (id) + ") " + hashTable[id].toString() +"\n";
            }
        }

        if (list.isEmpty()) return "List is empty";

        else {
            return list;
        }
    }

    public T getByIndex(int id){
        if(hashTable[id]!=null){
            return hashTable[id];
        }
        return null;
    }

    public int size(){
     return hashTable.length;
    }


    public boolean remove(int index){
        for(int i = 0; i < hashTable.length; i++){
            if (i==index){
                hashTable[i] = null;
                return true;
            }
        }
        return false;
    }

    public void swapElements(int startingPoint, int smallestIndex){
        T swap=hashTable[startingPoint];
        hashTable[startingPoint]=hashTable[smallestIndex];
        hashTable[smallestIndex]=swap;
    }



}
