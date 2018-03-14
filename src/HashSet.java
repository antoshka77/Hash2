import java.util.Arrays;

class HashSet {
    private int FREE = Integer.MIN_VALUE;
    private int size;
    int[] keys;
    private int link = 0;

    // Конструктор
    HashSet(int size) {
        this.size = Math.max(3 * size / 2, size) + 1;
        keys = new int[this.size];
        Arrays.fill(keys, FREE);
    }

    // Добавляет элемент в множество
    void add(int x) {
        if (link == size)
            resize();
        if (!contains(x)) {
            for (int i = index(hashCode(x)); ; i++) {
                if (i == size) i = 0;
                if (keys[i] != x) {
                    if (keys[i] == FREE) {
                        keys[i] = x;
                        link++;
                        break;
                    }
                } else break;
            }
        }
    }

    // Проверяет, содержится ли элемент в множестве
    boolean contains(int x) {
        int circle = 0;
        int value = index(hashCode(x));
        if (value > size) return false;
        for (int i = value; ; i++) {
            if (i == size){
                i = 0;
                circle++;
            }
            if (keys[i] == x) return true;
            if (keys[i] == FREE) return false;
            if (circle > 0) return false;
        }
    }

    // проверяет на равенство
    @Override
    public boolean equals(Object otherHash){
        if (otherHash instanceof HashSet){
            HashSet other = (HashSet) otherHash;
            if (size != other.size)
                return false;
            for (int i = 0; i < size; i++){
                if (keys[i] != other.keys[i])
                    return false;
            }

        }
        return true;
    }

    // Увеличивает размер таблицы, если идет переполнение
    private void resize(){
        int[] arr = new int[size * 2];
        Arrays.fill(arr, FREE);

        for (int i = 0; i < size; i++){
            arr[i] = keys[i];
        }
        this.size = size * 2;
        this.keys = arr.clone();
    }

    // хэш-функция (для других типов следует изменить)
    int hashCode(int x) {
        return (x >> 15) ^ x;
    }

    // возвращает отступ для данного значения хэш-функции
    public int index(int hash) {
        return Math.abs(hash) % size;
    }
}
