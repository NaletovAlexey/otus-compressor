package org.programming.compressor;

import org.programming.compressor.algorithm.CompressRLE;
import org.programming.compressor.algorithm.ICompress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Naletov Alexey
 */
public class Main
{
    public static void main(String[] args)
    {
        // test compress/decompress algorithm
        System.out.println("Program to compress/decompress files!");
        String fileName = "D:\\alexey\\programs\\java\\algoritms\\programming\\compressor\\files_to_compress\\"
                + "demo_1.txt";
        ICompress alg = new CompressRLE();
        String fileZip = fileName + alg.getExtension();
        String fileUnzip = fileName + ".copy";
        try
        {
            compress(alg, fileName, fileZip);
            decompress(alg, fileZip, fileUnzip);
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void compress(ICompress alg, String fileName, String fileZip) throws IOException
    {
        System.out.println("Compress algorithm '%s'." + alg.getAlgorithm());
        long fileSize = new File(fileName).length();
        long startTime = System.currentTimeMillis();
        try (FileInputStream input = new FileInputStream(fileName);
                FileOutputStream output = new FileOutputStream(fileZip))
        {
            alg.compress(input, output);
        }
        long fileZipSize = new File(fileZip).length();
        long finishTime = System.currentTimeMillis();

        double elapsedTime = (finishTime - startTime);
        double compressRatio = (double) fileSize / fileZipSize * 100.0;
        System.out.println("Original size (B): " + fileSize);
        System.out.println("Compressed size (B): " + fileZipSize);
        System.out.printf("Compressed Ratio: %.2f%%%n", compressRatio);
        System.out.println("Total time (s): " + elapsedTime / 1000);
    }

    private static void decompress(ICompress alg, String fileName, String fileUnzip) throws IOException
    {
        System.out.println("Decompress algorithm '%s'" + alg.getAlgorithm());
        long startTime = System.currentTimeMillis();
        try (FileInputStream input = new FileInputStream(fileName);
        FileOutputStream output = new FileOutputStream(fileUnzip))
        {
            alg.decompress(input, output);
        }
        long finishTime = System.currentTimeMillis();
        double elapsedTime = (finishTime - startTime);
        System.out.println("Total time (s): " + elapsedTime / 1000);
    }

}