package tian.bundlecalculator.first.analyzer;

import java.util.HashMap;
import java.util.Map;

public class Classification {
    Map<String, Boolean> classification = new HashMap<>();

    public Classification() {
        classification.put("IMG", true);
        classification.put("FLAC", true);
        classification.put("VID", true);
    }

    public boolean evaluation(String category) {
        return classification.get(category);
    }
}
