package org.iti.mobile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayListMockedTests {
    private ArrayList<String> list;

    @BeforeEach
    void setUP(){
        list = mock(ArrayList.class);
    }

    @Test
    void testArrayListSize(){
        when(list.size()).thenReturn(23);
        assertEquals(23,list.size());
    }

    @Test
    void testArrayListIsNotEmpty() {
        when(list.isEmpty()).thenReturn(false);
        assertFalse(list.isEmpty());
    }




}
