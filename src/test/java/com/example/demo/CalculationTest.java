package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {

    @Test
    void calculateBundlesIMG() throws Exception {
        Calculation cc=new Calculation();
        Map<Integer,Integer> res=new HashMap<>();
        res.put(5,0);
        res.put(10,1);
        String resDetails=res.toString();
        Map<Integer,Double> input =new HashMap<>();
        input.put(5,450.0);
        input.put(10,800.0);
        Map<Integer,Integer> resTest;
        resTest=cc.calculateBundles(10,input);
        assertEquals(resDetails,resTest.toString());
    }
    @Test
    void calculateBundlesVID() throws Exception {
        Calculation ccList=new Calculation();
        Map<Integer,Integer> res=new HashMap<>();
        res.put(3,1);
        res.put(5,2);
        res.put(9,0);
        String resDetails=res.toString();

        Map<Integer,Double>  input=new HashMap<>();
        input.put(3,570.0);
        input.put(5,900.0);
        input.put(9,1530.0);

        Map<Integer,Integer> resTest;
        resTest= ccList.calculateBundles(13,input);
        assertEquals(resDetails,resTest.toString());
    }
    @Test
    void calculateBundlesFLAC() throws Exception {
        Calculation ccList=new Calculation();
        Map<Integer,Integer> res=new HashMap<>();
        res.put(3,0);
        res.put(6,1);
        res.put(9,1);
        String resDetails=res.toString();

        Map<Integer,Double>  input=new HashMap<>();
        input.put(3,427.50);
        input.put(6,810.0);
        input.put(9,1147.5);

        Map<Integer,Integer> resTest;
        resTest= ccList.calculateBundles(15,input);
        assertEquals(resDetails,resTest.toString());
    }
}