package com.iquest.java.problem3.utility;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {

    // reads text from initial file and writes it in the new file with the
    // defined encoding
    public void convertFileContentToEncoding(String initialFileName, Charset newEncoding,  String newFileName)
            throws IOException {
        File initialFile = this.getFileWithNameFromResources(initialFileName);
        String initialFilePath = initialFile.getAbsolutePath();
        String parentFolderName = initialFile.getParent();

        Path pathToInitial = Paths.get(initialFilePath);
        // new file in the same folder
        Path pathToNew = Paths.get(parentFolderName + "\\" + newFileName);

        List<String> fileContent = Files.readAllLines(pathToInitial);
        Files.write(pathToNew, fileContent, newEncoding);
    }

    // returns a list containing all the characters from the utf8 file
    // that can not be converted into latin1
    public List<Character> getNonConvertibleCharacters(String utf8FileName)
            throws IOException {
        File utf8file = this.getFileWithNameFromResources(utf8FileName);
        String utf8filePath = utf8file.getAbsolutePath();

        Path path = Paths.get(utf8filePath);
        List<Character> result = new ArrayList<>();

        List<String> fileContent = Files.readAllLines(path);
        CharsetEncoder charsetEncoder = Charset.forName("ISO-8859-1").newEncoder();
        for (String text: fileContent) {
            for(char ch : text.toCharArray()) {
                if (! charsetEncoder.canEncode(ch)) {
                    result.add(ch);
                }
            }
        }
        return result;
    }

    public File getFileWithNameFromResources(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }
}
