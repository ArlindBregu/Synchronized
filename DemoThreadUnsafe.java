/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread3;
import java.util.Random;
/**
 *
 * @author arlin
 */
public class DemoThreadUnsafe {

    static Random random = new Random(System.currentTimeMillis());
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();
        
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.increment();
                    DemoThreadUnsafe.sleep();
                }
            }
        });
        
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.decrement();
                    DemoThreadUnsafe.sleep();
                }
            }
        });
        
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
        
        badCounter.printFinalCounterValue();


        
    }
    
    public static void sleep() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException ie) {
        }
    }
    
}
