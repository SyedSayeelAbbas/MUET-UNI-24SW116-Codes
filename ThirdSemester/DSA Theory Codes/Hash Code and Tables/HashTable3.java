package SirMossen;

public class HashTable3 {
    private Entry[] entries;
    private int size;
    private float loadFactor;

    public HashTable3(int capacity, float loadFactor) {
        entries = new Entry[capacity];
        this.loadFactor = loadFactor;
    }

    public HashTable3(int capacity) {
        this(capacity, 0.75F);
    }

    public HashTable3() {
        this(101);
    }

    public Object get(Object key) {
        int h = hash(key);
        for (Entry e = entries[h]; e != null; e = e.next) {
            if (e.key.equals(key)) return e.value;   // success
        }
        return null;  // failure: key not found
    }

    public Object put(Object key, Object value) {
        int h = hash(key);
        for (Entry e = entries[h]; e != null; e = e.next) {
            if (e.key.equals(key)) {
                Object oldValue = e.value;
                e.value = value;
                return oldValue;  // successful update
            }
        }
        entries[h] = new Entry(key, value, entries[h]);
        ++size;
        if (size > loadFactor * entries.length) rehash();
        return null;  // successful insertion
    }

    public Object remove(Object key) {
        int h = hash(key);
        for (Entry e = entries[h], prev = null; e != null; prev = e, e = e.next) {
            if (e.key.equals(key)) {
                Object oldValue = e.value;
                if (prev == null) entries[h] = e.next;
                else prev.next = e.next;
                --size;
                return oldValue;  // success
            }
        }
        return null;  // failure: key not found
    }

    public int size() {
        return size;
    }

    private class Entry {
        Object key, value;
        Entry next;

        Entry(Object k, Object v, Entry n) {
            key = k;
            value = v;
            next = n;
        }

        public String toString() {
            return key + "=" + value;
        }
    }

    private int hash(Object key) {
        if (key == null) throw new IllegalArgumentException();
        return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }

    private void rehash() {
        Entry[] oldEntries = entries;
        entries = new Entry[2 * oldEntries.length + 1];
        for (int k = 0; k < oldEntries.length; k++) {
            for (Entry old = oldEntries[k]; old != null; ) {
                Entry e = old;
                old = old.next;
                int h = hash(e.key);
                e.next = entries[h];
                entries[h] = e;
            }
        }
    }

    // ---------------- MAIN METHOD FOR TESTING ----------------
    public static void main(String[] args) {
        HashTable3 table = new HashTable3(5);

        // Inserting values
        table.put("Pakistan", "Islamabad");
        table.put("India", "New Delhi");
        table.put("China", "Beijing");
        table.put("USA", "Washington D.C.");
        table.put("UK", "London");

        System.out.println("Size after insertions: " + table.size());

        // Retrieving values
        System.out.println("Capital of Pakistan: " + table.get("Pakistan"));
        System.out.println("Capital of USA: " + table.get("USA"));
        System.out.println("Capital of UK: " + table.get("UK"));

        // Updating a value
        table.put("Pakistan", "Updated Islamabad");
        System.out.println("Updated capital of Pakistan: " + table.get("Pakistan"));

        // Removing a key
        System.out.println("Removing India -> " + table.remove("India"));
        System.out.println("Size after removal: " + table.size());
        System.out.println("Capital of India (after removal): " + table.get("India"));
    }
}
