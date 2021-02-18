package ds.stack;

import java.util.EmptyStackException;

public class SimpleArrayStack<T> {

    private int top;
    private T[] backingArray;

    public SimpleArrayStack() {
        this(16);
    }

    public SimpleArrayStack(int size) {
        //noinspection unchecked
        this.backingArray = (T[]) new Object[size];
        this.top = 0;
    }

    public void push(T element) {
        if(top == backingArray.length) {
            //noinspection unchecked
            T[] newBackingArray = (T[]) new Object[backingArray.length * 2];
            System.arraycopy(backingArray, 0, newBackingArray, 0, backingArray.length);
            backingArray = newBackingArray;
        }

        this.backingArray[this.top++] = element;
    }

    public T pop() {
        if(isEmpty()) {
            //return null;
            throw new EmptyStackException();
        }

        return this.backingArray[--this.top];
    }

    public T peek() {
        if(isEmpty()) {
            //return null;
            throw new EmptyStackException();
        }

        return this.backingArray[this.top-1];
    }

    public boolean isEmpty() {
        return top == 0;
    }
}
