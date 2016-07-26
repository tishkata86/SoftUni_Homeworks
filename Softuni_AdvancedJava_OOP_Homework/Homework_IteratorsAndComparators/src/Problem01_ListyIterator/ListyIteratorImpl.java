package Problem01_ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIteratorImpl implements ListyIterator{

    private List<String> list;
    private int index;

    public ListyIteratorImpl() {
        this.list = new ArrayList<>();
        this.index = 0;
    }

    @Override
    public void Create(String... list) {
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
        if (index + 1 < this.list.size()){
            return true;
        }
        return false;
    }

    @Override
    public void Print() {
        if (this.list.size() == 0){
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(list.get(index));
        }
    }
}
