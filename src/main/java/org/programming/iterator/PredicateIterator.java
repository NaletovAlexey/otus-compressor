/*
PredicateIterator.java

Copyright © 1982-2026$ Naletov Alexey. All rights reserved.
THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Naletov Alexey.
The copyright notice above does not evidence any actual
or intended publication of such source code.
*/
package org.programming.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * @author Naletov Alexey
 */
public class PredicateIterator<T> implements Iterator<T>
{
    private final Predicate<T> predicate;
    private int position = 0;
    private final T[] data;

    public PredicateIterator(Predicate<T> predicate, T[] data)
    {
        this.predicate = predicate;
        this.data = data;
    }

    @Override
    public boolean hasNext()
    {
        int cursor = position;
        while (cursor < data.length)
        {
            if (predicate.test(data[cursor]))
                return true;
            cursor++;
        }
        return false;
    }

    public T next()
    {
        while (hasNext())
        {
            if ( predicate.test(data[position] ))
            {
                return data[position++];
            }
            position++;
        }
        throw new NoSuchElementException();
    }
}