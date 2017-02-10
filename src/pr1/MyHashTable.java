package pr1;

import java.util.ArrayList;

/**
 * Created by admin on 10.02.2017.
 */
public class MyHashTable {
    ArrayList<Bucket> buckets = new ArrayList<>();

    public MyHashTable(int n) {
        for (int i=0; i<n;i++){
            buckets.add(new Bucket());
        }
    }

    String get(String k){
        Bucket b = getBucket(k);
        for (Pair p:b.pairs){
            if(p.getKey().equals(k)){
                return p.getValue();
            }
        }
        return  null;
    }

    private Bucket getBucket(String k) {
        int h = k.hashCode();
        int index=Math.abs(h%buckets.size());
        return buckets.get(index);
    }

    void put(String k, String v){
        Bucket b = getBucket(k);
        for (Pair p:b.pairs){
            if(p.getKey().equals(k)){
                p.setValue(v);
                return;
            }
        }
        b.pairs.add(new Pair(k, v));
    }
}
