package ds.stack;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleListStackTest {
    @Test
    public void test_basic() {
        SimpleListStack<String> stack = new SimpleListStack<>();
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