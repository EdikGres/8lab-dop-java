package com.company;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static int n, k;
    static int[] a;

    public static void main(String[] args) {

//        GeneratorWorker w = new GeneratorWorker(1,  4, 3);
//        GeneratorWorker r = new GeneratorWorker(2,  4, 3);
//        GeneratorWorker a = new GeneratorWorker(3, 4, 3);
//        GeneratorWorker b = new GeneratorWorker(4, 4, 3);
//        w.run();
//        r.run();
//        a.run();
//        b.run();
        Generator generator = new Generator(1, 8, 10, 8);
        System.out.println("multithreading: ");
        Date start = new Date();
        generator.generate();
        Date end = new Date();
        long multi = end.getTime() - start.getTime();
//        System.out.println("Time taken in milli seconds: " + );

        System.out.println("1 thread: ");
        start = new Date();
        n = 8;
        k = 10;
        a = new int[k];
        p2(0, 1);
        end = new Date();
//        System.out.println("Time taken in milli seconds: " + (end.getTime() - start.getTime()));
        long one_thread = end.getTime() - start.getTime();

        System.out.println("MULTI: Time taken in milli seconds: " + multi);
        System.out.println("1Thread: Time taken in milli seconds: " + one_thread);

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

}


