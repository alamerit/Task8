package java_core;

import java.util.HashMap;
import java.util.Map;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;
import static java.util.WeakHashMap.indexFor;

public class Main {

    int threshold;
    Object key;
    Map.Entry[] table = new Map.Entry[1];
    int hash = hash(key.hashCode());

    Map.Entry<String,Integer> e = table[indexFor(hash, table.length)];

    public static void main(String[] args) {
        Map<String, Integer> hashmap = new HashMap<String, Integer>();




    }

    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }


    static int indexFor(int h, int length) {
        return h & (length - 1);
    }


    void resize(int newCapacity)
    {
        if (table.length == MAXIMUM_CAPACITY)
        {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Map.Entry[] newTable = new Map.Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        float loadFactor = 0.75f;
        int threshold = (int)(newCapacity * loadFactor);
    }

    void transfer(Map.Entry[] newTable) {
        Map.Entry[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Map.Entry<String,Integer> e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Map.Entry<String,Integer> next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }


}
