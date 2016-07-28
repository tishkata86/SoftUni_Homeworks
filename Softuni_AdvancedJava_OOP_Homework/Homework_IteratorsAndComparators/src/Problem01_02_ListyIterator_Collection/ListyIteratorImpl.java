package Problem01_02_ListyIterator_Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIteratorImpl<T> implements ListyIterator<T>, Iterable<T>{

    private List<T> list;
    private int index;

    public ListyIteratorImpl() {
        this.setList(list);
        this.index = 0;
    }

    private void setList(List<T> list) {
        this.list = new ArrayList<>();
    }

    public int getSize(){
        return this.list.size();
    }

    public List<T> getList(){
        return this.list;
    }

    @Override
    public void Create(T... list) {
        this.list = Arrays.asList(list);
    }

    @Override
    public boolean Move() {
        if (index + 1 < this.list.size()){
            index++;
            return true;
        }
        return false;
    }

    @Override
    public boolean HasNext() {
        return getSize() > this.index + 1;
    }

    @Override
    public void Print() {
        if (this.list.size() == 0){
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(list.get(index));
        }
    }

    @Override
    public void PrintAll() {
        for (T elem : this) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < getSize();
            }

            @Override
            public T next() {
                return getList().get(index++);
            }
        };
    }
}
