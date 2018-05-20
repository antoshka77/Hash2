
class HashSet {
    private int size;
    Entry[] keys;
    int link = 0;

    // Конструктор
    HashSet(int size) {
        if (size < 2)
            this.size = 2;
        else
            this.size = size;
        keys = new Entry[this.size];
    }

    HashSet() {
        this(16);
    }

    class Entry {
        int value;
        Entry next = null;

        Entry(int init) {
            value = init;
            link++;
        }

        boolean equals(Entry other) {
            Entry a, b;
            for (a = this, b = other; a != null && b != null; a = a.next, b = b.next) {
                if (a.value != b.value)
                    return false;
            }
            return a == b;
        }
    }

    // Добавляет элемент в множество
    void add(int x) {
        int ind = index(x);
        if (keys[ind] == null) {
            keys[ind] = new Entry(x);
        } else {
            Entry pre = keys[ind];
            for (Entry current = pre; current != null; pre = current, current = current.next) {
                if (current.value == x)
                    return;
            }
            pre.next = new Entry(x);
        }
        if (link == size) {
            resize();
        }
    }

    // Удалить элемент из множества
    boolean remove(int x) {
        int ind = index(x);
        Entry current = keys[ind];
        if (current == null)
            return false;
        if (current.value == x) {
            link--;
            keys[ind] = current.next;
            return true;
        }
        for (Entry pre = current; current != null; pre = current, current = current.next) {
            if (x == current.value) {
                link--;
                pre.next = current.next;
                return true;
            }
        }
        return false;
    }

    // Проверяет, содержится ли элемент в множестве
    boolean contains(int x) {
        for (Entry current = keys[index(x)]; current != null; current = current.next) {
            if (x == current.value)
                return true;
        }
        return false;
    }

    // проверяет на равенство
    @Override
    public boolean equals(Object otherHash){
        if (otherHash instanceof HashSet){
            HashSet other = (HashSet) otherHash;
            if (size != other.size || link != other.link)
                return false;
            for (int i = 0; i < size; i++){
                Entry a = keys[i], b = other.keys[i];
                if (a != b && (a == null || b == null || !a.equals(b)))
                    return false;
            }
            return true;
        }
        return false;
    }

    // Увеличивает размер таблицы, если идет переполнение
    private void resize(){
        size = size * 2;
        Entry[] old = keys;
        keys = new Entry[size];
        link = 0;
        for (Entry element : old) {
            for (Entry current = element; current != null; current = current.next) {
                add(current.value);
            }
        }
    }

    // возвращает отступ для данного значения хэш-функции
    public int index(int hash) {
        return Math.abs(hash) % size;
    }
}
