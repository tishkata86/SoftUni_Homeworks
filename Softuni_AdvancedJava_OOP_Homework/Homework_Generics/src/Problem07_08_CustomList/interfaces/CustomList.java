package Problem07_08_CustomList.interfaces;

import java.util.List;

public interface CustomList<T extends Comparable<T>>{

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
