package com.coderscampus.assignment7test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.coderscampus.assignment7.CustomArrayList;

class CustomArrayListTest {
    // sut = System under test
    private CustomArrayList<Object> sut;

    @BeforeEach
    void setUp() {
        sut = new CustomArrayList<>();
    }

    @Test
    void should_add_single_item_to_list() {
        assertTrue(sut.add(10));
        assertEquals(1, sut.getSize());
        assertEquals(10, sut.get(0));
    }

    @Test
    void should_add_multiple_items_to_list() {
        for (int i = 0; i < 15; i++) {
            sut.add(i);
        }
        assertEquals(15, sut.getSize());
        assertEquals(14, sut.get(14));
    }

    @Test
    void should_increase_internal_array_size() {
        for (int i = 0; i < 15; i++) {
            sut.add(i);
        }
        assertEquals(15, sut.getSize());

    }

    @Test
    public void testEnsureCapacity() {
        for (int i = 0; i < 11; i++) {
            sut.add(i, i);
        }
        assertEquals(11, sut.getSize());
        assertEquals(10, sut.get(10));
    }

    @Test
    void should_add_item_at_specific_index() {
        sut.add(10);
        sut.add(20);
        sut.add(1, 15);
        assertEquals(3, sut.getSize());
        assertEquals(10, sut.get(0));
        assertEquals(15, sut.get(1));
        assertEquals(20, sut.get(2));
    }

    @Test
    void should_throw_exception_for_invalid_index() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.add(5, 10));
    }

    @Test
    void should_shift_items_when_adding_in_middle_of_array_list() {
        sut.add(10);
        sut.add(20);
        sut.add(30);
        sut.add(1, 15);
        assertEquals(4, sut.getSize());
        assertEquals(10, sut.get(0));
        assertEquals(15, sut.get(1));
        assertEquals(20, sut.get(2));
        assertEquals(30, sut.get(3));
    }

    @Test
    void should_throw_exception_for_negative_index_when_adding() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.add(-1, 10));
    }

    @Test
    void should_return_correct_size() {
        assertEquals(0, sut.getSize());
        sut.add(10);
        assertEquals(1, sut.getSize());
    }

    @Test
    void should_return_and_remove_item() {
        sut.add(5);
        sut.add(10);
        sut.add(15);
        assertEquals(10, sut.remove(1));
        assertEquals(2, sut.getSize());
    }

    @Test
    void should_shift_items_when_removing_from_middle() {
        sut.add(1);
        sut.add(2);
        sut.add(3);
        assertEquals(3, sut.getSize());
        assertEquals(2, sut.remove(1));
        assertEquals(1, sut.get(0));
        assertEquals(3, sut.get(1));
        assertEquals(2, sut.getSize());
    }

    @Test
    void should_produce_correct_string_representation() {
        assertEquals("[]", sut.toString());
        sut.add(5);
        sut.add(10);
        sut.add(15);
        sut.add(20);
        assertEquals("[5, 10, 15, 20]", sut.toString());
    }

    // Edge Case Tests
    @Test
    void should_throw_exception_for_invalid_index_when_getting() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.get(1));
    }

    @Test
    void should_throw_exception_for_invalid_index_when_removing() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(0));
    }

    @Test
    void should_throw_exception_for_negative_index_when_removing() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(-1));
    }

    @Test
    void should_throw_exception_for_negative_index_when_getting() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.get(-1));
    }
}


