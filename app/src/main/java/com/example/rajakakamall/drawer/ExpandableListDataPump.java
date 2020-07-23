package com.example.rajakakamall.drawer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> ledtv = new ArrayList<String>();
        ledtv.add("Sony");
        ledtv.add("Samsung");
        ledtv.add("Onida");
        ledtv.add("BPL");
        ledtv.add("Vu");

        List<String> refrigerators = new ArrayList<String>();
        refrigerators.add("Single Door");
        refrigerators.add("Double Door");
        refrigerators.add("Side By Side");
        refrigerators.add("French Door");
        refrigerators.add("Deep Freezers");

        List<String> washing_machine = new ArrayList<String>();
        washing_machine.add(" ");
        washing_machine.add("");
        washing_machine.add("");
        washing_machine.add("");
        washing_machine.add(" ");

        List<String> audio = new ArrayList<String>();

        List<String> air_conditioners = new ArrayList<String>();

        List<String> mobiles = new ArrayList<String>();

        List<String> beuty_products = new ArrayList<String>();

        List<String> accessories = new ArrayList<String>();

        List<String> kitchen_appliances = new ArrayList<String>();


        //List item titles
        expandableListDetail.put("LED TV", ledtv);
        expandableListDetail.put("Refrigerators", refrigerators);
        expandableListDetail.put("Washing Machine", washing_machine);
        expandableListDetail.put("Audio", audio);
        expandableListDetail.put("Air Conditioners", air_conditioners);
        expandableListDetail.put("Mobiles", mobiles);
        expandableListDetail.put("Beuty Products", beuty_products);
        expandableListDetail.put("Accessories", accessories);
        expandableListDetail.put("Kitchen Appliances", kitchen_appliances);


        return expandableListDetail;
    }

}
