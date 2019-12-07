package io.zipcoder;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import static java.lang.Thread.sleep; //needed to use the sleep method below

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {
    //

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        try {
            while (stringIterator.hasNext()) {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append(this.stringIterator.next()).append(" ");
                //copied += sb.toString();
                //String nextWord = this.stringIterator.next();
                //copied += nextWord;

                String word = stringIterator.next();
                sleep(new Random().nextInt(20));
                copied += word + " ";

                //System.out.println("*****" + Thread.currentThread().getName() + "*****");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
