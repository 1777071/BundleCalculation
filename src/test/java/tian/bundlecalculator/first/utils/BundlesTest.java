package Tian.bundlecalculator.first.utils;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BundlesTest {

    @Test
    void getKind() {
        Map<Integer,Double> res=new HashMap<>();
        res.put(5,450.0);
        res.put(10,800.0);
        String resDetails=res.toString();
        Bundles bb=new Bundles();
        Map<Integer,Double> realRes=bb.getKinds("IMG");
        assertEquals(resDetails,realRes.toString());
    }
}