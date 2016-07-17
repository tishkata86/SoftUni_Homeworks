package Problem09_CollectionHierarchy.models;

import Problem09_CollectionHierarchy.interfaces.Removable;

import java.util.LinkedList;
import java.util.List;

public class AddRemoveCollection extends AddCollection implements Removable {

    public AddRemoveCollection() {
        super(new LinkedList<>());
    }

    protected AddRemoveCollection(List<String> collection) {
        super(collection);
    }

    @Override
    public int addToCollection(String string){
        super.getCollection().add(0, string);
        return 0;
    }

    @Override
    public String remove() {
        int size = super.getCollection().size();
        return super.getCollection().remove(size-1);
    }
}
