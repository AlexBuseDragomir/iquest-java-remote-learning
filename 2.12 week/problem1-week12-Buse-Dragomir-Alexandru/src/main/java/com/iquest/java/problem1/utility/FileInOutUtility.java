package com.iquest.java.problem1.utility;

import java.io.*;

public class FileInOutUtility {

    private static final int INT_SIZE_IN_BYTES = 4;

    public void writeIntegerToFileInPosition(File file, int position, int value)
            throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        // integers are on 4 bytes (32 bits)
        // position represents the offset of the pointer in bytes
        randomAccessFile.seek(INT_SIZE_IN_BYTES * position);
        randomAccessFile.writeInt(value);
        randomAccessFile.close();
    }

    public int readIntegerFromPositionInFile(File file, int position)
            throws IOException{
        int integerValue = 0;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        // integers are on 4 bytes (32 bits)
        // position represents the offset of the pointer in bytes
        randomAccessFile.seek(INT_SIZE_IN_BYTES * position);
        integerValue = randomAccessFile.readInt();
        randomAccessFile.close();
        return integerValue;
    }

    public void clearFileContent(File file)
            throws IOException {
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.close();
    }

    public File getFileWithNameFromResources(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }
}
