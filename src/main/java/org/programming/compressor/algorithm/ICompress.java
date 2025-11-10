package org.programming.compressor.algorithm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Common interface for all compressors
 * @author Naletov Alexey
 */
public interface ICompress
{
    String getAlgorithm();
    String getExtension();

    void compress(InputStream inputFile, OutputStream outputFile) throws IOException;
    void decompress(InputStream inputFile, OutputStream outputFile) throws IOException;

    default void prepare(InputStream inputFile)  throws IOException
    {}
}
