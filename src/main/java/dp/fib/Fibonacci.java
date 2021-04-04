package dp.fib;

import dp.model.DpCalcType;

import java.util.Arrays;

public class Fibonacci {

    private final IFibonacci fibonacci;

    public Fibonacci(DpCalcType dpCalcType) {
        switch (dpCalcType) {
            case MEMO:
                fibonacci = new MemoFib();
                break;
            case TABULATION:
                fibonacci = new TabFib();
                break;
            case RECURSIVE:
            default:
                fibonacci = new RecursiveFib();
                break;
        }
    }

    public int find(int n) {
        return fibonacci.find(n);
    }

    private interface IFibonacci {
        int find(int n);
    }

    private static class RecursiveFib implements IFibonacci{

        @Override
        public int find(int n) {
            if(n <= 2) {
                return 1;
            }

            return find(n-1) + find(n-2);
        }
    }

    private static class MemoFib implements IFibonacci{

        @Override
        public int find(int n) {
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

    private static class TabFib implements IFibonacci{

        @Override
        public int find(int n) {
            int[] arr = new int[n+3];
            Arrays.fill(arr, 0);
            arr[0] = 0;
            arr[1] = 1;

            for (int i = 0; i <= n; i++) {
                //if(i+1 <= n) {
                    arr[i + 1] += arr[i];
               // }
                //if(i+2 <= n) {
                    arr[i + 2] += arr[i];
               // }
            }

            System.out.println(Arrays.toString(arr));

            return arr[n];
        }
    }
}

