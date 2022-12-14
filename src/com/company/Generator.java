package com.company;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    private final int start;
    private final int n; // число объектов
    private final int k; // длина сочетания
    private final List<Thread> threads;
    private final int threads_size;

    public Generator(int start, int n, int k, int threads_size) {
        this.n = n;
        this.k = k;
        this.start = start;
        threads = new ArrayList<Thread>();
        this.threads_size = threads_size;
    }

    void generate() {
        for (int i = start; i <= n; i++){
            Thread thread = new Thread(new GeneratorWorker(i, n, k));
            thread.start();
            threads.add(thread);
            if(threads.size() % this.threads_size == 0)
                waitThreads(threads);
        }
        waitThreads(threads);
    }
    public static void waitThreads(List<Thread> threads){
        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        threads.clear();
    }
}
