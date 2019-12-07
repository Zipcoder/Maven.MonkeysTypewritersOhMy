package io.zipcoder;

import java.util.ArrayList;
import static java.lang.Thread.sleep;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
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
        final int maxNumOfMonkeys = 5;
        UnsafeCopier unsafe = new UnsafeCopier(introduction);
        SafeCopier safeCopier = new SafeCopier(introduction);

        ArrayList<Thread> unsafeThreads = new ArrayList<Thread>();
        ArrayList<Thread> safeThreads   = new ArrayList<Thread>();

        for (int i = 0; i < maxNumOfMonkeys; i++) {
            unsafeThreads.add(new Thread(unsafe));
        }



//            for (int j = 0; j < maxNumOfMonkeys; j++) {
//                unsafeThreads.get(j).start();
//            }

        for (Thread thread : unsafeThreads){
            thread.start();
            System.out.println(thread.getName() + " Started");
        }

        try{
            for(Thread thread : unsafeThreads){
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < maxNumOfMonkeys; i++) {
            safeThreads.add(new Thread (safeCopier));
        }

        for (Thread thread : safeThreads){
            thread.start();
            System.out.println(thread.getName() + " Started");
        }

        try{
            for(Thread thread : safeThreads){
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
            //System.out.println(String.format("UNSAFE: %d\n", maxNumOfMonkeys));
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println(unsafe.copied + "\n\n");
        System.out.println(safeCopier.copied);
    }
}