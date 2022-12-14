package com.company;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static int n, k;
    static int[] a;
    static int arr_size = 4; // -1
    static int[] arr = new int[arr_size+1];

    public static void main(String[] args) {
            for (int i = 0, j = 1; i <=arr_size; i++, j++){
                arr[i] = j;
            }
//        GeneratorWorker w = new GeneratorWorker(1,  4, 3);
//        GeneratorWorker r = new GeneratorWorker(2,  4, 3);
//        GeneratorWorker a = new GeneratorWorker(3, 4, 3);
//        GeneratorWorker b = new GeneratorWorker(4, 4, 3);
//        w.run();
//        r.run();
//        a.run();
//        b.run();
        Generator generator = new Generator(1, 4, 4, 8);
        System.out.println("multithreading: ");
        Date start = new Date();
        generator.generate();
        Date end = new Date();
        long multi = end.getTime() - start.getTime();
//        System.out.println("Time taken in milli seconds: " + );

        System.out.println("1 thread: ");

        int n = arr_size;
        int r = 4;
        start = new Date();
        CombinationRepetition(arr, n, r);
        end = new Date();
        long one_thread2 = end.getTime() - start.getTime();

        System.out.println("MULTI: Time taken in milli seconds: " + multi);
        System.out.println("1Thread: Time taken in milli seconds: " + one_thread2);


    }


    static void p2(int pos, int maxUsed) {
        if(pos == k) {
            System.out.println(Arrays.toString(a));
        } else {
            for(int i = maxUsed; i <= n; i++) {
                a[pos] = i;
                p2(pos+1,i);
            }
        }
    }

    static void CombinationRepetitionUtil(int chosen[], int arr[],
                                          int index, int r, int start, int end) {
        // Since index has become r, current combination is
        // ready to be printed, print
        if (index == r) {
            for (int i = 0; i < r; i++) {
                System.out.printf("%d ", arr[chosen[i]]);
            }
            System.out.printf("\n");
            return;
        }

        // One by one choose all elements (without considering
        // the fact whether element is already chosen or not)
        // and recur
        for (int i = start; i <= end; i++) {
            chosen[index] = i;
            CombinationRepetitionUtil(chosen, arr, index + 1,
                    r, i, end);
        }
        return;
    }

    // The main function that prints all combinations of size r
// in arr[] of size n with repetitions. This function mainly
// uses CombinationRepetitionUtil()
    static void CombinationRepetition(int arr[], int n, int r) {
        // Allocate memory
        int chosen[] = new int[r + 1];

        // Call the recursive function
        CombinationRepetitionUtil(chosen, arr, 0, r, 0, n - 1);
    }

}


