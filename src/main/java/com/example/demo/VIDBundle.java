package com.example.demo;

//import jdk.dynalink.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VIDBundle implements Operation {
    static final Map<Integer,Double> bundleKinds=new HashMap<>();
    VIDBundle(){
        bundleKinds.put(3,570.0);
        bundleKinds.put(5,900.0);
        bundleKinds.put(9,1530.0);
    }
    @Override
    public Map<Integer,Double>  applyBundles(){
        return bundleKinds;
    }
}
