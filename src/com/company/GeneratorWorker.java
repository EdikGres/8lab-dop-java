package com.company;

import java.util.Arrays;

public class GeneratorWorker implements Runnable {
    int start;
    int n,k;
    int[] a;

    public GeneratorWorker(int start, int n, int k) {
        this.start = start;
        this.n = n;
        this.k = k;
        a = new int[k];
    }

    @Override
    public void run() {
        gen(0, start);
    }

    void gen(int pos, int maxUsed) {
        if(pos == k) {
            System.out.println(Arrays.toString(a));
        } else {
            for(int i = maxUsed; i <= n; i++) {
                a[pos] = i;
                if(a[0] > start)
                    break;
                gen(pos+1,i);
            }
        }
    }
}
