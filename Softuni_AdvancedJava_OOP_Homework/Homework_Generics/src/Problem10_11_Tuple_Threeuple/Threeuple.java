package Problem10_11_Tuple_Threeuple;

public class Threeuple<T> extends Tuple {
    private T itemThree;

    public Threeuple(T itemOne, T itemTwo, T itemThree) {
        super(itemOne, itemTwo);
        this.setItemThree(itemThree);
    }

    public T getItemThree() {
        return itemThree;
    }

    private void setItemThree(T itemThree) {
        this.itemThree = itemThree;
    }

    @Override
    public String toString() {
        return super.toString() + " -> " + itemThree;
    }
}
