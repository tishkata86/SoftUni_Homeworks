package Problem09_CollectionHierarchy.models;

import Problem09_CollectionHierarchy.interfaces.Addable;

import java.util.LinkedList;
import java.util.List;

public class AddCollection implements Addable {
    private List<String> collection;

    public AddCollection() {
        this.collection = new LinkedList<>();
    }

    protected AddCollection(List<String> collection) {
        this.collection = collection;
    }

    protected List<String> getCollection() {
        return collection;
    }

    @Override
    public int addToCollection(String string) {
        this.getCollection().add(string);
        return this.getCollection().size() - 1;
    }
}
