package tian.bundlecalculator.first.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BundlesTest {

    @Test
    void getCategories() {
        Map<Integer, Double> res = new HashMap<>();
        res.put(5, 450.0);
        res.put(10, 800.0);
        String resDetails = res.toString();
        Bundles bb = new Bundles();
        Map<Integer, Double> realRes = bb.getCategories("IMG");
        assertEquals(resDetails, realRes.toString());
    }
}