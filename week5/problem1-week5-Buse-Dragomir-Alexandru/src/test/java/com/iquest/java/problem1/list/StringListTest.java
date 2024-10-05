package com.iquest.java.problem1.list;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import com.iquest.java.problem1.exception.IllegalAddedValueException;
import com.iquest.java.problem1.exception.IllegalValueFormatException;
import com.iquest.java.problem1.exception.InvalidListIndexException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringListTest {

    private List<String> list;
    private String[] initData = {"12", "23", "34", "45"};

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        this.list = new StringList();
    }

    @Test
    public void testAddValuesToTheList() {
        initData();
        assertEquals(initData.length, list.size());
        for (String data : initData) {
            assertTrue(list.contains(data));
        }
    }

    private void initData() {
        for (String numberAsString : initData) {
            list.add(numberAsString);
        }
    }

    @Test
    public void testAddNonIntegerValue() {
        exception.expect(IllegalValueFormatException.class);
        exception.expectMessage("The string must be represented " +
                "as an integer value");
        list.add("Hey, I'm not an integer.");
    }

    @Test
    public void testAddNonNullValue() {
        exception.expect(IllegalAddedValueException.class);
        exception.expectMessage("Invalid value (null or empty)");
        list.add(null);
    }

    @Test
    public void testIndexOutOfBounds() {
        initData();
        exception.expect(InvalidListIndexException.class);
        exception.expectMessage("The position is invalid");
        list.get(initData.length);
    }
}