package io.zipcoder;

import java.util.Random;

public class MonkeyTypewriter {
    public static void main(String[] args) throws InterruptedException {
        String introduction = "It was the best of times,\n" +
                "it was the worst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.

        final int MAXThreads = 16;

        UnsafeCopier unsafe = new UnsafeCopier(introduction);
        SafeCopier safe = new SafeCopier(introduction);

        for(int MAX = 3; MAX < MAXThreads; MAX++){
            Thread[] threads = new Thread[MAXThreads];
            for(int i = 0; i < MAXThreads; i++) {
                threads[i] = new Thread(unsafe);
            }
            for(int i = 0; i < MAXThreads; i++) {
                threads[i].start();
            }

        }

        for(int MAX = 3; MAX < MAXThreads; MAX++){
            Thread[] threads = new Thread[MAXThreads];
            for(int i = 0; i < MAXThreads; i++) {
                threads[i] = new Thread(safe);
            }
            for(int i = 0; i < MAXThreads; i++) {
                threads[i].start();
            }

            for(int i = 0; i < MAXThreads; i++){
                threads[i].join();
            }

        }

        //SafeCopier safe = new SafeCopier(introduction);


        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println("Unsafe:\n" + unsafe.copied);
        System.out.println("-------------------------------------------------------");
        System.out.println("Safe:\n" + safe.copied);
    }
}