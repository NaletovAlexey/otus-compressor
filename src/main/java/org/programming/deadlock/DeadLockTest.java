/*
deadlockTest.java

Copyright © 1982-2026$ Naletov Alexey. All rights reserved.
THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Naletov Alexey.
The copyright notice above does not evidence any actual
or intended publication of such source code.
*/
package org.programming.deadlock;

/**
 * @author Naletov Alexey
 */
public class DeadLockTest
{
    public static void main(String[] args)
    {
        DeadLockExample example = new DeadLockExample();
        Thread thread1 = new Thread(example::processOne);
        Thread thread2 = new Thread(example::processTwo);

        thread1.start();
        thread2.start();
    }
}