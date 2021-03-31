package dp.fib;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        IFibonacci fibonacci = new MemoFib();
        System.out.println(fibonacci.calc(40));
    }
}

interface IFibonacci {
    int calc(int n);
}

class RecursiveFib implements IFibonacci{

    @Override
    public int calc(int n) {
        if(n <= 2) {
            return 1;
        }

        return calc(n-1) + calc(n-2);
    }
}

class MemoFib implements IFibonacci{

    @Override
    public int calc(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        return calc(n, arr);
    }

    private int calc(int n, int[] arr) {
        if(arr[n] == -1) {
            arr[n] = calc(n-1, arr) + calc(n-2, arr);
        }

        return arr[n];
    }
}