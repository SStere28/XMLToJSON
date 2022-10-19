package com.crossvista.ordersProject;

import com.crossvista.ordersProject.Service.ObjectToJSONService;
import com.crossvista.ordersProject.Service.XMLtoObjectService;

public class App {
    public static void main(String[] args) {

        XMLtoObjectService xmLtoObjectService=new XMLtoObjectService();
        ObjectToJSONService objectToJSONService=new ObjectToJSONService();
        objectToJSONService.transform(xmLtoObjectService.transform());

    }
}
