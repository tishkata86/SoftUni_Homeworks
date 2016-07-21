package Problem10_11_Tuple_Threeuple;

public class Tuple<T> {

    private T itemOne;
    private T itemTwo;

    public Tuple(T itemOne, T itemTwo) {
        this.setItemOne(itemOne);
        this.setItemTwo(itemTwo);
    }

    public T getItemOne() {
        return itemOne;
    }

    private void setItemOne(T itemOne) {
        this.itemOne = itemOne;
    }

    public T getItemTwo() {
        return itemTwo;
    }

    private void setItemTwo(T itemTwo) {
        this.itemTwo = itemTwo;
    }

    @Override
    public String toString() {
        return itemOne + " -> " + itemTwo;
    }
}
