package Problem09_CollectionHierarchy.models;

import Problem09_CollectionHierarchy.interfaces.Usable;

import java.util.LinkedList;

public class MyList extends AddRemoveCollection implements Usable{
    public MyList() {
        super(new LinkedList<>());
    }

    @Override
    public String remove() {
        return super.getCollection().remove(0);
    }

    @Override
    public long used() {
        return super.getCollection().size();
    }
}
