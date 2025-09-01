package SirMossen;

public class NumberOfCollisionFindInHashTable {
    private static class Entry {
        final String key;
        final Country2 value;
        Entry(String k, Country2 v) { key = k; value = v; }
    }

    private final Entry[] table;        // actual hash table (linear probing)
    private final int tableSize;
    private final String[][] rows;      // [key, country, rawIdx, finalIdx]
    private int rowCount = 0;

    // collision tracking
    private final int[] rawFreq;
    private int rawCollisionCount = 0;
    private int probeCollisionCount = 0;

    NumberOfCollisionFindInHashTable(int tableSize, int expectedItems) {
        this.tableSize = tableSize;
        this.table = new Entry[tableSize];
        this.rows = new String[expectedItems][4];
        this.rawFreq = new int[tableSize];
    }

    // --- Naïve hash2: ASCII sum % tableSize
    private int hash2(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) sum += key.charAt(i);
        return sum % tableSize;
    }

    public void put(String key, Country2 country) {
        int rawIndex = hash2(key);

        // raw collision
        if (rawFreq[rawIndex] > 0) rawCollisionCount++;
        rawFreq[rawIndex]++;

        // probing to find final slot
        int finalIndex = -1;
        for (int step = 0; step < tableSize; step++) {
            int j = (rawIndex + step) % tableSize;
            Entry e = table[j];
            if (e == null) {
                table[j] = new Entry(key, country);
                finalIndex = j;
                break;
            }
            if (e.key.equals(key)) {
                table[j] = new Entry(key, country); // overwrite
                finalIndex = j;
                break;
            }
            probeCollisionCount++;
        }

        // log into 2D array
        if (rowCount < rows.length) {
            rows[rowCount][0] = key;
            rows[rowCount][1] = country.toString(); // use your Country2.toString()
            rows[rowCount][2] = String.valueOf(rawIndex);
            rows[rowCount][3] = String.valueOf(finalIndex);
            rowCount++;
        }
    }

    public void printRows() {
        System.out.println("Key\tRawIdx\tFinalIdx\tCountry");
        System.out.println("==================================================");
        for (int i = 0; i < rowCount; i++) {
            System.out.println(rows[i][0] + "\t" +
                    rows[i][2] + "\t" +
                    rows[i][3] + "\t" +
                    rows[i][1]);
        }
    }

    public void printCollisionSummary() {
        System.out.println("\n--- Collision Summary ---");
        System.out.println("Raw collisions (same raw index repeated): " + rawCollisionCount);
        System.out.println("Probing collisions (occupied slots skipped): " + probeCollisionCount);

        System.out.println("\nIndexes with repeats (raw):");
        for (int i = 0; i < rawFreq.length; i++) {
            if (rawFreq[i] > 1) {
                System.out.println("  index " + i + " -> freq " + rawFreq[i] +
                        " (collisions: " + (rawFreq[i] - 1) + ")");
            }
        }
    }

    // --- MAIN DRIVER WITH 30 COUNTRIES ---
    public static void main(String[] args) {
        NumberOfCollisionFindInHashTable ht = new NumberOfCollisionFindInHashTable(40, 30);

        ht.put("PK", new Country2(1209, 1000, "Pakistan", "Urdu"));
        ht.put("IN", new Country2(17909, 145000, "India", "Hindi"));
        ht.put("CN", new Country2(9596961, 1412000000, "China", "Mandarin"));
        ht.put("US", new Country2(9833517, 331000000, "USA", "English"));
        ht.put("UK", new Country2(243610, 67000000, "United Kingdom", "English"));
        ht.put("SA", new Country2(2149690, 36000000, "Saudi Arabia", "Arabic"));
        ht.put("JP", new Country2(377975, 125000000, "Japan", "Japanese"));
        ht.put("FR", new Country2(551695, 67000000, "France", "French"));
        ht.put("DE", new Country2(357386, 83000000, "Germany", "German"));
        ht.put("IT", new Country2(301340, 59000000, "Italy", "Italian"));
        ht.put("IR", new Country2(1648195, 85000000, "Iran", "Persian"));
        ht.put("AF", new Country2(652230, 40000000, "Afghanistan", "Pashto"));
        ht.put("BD", new Country2(147570, 170000000, "Bangladesh", "Bengali"));
        ht.put("RU", new Country2(17098246, 146000000, "Russia", "Russian"));
        ht.put("NP", new Country2(147516, 30000000, "Nepal", "Nepali"));
        ht.put("LK", new Country2(65610, 22000000, "Sri Lanka", "Sinhala"));
        ht.put("MY", new Country2(330803, 33000000, "Malaysia", "Malay"));
        ht.put("TH", new Country2(513120, 70000000, "Thailand", "Thai"));
        ht.put("TR", new Country2(783562, 85000000, "Turkey", "Turkish"));
        ht.put("EG", new Country2(1002450, 110000000, "Egypt", "Arabic"));
        ht.put("ES", new Country2(505990, 47000000, "Spain", "Spanish"));
        ht.put("CA", new Country2(9984670, 38000000, "Canada", "English/French"));
        ht.put("BR", new Country2(8515767, 213000000, "Brazil", "Portuguese"));
        ht.put("AU", new Country2(7692024, 26000000, "Australia", "English"));
        ht.put("NZ", new Country2(268021, 5000000, "New Zealand", "English"));
        ht.put("MX", new Country2(1964375, 126000000, "Mexico", "Spanish"));
        ht.put("AR", new Country2(2780400, 45000000, "Argentina", "Spanish"));
        ht.put("CL", new Country2(756102, 19000000, "Chile", "Spanish"));
        ht.put("ZA", new Country2(1221037, 60000000, "South Africa", "Zulu/English"));
        ht.put("NG", new Country2(923768, 206000000, "Nigeria", "English"));

        ht.printRows();
        ht.printCollisionSummary();
    }
}

