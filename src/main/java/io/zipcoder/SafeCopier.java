package io.zipcoder;

import java.util.Random;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{


    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    @Override
    public void run() {

        String nextWord;
        try {
            while (this.stringIterator.hasNext()) {
                nextWord = this.stringIterator.next() + " ";
                Thread.sleep(new Random().nextInt(20));
//                String currentThread = Thread.currentThread().getName();
//                System.out.println("THREAD: " + currentThread + " HAS FINISHED");
                this.copied += nextWord;
            }
//            System.out.println(this.copied);
//            System.out.println("------------------------------------");
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
