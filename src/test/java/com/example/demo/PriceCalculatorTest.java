package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    @Test
    void getPrice() {
        Map<Integer,Integer> list=new HashMap<>();
        list.put(5,0);
        list.put(10,1);
        Map<Integer,Double> number=new HashMap<>();
        number.put(5,450.0);
        number.put(10,800.0);

        PriceCalculator cp=new PriceCalculator();
        Map<Integer,Double>res=cp.getPrice(list,number);

        Map<Integer,Double>expectRes=new HashMap<>();
        expectRes.put(5,0.0);
        expectRes.put(10,800.0);
        assertEquals(res.toString(),expectRes.toString());
    }

    @Test
    void getPriceCombination() {
        Map<Integer,Integer> list=new HashMap<>();
        list.put(3,0);
        list.put(6,1);
        list.put(9,1);
        Map<Integer,Double> number=new HashMap<>();
        number.put(3,427.5);
        number.put(6,810.0);
        number.put(9,1147.5);

        PriceCalculator cp=new PriceCalculator();
        Map<Integer,Double>res=cp.getPrice(list,number);

        Map<Integer,Double>expectRes=new HashMap<>();
        expectRes.put(3,0.0);
        expectRes.put(6,800.0);
        expectRes.put(9,1147.5);
        assertEquals(res.toString(),expectRes.toString());
    }
}