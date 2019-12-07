package io.zipcoder;

import com.sun.codemodel.internal.JCatchBlock;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{
    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        try {
            while (this.stringIterator.hasNext()) {
                synchronized (stringIterator) {
                    if (stringIterator.hasNext()) {
                        String word = stringIterator.next();
                        sleep(new Random().nextInt(20));
                        copied += word + " ";

                        //System.out.println("*****" + Thread.currentThread().getName() + "*****");
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//synchronized block, lock and unlock
        //ReentrantLock
//          Synchronized signature clause
//        Synchronous blocks

//while (this.stringIterator.hasNext(){
//            String foo = this.stringIterator.next();
//            this.copied.concat(foo);
//            return this.copied