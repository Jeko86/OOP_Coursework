package models;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giacomo
 */
public class Order {
    //attributes
    private int orderId;
    private Date orderDate;
    private double orderTotal;
    private String status;
    private HashMap<Integer, OrderLine> orderLines;
    //we will join this class to class OrderLine and make a collection of orderLines by
    //setting a HashMap. 
    //HASHMAPS allows to specify the key and the value of each entry in the collection
    //and it is possible to choose the name of the key (differently from an Array)and the way of indexing of the collection.
    
    //**************************************************************************
    //this method will loops through the orderLines and adds all the individual lineTotals 
    public void calculateOrdertotal()
    {
        //empty order total
        orderTotal = 0;
        
        //loop through the HasMap of orderLines 
        for (Map.Entry<Integer, OrderLine> olEntry : orderLines.entrySet()) 
        {
            OrderLine actualOrderLine = olEntry.getValue(); 
            //increase the order total by each orderLine total
            orderTotal = orderTotal + actualOrderLine.getLineTotal();
        }
    }
    
    //**************************************************************************
    
    //order to remove te orderline using ID
    public void removeOrderLine(int productId)
    {
        int orderLineId = -1;
        for (Map.Entry<Integer, OrderLine> olEntry : orderLines.entrySet()) 
        {
            //get the Id which will be removed
            OrderLine actualOrderLine = olEntry.getValue();
            
            if (actualOrderLine.getProduct().getProductId() == productId) 
            {
                orderLineId = actualOrderLine.getOrderLineId();
            }
        }
        //to check if objet is selected
        if (orderLineId != -1) 
        {
            orderLines.remove(orderLineId);
        }
    }  
    //**************************************************************************
    
    //the method will add an order line to the orderLine's ashMap "orderLines"
    public boolean addOrderLine(OrderLine ol)
    {
        //********
        //lines code to avoid clone of the same object in into the basket table
        boolean canBeAdded = true;
        //the loop code allow to avoid clone of the same object in into the basket table
        //comparing the the object ID from the imput  with the orderLines hashMap 
        for(Map.Entry<Integer, OrderLine> olEntry : orderLines.entrySet())
        {
            OrderLine actualOrderLine = olEntry.getValue();
            
            //if the  object ID from the imput  is the same as object Id already contained in the orderLines hashMap
            //it will not be inserted other lines (canBeAdded = false;)
            //oterwise a new object will be added
            if (ol.getProduct().getProductId()== actualOrderLine.getProduct().getProductId()) 
            {
                canBeAdded = false; 
            }
        }        
        if (canBeAdded == false) 
        {
            return false;
        }
        else
        {
            int orderLineId = 0;
            //through the while loop the Id will be increase from 0 to the unique Id number of the order line selected
            while(orderLines.containsKey(orderLineId))//containsKey  garantees the orderLineId remain unique
            {
                orderLineId++;
            }

            ol.setOrderLineId(orderLineId);

            orderLines.put(orderLineId, ol);//sets the id number of the object selected adding it to the OrderLines hashmap

            return true;
        }        
    }
    
    //**************************************************************************
    //Getters Methods  
    //are methods which the purpose to return the private attributes created in their typology. 
    public int getOrderId()
    {
        return orderId;
    }
    
    public Date getOrderDate()
    {
        return orderDate;
    }
    
    public double getOrderTotal()
    {
        return orderTotal;
    }
    
    public String getStatus()
    {
        return status;
    }
    //hashmap getter
    public HashMap<Integer, OrderLine> getOrderLines()
    {
        return orderLines;
    }
    
    //**************************************************************************
    //Setter Methods
    //They are void methods for each attribute which one imput parameter "public void setUserName(String usernameIn)"   
    //The value within the brackes is used to change the value of the attribute 
    //The imput parameter have to have a different name as to the attribute.
    
    public void setOrderId(int orderIdIn)
    {
        orderId = orderIdIn;
    }
    
     public void setOrderDate (Date orderDateIn)
    {
        orderDate = orderDateIn;
    }
     
    public void setOrderTotal(double orderTotalIn)
    {
        orderTotal = orderTotalIn;
    }
    
     public void setStatus(String statusIn)
    {
        status = statusIn;
    }
     
    public void setOrderLines(HashMap<Integer, OrderLine>orderLinesIn)
    {
        orderLines = orderLinesIn;
    }
    
    //**************************************************************************
    //Contructors (0 paramenters)
    //the constructor give a starting value to each attribute
    //constructor must have a starting value to avoid errors.    
    public Order()
    {
        orderId = 0;
        orderDate = new Date();
        orderTotal = 0;
        status = "in Progress";
        orderLines = new HashMap();
    }
    
    //**************************************************************************
    //Constructor with all parameters except orderLines
    public Order(int orderIdIn, Date orderDateIn, double orderTotalIn, String statusIn)
    {
        orderId = orderIdIn;
        orderDate = orderDateIn;
        orderTotal = orderTotalIn;
        status = statusIn;
        orderLines = new HashMap();
    }
   			
    
}
