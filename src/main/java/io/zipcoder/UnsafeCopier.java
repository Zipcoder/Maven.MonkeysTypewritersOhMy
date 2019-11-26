package io.zipcoder;

import java.util.Random;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {
    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        Random random = new Random();
        int randomSleep = random.nextInt((100-50)+1)+50;
        while (stringIterator.hasNext()) {
            try {
                String holder = stringIterator.next() + " ";
                Thread.sleep(randomSleep);
                copied += holder;
            } catch (InterruptedException e) {
                System.out.println("MAIN INTERRUPTED");
            }
            System.out.println(Thread.currentThread().getName());

        }

        copied = copied.trim();


        }
    }

