package com.coderscampus.assignment7;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
    private static final int INITIAL_CAPACITY = 10;
    private static final int CAPACITY_MULTIPLIER = 2;
    private Object[] items;
    private int size;

    public CustomArrayList() {
        items = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(T item) {
        ensureCapacity(size + 1);
        items[size++] = item;
        return true;
    }

    @Override
    public boolean add(int index, T item) {
        validateIndexForAdditionalItem(index);
        ensureCapacity(size + 1);
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > items.length) {
            int newCapacity = items.length * CAPACITY_MULTIPLIER;
            items = Arrays.copyOf(items, newCapacity);
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        validateIndexForAccess(index);
        return (T) items[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) {
        validateIndexForAccess(index);
        T removedItem = (T) items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        items[--size] = null;
        return removedItem;
    }

    private void validateIndexForAccess(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void validateIndexForAdditionalItem(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
