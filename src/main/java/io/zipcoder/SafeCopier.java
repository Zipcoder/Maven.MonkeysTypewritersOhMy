package io.zipcoder;

import java.util.Random;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {
    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        String nextWord = "";
        try {
            while(this.stringIterator.hasNext()) {
//                nextWord = this.stringIterator.next() + " ";
//                Thread.sleep(new Random().nextInt(50));
//                this.copied += nextWord;
                getWord();
            }
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private synchronized void getWord() throws InterruptedException {
        if (this.stringIterator.hasNext()) {
            String nextWord = this.stringIterator.next() + " ";
            Thread.sleep(new Random().nextInt(50));
            System.out.println(Thread.currentThread().getName());
            this.copied += nextWord;
        }
    }
}
