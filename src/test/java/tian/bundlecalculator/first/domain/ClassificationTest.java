package tian.bundlecalculator.first.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tian.bundlecalculator.first.analyzer.Classification;

class ClassificationTest {

    @Test
    void evaluation() {
        Classification getClass = new Classification();
        Assertions.assertTrue(getClass.evaluation("IMG"));
        Assertions.assertTrue(getClass.evaluation("FLAC"));
        Assertions.assertTrue(getClass.evaluation("VID"));
    }

}