package com.crossvista.ordersProject.Service;

import com.crossvista.ordersProject.domain.PurchaseOrder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class ObjectToJSONService {

    public void transform(PurchaseOrder purchaseOrder) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(purchaseOrder);

        try {
            FileWriter file = new FileWriter("output/PurchaseOrders.json");
            file.write(json);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
