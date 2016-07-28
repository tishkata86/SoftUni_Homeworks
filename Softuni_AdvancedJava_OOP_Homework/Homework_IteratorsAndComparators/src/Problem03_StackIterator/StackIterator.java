package Problem03_StackIterator;

import java.util.List;

public interface StackIterator<Integer> extends Iterable<Integer> {

    void push(List<Integer> elements);

    void pop();
}
