package com.iquest.java.problem3.main;

import com.iquest.java.problem3.utility.FileUtility;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class MainLauncher {

    public static void main(String[] args) {

        Charset ISO_LATIN_1 = Charset.forName("ISO-8859-1");
        Charset UTF_8 = Charset.forName("UTF-8");

        FileUtility fileUtility = new FileUtility();

        try {
            fileUtility.convertFileContentToEncoding("test1_latin1_input.txt",
                    UTF_8, "test1_utf8_output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // java.nio.charset.UnmappableCharacterException
        // when trying to change the endoding from UTF-8 to Latin1
        /*fileUtility.convertFileContentToEncoding("test2_utf8_input.txt", ISO_LATIN_1,
                "test2_latin1_output.txt");*/

        try {
            List<Character> nonConvertibleCharacters =
                    fileUtility.getNonConvertibleCharacters("test2_utf8_input.txt");

            System.out.println("Characters that could not be mapped from UTF8 to Latin1: ");
            System.out.println(nonConvertibleCharacters);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
