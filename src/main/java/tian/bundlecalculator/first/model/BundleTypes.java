package tian.bundlecalculator.first.model;

import java.util.HashMap;
import java.util.Map;

public class BundleTypes {

    static final Map<Integer, Double> imgBundle = new HashMap<>();
    static final Map<Integer, Double> flacBundle = new HashMap<>();
    static final Map<Integer, Double> vidBundle = new HashMap<>();

    //  Initial the bundle size and price
    BundleTypes() {
        imgBundle.put(5, 450.0);
        imgBundle.put(10, 800.0);
        flacBundle.put(3, 427.50);
        flacBundle.put(6, 810.0);
        flacBundle.put(9, 1147.50);
        vidBundle.put(3, 570.0);
        vidBundle.put(5, 900.0);
        vidBundle.put(9, 1530.0);
    }

    public Map<Integer, Double> getImgBundle() {
        return imgBundle;
    }

    public Map<Integer, Double> getFlacBundle() {
        return flacBundle;
    }

    public Map<Integer, Double> getVidBundle() {
        return vidBundle;
    }
}
