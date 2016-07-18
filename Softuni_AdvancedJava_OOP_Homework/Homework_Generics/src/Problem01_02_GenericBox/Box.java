package Problem01_02_GenericBox;

public class Box<T> {
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
}
