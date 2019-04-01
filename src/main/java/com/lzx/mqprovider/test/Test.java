package com.lzx.mqprovider.test;

import sun.misc.Unsafe;

import java.util.concurrent.locks.LockSupport;

public class Test {
    public static void main(String []argv){
        Thread currentThread = Thread.currentThread();
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(currentThread);
        });
        thread.start();
        LockSupport.park();
        System.out.println("signal");
    }
}
