package SirMossen;

class Country2 {
    private int area, population;
    private String language, name;

    Country2(int area, int population, String name, String language) {
        this.name = name;
        this.language = language;
        this.area = area;
        this.population = population;
    }

    public String toString() {
        StringBuffer build = new StringBuffer();
        build.append("\t\t\tData Start\n");
        build.append("============================================\n");
        build.append("Country Name is : " + name + "\n");
        build.append("National Language Of " + name + " is : " + language + "\n");
        build.append("Area Of " + name + " is : " + area + "\n");
        build.append("Total Population of " + name + " is : " + population + "\n");
        build.append("============================================\n");
        return build.toString();
    }
}

public class HashTable2 {
    private Entry[] entries;
    private int size, used;
    private float loadFactor;
    private final Entry NIL = new Entry(null, null);

    public HashTable2(int capacity, float loadFactor) {
        entries = new Entry[capacity];
        this.loadFactor = loadFactor;
    }

    public HashTable2(int capacity) {
        this(capacity, 0.75F);
    }

    public HashTable2() {
        this(101);
    }

    public Object get(Object key) {
        int h = hash(key);
        for (int i = 0; i < entries.length; i++) {
            int j = nextProbe(h, i);
            Entry entry = entries[j];
            if (entry == null) break;
            if (entry == NIL) continue;
            if (entry.key.equals(key)) return entry.value;
        }
        return null;
    }

    public Object put(Object key, Object value) {
        if (used > loadFactor * entries.length) rehash();
        int h = hash(key);
        for (int i = 0; i < entries.length; i++) {
            int j = nextProbe(h, i);
            Entry entry = entries[j];
            if (entry == null) {
                entries[j] = new Entry(key, value);
                ++size;
                ++used;
                return null;
            }
            if (entry == NIL) continue;
            if (entry.key.equals(key)) {
                Object oldValue = entry.value;
                entries[j].value = value;
                return oldValue;
            }
        }
        return null;
    }

    public Object remove(Object key) {
        int h = hash(key);
        for (int i = 0; i < entries.length; i++) {
            int j = nextProbe(h, i);
            Entry entry = entries[j];
            if (entry == null) break;
            if (entry == NIL) continue;
            if (entry.key.equals(key)) {
                Object oldValue = entry.value;
                entries[j] = NIL;
                --size;
                return oldValue;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private class Entry {
        Object key, value;
        Entry(Object k, Object v) {
            key = k;
            value = v;
        }
    }

    private int hash(Object key) {
        if (key == null) throw new IllegalArgumentException();
        return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }

    private int nextProbe(int h, int i) {
        return (h + i) % entries.length; // Linear Probing
    }

    private void rehash() {
        Entry[] oldEntries = entries;
        entries = new Entry[2 * oldEntries.length + 1];
        used = size;
        for (int k = 0; k < oldEntries.length; k++) {
            Entry entry = oldEntries[k];
            if (entry == null || entry == NIL) continue;
            int h = hash(entry.key);
            for (int i = 0; i < entries.length; i++) {
                int j = nextProbe(h, i);
                if (entries[j] == null) {
                    entries[j] = entry;
                    break;
                }
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    public void clear() {
        entries = new Entry[entries.length];
        size = 0;
        used = 0;
    }
}

class Main8 {
    public static void main(String[] args) {
        HashTable2 table = new HashTable2();

        Country2 pk = new Country2(1209, 1000, "Pakistan", "Urdu");
        Country2 in = new Country2(17909, 145000, "India", "Hindi");
        Country2 cn = new Country2(9596961, 1412000000, "China", "Mandarin");
        Country2 us = new Country2(9833517, 331000000, "USA", "English");
        Country2 uk = new Country2(243610, 67000000, "UK", "English");
        Country2 sa = new Country2(2149690, 36000000, "Saudi Arabia", "Arabic");

        table.put("PK", pk);
        table.put("IN", in);
        table.put("CN", cn);
        table.put("US", us);
        table.put("UK", uk);
        table.put("SA", sa);

        System.out.println(table.get("PK"));
        System.out.println(table.get("IN"));
        System.out.println(table.get("CN"));
        System.out.println(table.get("US"));
        System.out.println(table.get("UK"));
        System.out.println(table.get("SA"));

        System.out.println("Total Entries = " + table.size());

        System.out.println("\nRemoving UK entry...");
        table.remove("UK");
        System.out.println("UK entry after removal: " + table.get("UK"));
        System.out.println("Total Entries after removal = " + table.size());
    }
}
