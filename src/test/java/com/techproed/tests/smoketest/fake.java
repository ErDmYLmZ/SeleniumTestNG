package com.techproed.tests.smoketest;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class fake {

    public static void main(String[] args) {
        List<Integer> rannum = new ArrayList<>();
        Faker faker = new Faker();
        HashMap<Integer, String> UsMatch = new HashMap<>();
        List<String>nameList = new ArrayList<>();
                nameList.add("Ali");
                nameList.add("Ayse");
                nameList.add("Aykut");
                nameList.add("Emir");
                nameList.add("Enes");
                nameList.add("Erdem");
                nameList.add("Ibrahim");
                nameList.add("Mehmet");
                nameList.add("Nazmi");
                nameList.add("Nur");
                nameList.add("Zafer");


        for(int j=1;j<=11;j++){
        for (int i = 0; i < 12; i++) {
            int num = faker.number().numberBetween(1, 12);
            if (!rannum.contains(num)) {
                rannum.add(num);
            }
        }
        }
        System.out.println(rannum);
        System.out.println(nameList);




    }



    }



