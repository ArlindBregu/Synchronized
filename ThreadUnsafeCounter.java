/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread3;

/**
 *
 * @author arlin
 */
public class ThreadUnsafeCounter {
    
    int count = 0;
    
    public synchronized void increment(){
    
        count ++;
    }
    
    public synchronized void decrement(){
    
        count --;
    }
    
    public void printFinalCounterValue(){
    
         System.out.println("counter is: " + count);
    }
    
}
