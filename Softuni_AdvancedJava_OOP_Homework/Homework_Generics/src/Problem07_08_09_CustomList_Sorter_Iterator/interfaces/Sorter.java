package Problem07_08_09_CustomList_Sorter_Iterator.interfaces;

public interface Sorter<T extends Comparable<T>> {

    void sort(CustomList<T> elements);
}
