package com.coderscampus.assignment7;

public class CustomListApplication {

    public static void main(String[] args) {
        CustomList<Integer> myCustomList = new CustomArrayList<>();

        addItemsToList(myCustomList);
        displayListInfo(myCustomList);
        testAddAtSpecificIndex(myCustomList);
        testRemoveFunction(myCustomList);
    }

    public static void addItemsToList(CustomList<Integer> list) {
        for (int i = 1; i <= 40; i++) {
            list.add(i);
        }
        System.out.println("List: " + list);
        System.out.println("Added items from 1 to 40.");
    }

    private static void displayListInfo(CustomList<Integer> list) {
        System.out.println("--------");
        System.out.println("Size of list: " + list.getSize());
        System.out.println("First item: " + list.get(0));
        System.out.println("--------");

        for (int i = 0; i < list.getSize(); i++) {
            System.out.println("Item at index " + i + ": " + list.get(i));
        }
    }

    private static void testAddAtSpecificIndex(CustomList<Integer> list) {
        System.out.println("--------");
        list.add(40, 42);
        System.out.println("Added 42 at index 40.");
        list.add(41);
        System.out.println("Added 41 to end of list.");
        System.out.println("Size of list: " + list.getSize() + " | " + " LIST: " + list);
    }

    private static void testRemoveFunction(CustomList<Integer> list) {
        System.out.println("--------");
        System.out.println("Removed item at index 5: " + list.remove(5));
        System.out.println("Updated size: " + list.getSize() + " | " + " LIST: " + list);
    }
}

