/*
commonResourse.java

Copyright © 1982-2026$ Naletov Alexey. All rights reserved.
THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Naletov Alexey.
The copyright notice above does not evidence any actual
or intended publication of such source code.
*/
package org.programming.deadlock;

/**
 * @author Naletov Alexey
 */
public class DeadLockExample
{
    final Object lock1 = new Object();
    final Object lock2 = new Object();

    void processOne()
    {
        synchronized (lock1)
        {
            try
            {
                System.out.println("processOne started: lock1");
                Thread.sleep(1000);
                synchronized (lock2)
                {
                    System.out.println("processOne started: lock2");
                }
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            finally
            {
                System.out.println("processOne finished");
            }
        }
    }

    void processTwo()
    {
        synchronized (lock2)
        {
            try
            {
                System.out.println("processTwo started: lock2");
                Thread.sleep(1000);
                synchronized (lock1)
                {
                    System.out.println("processTwo started: lock1");
                }
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            finally
            {
                System.out.println("processTwo finished");
            }
        }
    }
}