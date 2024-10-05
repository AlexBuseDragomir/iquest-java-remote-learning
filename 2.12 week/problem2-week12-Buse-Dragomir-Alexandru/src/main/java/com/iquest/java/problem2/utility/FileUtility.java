package com.iquest.java.problem2.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtility {

    private static final int BUFFER_SIZE_IN_BYTES = 1024;

    public void compressFileFromResources(String fileName, String archiveName)
            throws IOException {

        File fileToCompress = this.getFileWithNameFromResources(fileName);
        // creating an input stream for the file that will be zipped
        FileInputStream fileInputStream = new FileInputStream(fileToCompress.getAbsolutePath());

        // creating an output stream for the archive
        String pathToArchive = fileToCompress.getParentFile().getAbsolutePath() + "\\" + archiveName;
        FileOutputStream fileOutputStream = new FileOutputStream(pathToArchive);

        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

        // creating a new entry to introduce in the archive
        // keep the initial file name
        // done for each file we want to include
        zipOutputStream.putNextEntry(new ZipEntry(fileName));

        // data that will be copied in the archive
        byte[] data = new byte[BUFFER_SIZE_IN_BYTES];
        int dataLength;

        // while there is data, keep writing using output stream
        while ((dataLength = fileInputStream.read(data)) >= 0) {
            zipOutputStream.write(data, 0, dataLength);
        }

        // close streams
        zipOutputStream.finish();
        zipOutputStream.flush();
        zipOutputStream.closeEntry();

        fileInputStream.close();

        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public double getCompressionRatio(File initialFile, File compressedFile) {
        return (initialFile.length() * 1.0) / compressedFile.length();
    }

    public File getFileWithNameFromResources(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }
}
