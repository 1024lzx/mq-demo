package com.lzx.mqprovider.test;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Q2 {
    private static AtomicInteger num = new AtomicInteger(0);

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ExecutorService service = Executors.newFixedThreadPool(N);
        for(int i=0;i<N;i++){
            service.submit(new Task(num,i,N));
        }
        service.shutdown();
        try {
            service.awaitTermination(10,TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class Task implements Runnable{
    private AtomicInteger num;
    private int index;
    private int N;

    public Task(AtomicInteger num,int index,int N){
        this.num = num;
        this.index = index;
        this.N = N;
    }

    @Override
    public void run() {
        while(num.get() <= 100){
            if(num.get() <= 100 && num.get()%N == index){
                System.out.println("thread"+index+":"+num.get());
                num.incrementAndGet();
            }
        }
    }
}
