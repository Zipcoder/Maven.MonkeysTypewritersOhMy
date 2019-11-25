package io.zipcoder;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {


    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        Random random = new Random();
        int randomSleep = random.nextInt((200 - 50) + 1) + 50;
        ReentrantLock lock = new ReentrantLock();

        while (stringIterator.hasNext()) {
            lock.lock();
            try {

                //Do some work



                synchronized (stringIterator) {
                    String holder = stringIterator.next() + " ";
                    Thread.sleep(randomSleep);
                    copied += holder;
                    System.out.println(Thread.currentThread().getName());
                }
                } catch(Exception e){

                } finally{
                    lock.unlock();
                }

            }


            copied = copied.trim();

        }
    }
