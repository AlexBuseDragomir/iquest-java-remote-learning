package com.iquest.java.problem1.list;

import com.iquest.java.problem1.exception.IllegalAddedValueException;
import com.iquest.java.problem1.exception.IllegalValueFormatException;
import com.iquest.java.problem1.exception.InvalidListIndexException;
import com.iquest.java.problem1.utility.ArrayUtility;
import com.iquest.java.problem1.utility.StringUtility;

import java.util.ArrayList;

public class StringList implements List<String> {

    private int[] values;
    private int size;
    private java.util.List<String> operations;

    public StringList() {
        this.size = 0;
        this.values = new int[this.size];
        this.operations = new ArrayList<>();
    }

    @Override
    public void add(String element)
            throws IllegalAddedValueException, IllegalValueFormatException {
        this.operations.add("add(" + element + ")");
        if (element == null) {
            throw new IllegalAddedValueException("Invalid value (null or empty)");
        } else if (element.equals("")) {
            throw new IllegalAddedValueException("Invalid value (null or empty)");
        } else if (StringUtility.isStringIntegerNumber(element)) {
            int[] newValues = ArrayUtility.getArrayCopyWithIncreasedSize(this.values, 1);
            newValues[newValues.length - 1] = Integer.parseInt(element);
            this.size ++;
            this.values = newValues;
        } else {
            throw new IllegalValueFormatException("The string must be represented " +
                    "as an integer value");
        }
    }

    @Override
    public String get(int position) throws InvalidListIndexException {
        this.operations.add("get(" + position + ")");
        if (position < this.values.length && position >= 0) {
            return ((Integer)this.values[position]).toString();
        } else {
            throw new InvalidListIndexException("The position is invalid");
        }
    }

    @Override
    public boolean contains(String element) {
        this.operations.add("contains(" + element + ")");
        if (element.equals("")) {
            throw new IllegalValueFormatException("The string must be represented " +
                    "as an integer value");
        } else if (StringUtility.isStringIntegerNumber(element)) {
            for (int value: this.values) {
                if (Integer.parseInt(element) == value) {
                    return true;
                }
            }
        } else {
            throw new IllegalValueFormatException("The string must be represented " +
                    "as an integer value");
        }
        return false;
    }

    @Override
    public boolean containsAll(List<String> foreignList) {
        this.operations.add("containsAll(" + foreignList.getClass().getSimpleName() + ")");
        for (int i = 0; i < foreignList.size(); i ++) {
            if ( ! this.contains(foreignList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        this.operations.add("size()");
        return this.size;
    }

    public java.util.List<String> logOperations() {
        this.operations.add("logOperations()");
        return this.operations;
    }
}
