package com.crossvista.ordersProject.Service;

import com.crossvista.ordersProject.domain.Adress;
import com.crossvista.ordersProject.domain.Item;
import com.crossvista.ordersProject.domain.PurchaseOrder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class XMLtoObjectService {

    public PurchaseOrder transform() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        try {
            File file = new File("input/PurchaseOrders.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            createOrder(purchaseOrder, doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return purchaseOrder;
    }

    private void createOrder(PurchaseOrder purchaseOrder, Document doc) throws ParseException {
        purchaseOrder.setOrderNumber(Long.parseLong(doc.getElementsByTagName("PurchaseOrder").item(0)
                .getAttributes().getNamedItem("PurchaseOrderNumber").getTextContent()));
        purchaseOrder.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse(doc.getElementsByTagName("PurchaseOrder").item(0)
                .getAttributes().getNamedItem("OrderDate").getTextContent()));
        setAdresses(purchaseOrder, doc.getElementsByTagName("Address"));
        purchaseOrder.setDeliveryNotes(doc.getElementsByTagName("DeliveryNotes").item(0).getTextContent());
        purchaseOrder.setItems(setItems(doc.getElementsByTagName("Item")));
    }

    private void setAdresses(PurchaseOrder purchaseOrder, NodeList nodeList) {
        if (nodeList.item(0).getAttributes().getNamedItem("Type").getTextContent().equals("Shipping")) {
            purchaseOrder.setShippingAdress(getAdress(nodeList.item(0)));
        }
        if (nodeList.item(1).getAttributes().getNamedItem("Type").getTextContent().equals("Billing")) {
            purchaseOrder.setBillingAdress(getAdress(nodeList.item(1)));
        }

    }

    private Adress getAdress(Node node) {
        Adress adress = new Adress();
        adress.setType(node.getAttributes().getNamedItem("Type").getTextContent());

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) node;
            adress.setName(eElement.getElementsByTagName("Name").item(0).getTextContent());
            adress.setStreet(eElement.getElementsByTagName("Street").item(0).getTextContent());
            adress.setCity(eElement.getElementsByTagName("City").item(0).getTextContent());
            adress.setState(eElement.getElementsByTagName("State").item(0).getTextContent());
            adress.setZip(Long.parseLong(eElement.getElementsByTagName("Zip").item(0).getTextContent()));
            adress.setCountry(eElement.getElementsByTagName("Country").item(0).getTextContent());
        }
        return adress;
    }

    private List<Item> setItems(NodeList nodeList) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            items.add(getItem(nodeList.item(i)));
        }
        return items;
    }

    private Item getItem(Node node) {
        Item item = new Item();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) node;

            item.setPartNumber(eElement.getAttributes().getNamedItem("PartNumber").getTextContent());
            item.setProductName(eElement.getElementsByTagName("ProductName").item(0).getTextContent());
            item.setQuantity(Integer.parseInt(eElement.getElementsByTagName("Quantity").item(0).getTextContent()));
            item.setPrice(Double.parseDouble(eElement.getElementsByTagName("USPrice").item(0).getTextContent()));
            checkIfHasCommentOrShipDate(item, eElement);
            return item;
        }
        return item;
    }

    private void checkIfHasCommentOrShipDate(Item item, Element eElement) {
        if (eElement.getElementsByTagName("Comment").item(0) != null) {
            item.setComment(eElement.getElementsByTagName("Comment").item(0).getTextContent());
        } else if (eElement.getElementsByTagName("ShipDate").item(0) != null) {
            try {
                item.setShipDate(new SimpleDateFormat("yyyy-MM-dd").parse(
                        eElement.getElementsByTagName("ShipDate").item(0).getTextContent()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
