/*
IteratorTest.java

Copyright © 1982-2026$ Naletov Alexey. All rights reserved.
THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Naletov Alexey.
The copyright notice above does not evidence any actual
or intended publication of such source code.
*/
package org.programming.iterator;

import java.util.function.Predicate;

/**
 * @author Naletov Alexey
 */
public class IteratorTest
{
    public static void main(String[] args)
    {
        // test predicate iterator
        Integer[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Predicate<Integer> predicate = val -> val % 2 == 0;
        PredicateIterator<Integer> predicateIterator = new PredicateIterator<>(predicate, data);
        while (predicateIterator.hasNext())
        {
            System.out.println(predicateIterator.next());
        }
        System.out.println("=======================");
        Predicate<Integer> predicate_1 = val -> val % 2 != 0;
        predicateIterator = new PredicateIterator<>(predicate_1, data);
        while (predicateIterator.hasNext())
        {
            System.out.println(predicateIterator.next());
        }
        System.out.println("=======================");
        Integer[] data_1 = { 1, 1, 3, 4, 6, 5, 16, 7, 9, 10, 10 };
        predicateIterator = new PredicateIterator<>(predicate, data_1);
        while (predicateIterator.hasNext())
        {
            System.out.println(predicateIterator.next());
        }
    }
}