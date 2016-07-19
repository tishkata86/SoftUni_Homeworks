package Problem07_08_CustomList;

import Problem07_08_CustomList.interfaces.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T>{
    private List<T> elements;

    public CustomListImpl() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void add(T element) {
        this.elements.add(element);
    }

    @Override
    public T remove(int index) {
        return this.elements.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    @Override
    public void swap(int indexOne, int indexTwo) {
        Collections.swap(this.elements, indexOne, indexTwo);
    }

    @Override
    public int countGreaterThan(T element) {
        return (int)this.elements.stream().filter(value -> value.compareTo(element) > 0).count();
    }

    @Override
    public T getMax() {
        return this.elements.stream().max(Comparable::compareTo).get();
    }

    @Override
    public T getMin() {
        return this.elements.stream().min(Comparable::compareTo).get();
    }

    @Override
    public int getSize() {
        return this.elements.size();
    }

    @Override
    public T get(int index) {
        return this.elements.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            sb.append(element).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
