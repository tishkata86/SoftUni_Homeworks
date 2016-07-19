package Problem05_06_GenericCountMethodStrings;

public class Box<T> implements Comparable<T> {
    private T value;

    public Box(T value) {
        this.setValue(value);
    }

    public T getValue() {
        return value;
    }

    private void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.getClass().getTypeName() + ": " + value;
    }

    @Override
    public int compareTo(T item) {
        if (item.getClass().getName().equals("String")) {
            return this.value.toString().compareTo(item.toString());
        } else {
            double currentItem = Double.parseDouble((String) item);
            return Double.compare((Double) this.value, currentItem);
        }
    }
}
