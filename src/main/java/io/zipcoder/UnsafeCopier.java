package io.zipcoder;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        try {
            while (this.stringIterator.hasNext()) {
                Thread.sleep(100);
                String foo = this.stringIterator.next();
                this.copied.concat(foo).concat(" ");
                String currentThread = Thread.currentThread().getName();
                System.out.println("THREAD: " + currentThread + " HAS FINISHED");
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
