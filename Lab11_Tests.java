import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.*;
import java.io.*;
import java.net.*;
import java.time.*;

public class Lab11_Tests {
    /*
        Complete the test case below that checks to see that threads A and B have both contributed 100 entries respectively
        to the shared ArrayList when they have both finished running.
    */
    @Test
    public void test1() {
        Lab11_Thread threadA = new Lab11_Thread("A1", 100);
        Lab11_Thread threadB = new Lab11_Thread("B1", 100);

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<String> sharedData = threadA.getData();

        int countA = 0;
        int countB = 0;
        
        for (int i = 0; i < sharedData.size(); i++) {
            String entry = sharedData.get(i);
            if (entry.startsWith("A1")) {
                countA++;
            } else if (entry.startsWith("B1")) {
                countB++;
            }
        }
        
        assertEquals("Thread A: 100 entries", 100, countA);
        assertEquals("Thread B: entries", 100, countB);
        assertEquals("Total entries: 200", 200, sharedData.size());

    }

    /*
        Complete the test case below that checks to see if the shared ArrayList has at least 10 entries after 500ms of system time
    */
   /*
    @Test
    public void test2() {

        Lab11_Thread threadA = new Lab11_Thread("A2", 500);
        Lab11_Thread threadB = new Lab11_Thread("B2", 500);

        threadA.start();
        threadB.start();
        try {
            Thread.sleep(500); 
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    */

    /*
        Complete the test case below that checks to see if thread A finishes adding its 10 entries before thread B was allowed to 
        add anything to the shared ArrayList
    */
   /*
    @Test
    public void test3() {
        Lab11_Thread threadA = new Lab11_Thread("A3", 10);
        Lab11_Thread threadB = new Lab11_Thread("B3", 10);

        threadA.start();
        
        try {
            threadA.join();
        } catch (Exception e){
            e.printStackTrace();
        }
        
        threadB.start();
    }
    */
}
