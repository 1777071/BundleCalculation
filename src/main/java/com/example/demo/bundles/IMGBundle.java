package com.example.demo.bundles;

//import jdk.dynalink.Operation;

import java.util.HashMap;
import java.util.Map;

public class IMGBundle implements Operation {
    static final Map<Integer, Double> bundleKinds = new HashMap<>();

    IMGBundle() {
        bundleKinds.put(5, 450.0);
        bundleKinds.put(10, 800.0);
    }

    @Override
    public Map<Integer, Double> applyBundles() {
        return bundleKinds;
    }
}
