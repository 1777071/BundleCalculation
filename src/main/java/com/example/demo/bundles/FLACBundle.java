package com.example.demo.bundles;

//import jdk.dynalink.Operation;

import java.util.HashMap;
import java.util.Map;

public class FLACBundle implements Operation {
    static final Map<Integer, Double> bundleKinds = new HashMap<>();

    FLACBundle() {
        bundleKinds.put(3, 427.50);
        bundleKinds.put(6, 810.0);
        bundleKinds.put(9, 1147.50);
    }

    @Override
    public Map<Integer, Double> applyBundles() {
        return bundleKinds;
    }
}
