package com.example.demo.bundles;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Bundles {
    static Map<String, Operation> kindMap = new HashMap<>();

    static {
        kindMap.put("IMG", new IMGBundle());
        kindMap.put("FLAC", new FLACBundle());
        kindMap.put("VID", new VIDBundle());
    }

    public static Optional<Operation> getKind(String operator) {
        return Optional.ofNullable(kindMap.get(operator));
    }

}
