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
        Random rm = new Random();
        int rmSleep = rm.nextInt((500-250) + 1)+250;
        while(stringIterator.hasNext()){
            try{
                String holder = stringIterator.next()+ " ";
                Thread.sleep(rmSleep);
                System.out.println(Thread.currentThread().getName()+" " + stringIterator.next()+ " ");
                copied = copied + holder;

            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }

        }
    }
}
