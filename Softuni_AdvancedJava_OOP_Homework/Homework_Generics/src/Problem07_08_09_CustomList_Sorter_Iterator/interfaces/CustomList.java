package Problem07_08_09_CustomList_Sorter_Iterator.interfaces;

public interface CustomList<T extends Comparable<T>> extends Iterable<T>{

    void add(T element);

    T remove(int index);

    boolean contains(T element);

    void swap(int indexOne, int indexTwo);

    int countGreaterThan(T element);

    T getMax();

    T getMin();

    int getSize();

    T get(int index);
}
