package com.example.demo;
import java.math.BigDecimal;
import java.util.*;

//import com.google.common.collect.ImmutableMap;
//import jdk.dynalink.Operation;

import java.util.Map;

public class Bundles {
    static Map<String, Operation> kindMap = new HashMap<>();
    static {
        kindMap.put("IMG",new IMGBundle());
        kindMap.put("FLAC", new FLACBundle());
        kindMap.put("VID", new VIDBundle());
    }

    public static Optional<Operation> getKind(String operator) {
        return Optional.ofNullable(kindMap.get(operator));
    }

}
