package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassificationTest {

    @Test
    void evaluation() {
        Classification getClass=new Classification();
        assertTrue(getClass.evaluation("IMG"));
        assertTrue(getClass.evaluation("FLAC"));
        assertTrue(getClass.evaluation("VID"));
    }
}