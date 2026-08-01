package course4.ruleofbiodome05;

public class PlantHashMap<K, V> {
    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int CAPACITY = 16;
    private Entry<K, V> [] entries;

    @SuppressWarnings("unchecked")
    public PlantHashMap() {
        this.entries = (Entry<K, V>[]) new Entry[CAPACITY];
    }

//    public void put(K key, V value) {
//        entries[getIndex(key)] = new Entry<>(key, value);
//        System.out.println("'" + key + "' 추가: '" + value + "'");
//    }
    public void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (entries[index] == null) {
            entries[index] = newEntry;
        } else {
            Entry<K, V> current = entries[index];

            while (current.next != null) {
                current = current.next;
            }
            current.next = newEntry;
        }
        System.out.println("'" + key + "' 추가: '" + value + "'");
    }

//    public void get(K key) {
//        int index = getIndex(key);
//        System.out.println("식물 특징 검색");
//        if (entries[index] != null && entries[index].key.equals(key)) {
//            System.out.println("'" + key + "' 검색: '" + entries[index].value + "'");
//        }
//    }
    public void get(K key) {
        int index = getIndex(key);
        System.out.println("식물 특징 검색");

        if (entries[index] != null && entries[index].key.equals(key)) {
            System.out.println("'" + key + "' 검색: '" + entries[index].value + "'");
            return;
        } else {
            Entry<K, V> current = entries[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    System.out.println("'" + key + "' 검색: '" + current.value + "'");
                    return;
                }
                current = current.next;
            }
        }
    }

//    public void remove(K key) {
//        System.out.println("식물 삭제");
//        int index = getIndex(key);
//        if (entries[index] != null && entries[index].key.equals(key)) {
//            entries[index] = null;
//            System.out.println("'" + key + "' 삭제: '" + key + "' 와 그 특징이 삭제되었습니다.");
//        }
//    }

    public void remove(K key) {
        System.out.println("식물 삭제");
        int index = getIndex(key);
        if (entries[index] == null) {
            System.out.println("'" + key + "'에 해당하는 식물이 없습니다.");
            return;
        }
        if (entries[index].key.equals(key)) {
            entries[index] = entries[index].next;
            System.out.println("'" + key + "' 삭제: '" + key + "' 와 그 특징이 삭제되었습니다.");
            return;
        }

        Entry<K, V> previous = entries[index];
        Entry<K, V> current = entries[index].next;

        while (current != null) {
            if (current.key.equals(key)) {
                previous.next = current.next;
                System.out.println("'" + key + "' 삭제: '" + key + "' 와 그 특징이 삭제되었습니다.");
                return;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("'" + key + "'에 해당하는 식물이 없습니다.");
    }

    public int getIndex(K key) {
        return Math.floorMod(key.hashCode(), CAPACITY);
    }

    public void getIndexInfo(K key) {
        System.out.println("식물 이름으로 인덱스 출력");
        System.out.println("'" + key + "' 인덱스: " + getIndex(key));
    }
}
