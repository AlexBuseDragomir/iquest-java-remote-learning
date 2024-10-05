package utility;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FileUtilityTest {

    private FileUtility fileUtility;

    private static final String ROOT_FILE_NAME = "parent";
    private static final String[] directoryNames =
            {"child1", "child2", "child3", "child4", "child5", "child6"};

    @Before
    public void setUp() {
        this.fileUtility = new FileUtility();
    }

    @Test
    public void testGetSubdirectoriesUsingLambda() {
        File[] directories = fileUtility.getSubdirectories1(ROOT_FILE_NAME);

        assertThat(directories.length, is(directoryNames.length));

        for (int i = 0; i < directories.length; i++) {
            assertThat(directories[i].getName(), is(directoryNames[i]));
        }
    }

    @Test
    public void testGetSubdirectoriesUsingFunctionReference() {
        File[] directories = fileUtility.getSubdirectories2(ROOT_FILE_NAME);

        assertThat(directories.length, is(directoryNames.length));

        for (int i = 0; i < directories.length; i++) {
            assertThat(directories[i].getName(), is(directoryNames[i]));
        }
    }
}