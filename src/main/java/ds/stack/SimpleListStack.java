package ds.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class SimpleListStack<T> {
    private int top;
    private final List<T> backingList;

    public SimpleListStack() {
        this.backingList = new LinkedList<T>();
        this.top = 0;
    }

    public void push(T element) {
        this.backingList.add(this.top++, element);
    }

    public T pop() {
        if(isEmpty()) {
            //return null;
            throw new EmptyStackException();
        }

        return this.backingList.get(--this.top);
    }

    public T peek() {
        if(isEmpty()) {
            //return null;
            throw new EmptyStackException();
        }

        return this.backingList.get(this.top - 1);
    }

    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public String toString() {
        List<String> list = new ArrayList<>(top-1);
        for (int i = top-1; i >= 0; i--) {
            list.add(this.backingList.get(i).toString());
        }

        return String.join(",", list);
    }
}
