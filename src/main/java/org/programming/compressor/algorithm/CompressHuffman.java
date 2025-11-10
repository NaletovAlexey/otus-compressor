/*
CompressHuffman.java

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
public class CompressHuffman implements ICompress
{
    @Override
    public String getAlgorithm()
    {
        return "Huffman";
    }

    @Override
    public String getExtension()
    {
        return ".hfm";
    }

    @Override
    public void compress(InputStream inputFile, OutputStream outputFile) throws IOException
    {

    }

    @Override
    public void decompress(InputStream inputFile, OutputStream outputFile) throws IOException
    {

    }
}