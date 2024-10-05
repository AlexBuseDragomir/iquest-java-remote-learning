package utility;

import java.io.File;

public class FileUtility {

    // using a lambda
    public File[] getSubdirectories1(String rootFileName) {
        File rootFile = this.getFileWithNameFromResources(rootFileName);
        return rootFile.listFiles(file -> file.isDirectory());
    }

    // using function reference
    public File[] getSubdirectories2(String rootFileName) {
        File rootFile = this.getFileWithNameFromResources(rootFileName);
        return rootFile.listFiles(File::isDirectory);
    }

    public void listFileNames(File[] files) {
        for (File file: files) {
            System.out.println(file.getName());
        }
    }

    private File getFileWithNameFromResources(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }
}
