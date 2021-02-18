package ds.stack;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleArrayStackTest {

    @Test
    public void test_basic() {
        SimpleArrayStack<String> stack = new SimpleArrayStack<>();
        stack.push("Hello");
        stack.push("world");

        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        assertThrows(EmptyStackException.class, () -> System.out.println(stack.pop()));
    }

    @Test
    public void test_basic_growing() {
        SimpleArrayStack<String> stack = new SimpleArrayStack<>(1);
        stack.push("Hello");
        stack.push("world");

        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        assertThrows(EmptyStackException.class, () -> System.out.println(stack.pop()));
    }
}