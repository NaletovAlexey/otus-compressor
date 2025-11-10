/*
CompressRLE.java

Copyright © 1982-2025$ Naletov Alexey. All rights reserved.
THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Naletov Alexey.
The copyright notice above does not evidence any actual
or intended publication of such source code.
*/
package org.programming.compressor.algorithm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Naletov Alexey
 */
public class CompressRLE implements ICompress
{
    @Override public String getAlgorithm()
    {
        return "RLE";
    }

    @Override public String getExtension()
    {
        return ".rle";
    }

    @Override public void compress(InputStream inputFile, OutputStream outputFile) throws IOException
    {
        int prevByte = inputFile.read();
        if (prevByte == -1) return;

        int count = 1;
        int currentByte;
        while (true)
        {
            currentByte = inputFile.read();
            if (currentByte == -1) break;
            if (currentByte == prevByte && count < 255)
            {
                count++;
            }
            else
            {
                outputFile.write(prevByte);
                outputFile.write(count);
                prevByte = currentByte;
                count = 1;
            }
        }
        outputFile.write(prevByte);
        outputFile.write(count);
    }

    @Override public void decompress(InputStream inputFile, OutputStream outputFile) throws IOException
    {
        int value;
        int count;
        while (true)
        {
            value = inputFile.read();
            if (value == -1) break;
            count = inputFile.read();
            for (int i = 0; i < count; i++)
            {
                outputFile.write(value);
            }
        }
    }
}