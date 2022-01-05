package Tian.bundlecalculator.first.utils;

import java.util.HashMap;
import java.util.Map;


public class Bundles {

    static Map<String, Map<Integer,Double>> kindMaps = new HashMap<>();
    static {
        kindMaps.put("IMG",new BundleKinds().getImgBundle());
        kindMaps.put("FLAC",new BundleKinds().getFlacBundle());
        kindMaps.put("VID",new BundleKinds().getVidBundle());
    }
    public Map<Integer,Double> getKinds(String kind){
        return kindMaps.get(kind);
    }

}
