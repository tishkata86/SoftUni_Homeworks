package Problem03_StackIterator;

import java.util.*;

public class StackIteratorImpl<Integer> implements StackIterator<Integer>, Iterable<Integer>{
    private Stack<Integer> stack;

    public StackIteratorImpl() {
        this.stack = new Stack<>();
    }

    private Stack<Integer> getStack() {
        return stack;
    }

    @Override
    public void push(List<Integer> elements) {
        for (Integer element : elements) {
            this.stack.push(element);
        }
    }

    @Override
    public void pop() {
        if (this.stack.size() == 0){
            System.out.printf("No elements");
        } else {
            this.stack.pop();
        }
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            Stack<Integer> integerStack = new Stack<>();

            @Override
            public boolean hasNext() {
                if (getStack().size() != 0){
                    return true;
                }
                if (getStack().size() == 0){
                    int size = integerStack.size();
                    for (int i = 0; i < size; i++) {
                        getStack().push(integerStack.pop());
                    }
                }
                return false;
            }

            @Override
            public Integer next() {
                integerStack.add(getStack().peek());
                return getStack().pop();
            }
        };
    }
}
