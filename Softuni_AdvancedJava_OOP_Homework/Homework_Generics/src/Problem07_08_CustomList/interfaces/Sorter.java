package Problem07_08_CustomList.interfaces;

import java.util.List;

public interface Sorter<T extends Comparable<T>> {

    void sort(CustomList<T> elements);
}
