package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Classification {
    Map<String, Boolean> classification = new HashMap<>();

    Classification() {
        classification.put("IMG", true);
        classification.put("FLAC", true);
        classification.put("VID", true);
    }

    public boolean evaluation(String kind) {
        return classification.get(kind);
    }
}
