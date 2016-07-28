package Problem01_02_ListyIterator_Collection;

public interface ListyIterator<T> {

    void Create(T... list);

    boolean Move();

    boolean HasNext();

    void Print();

    void PrintAll();
}
