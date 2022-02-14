package main.java.Lesson_2.Exercise_two;

public class CustomStringArrayList implements CustomArrayList{

    private int size;
    private int capacity;
    private String[] elements;
    private String[] newElements;

    public CustomStringArrayList() {
        capacity = 10;
        size = 0;
        elements = new String[capacity];
    }

    @Override
    public void add(String element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    @Override
    public void grow() {
        int numbers = (int) Math.floor(capacity * 1.5);
        newElements = new String[numbers];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
        capacity = numbers;
    }
}
