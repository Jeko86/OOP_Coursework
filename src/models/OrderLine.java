package models;

/**
 *
 * @author Giacomo
 */
public class OrderLine {
    //atributes
    private int orderLineId;
    private Product product;//the data type is the same as the Class 'Product' 
    private int quantity;
    private double lineTotal;
    
    //**************************************************************************
    //Getters Methods  
    //are methods which the purpose to return the private attributes created in their typology.
    
    public int getOrderLineId()
    {
        return orderLineId;
    }
    
    public Product getProduct()
    {
        return product;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public double getLineTotal()
    {
        return lineTotal;
    }
    
    //**************************************************************************
    //Setter Methods
    //They are void methods for each attribute which one imput parameter "public void setUserName(String usernameIn)"   
    //The value within the brackes is used to change the value of the attribute 
    //The imput parameter have to have a different name as to the attribute.  
    
    public void setOrderLineId(int OrderLineIdIn)
    {
        orderLineId = OrderLineIdIn;
    }
    
    public void setProduct(Product productIn)
    {
        product = productIn;
    }
    
    public void setQuantity(int quantityIn)
    {
        quantity = quantityIn;
    }
    
    public void setLineTotal(double lineTotalIn)
    {
        lineTotal = lineTotalIn;
    }
    
     //**************************************************************************
    //Constructor with all parameters
    public OrderLine(int OrderLineIdIn, Product productIn, int quantityIn, double lineTotalIn)
    {
        orderLineId = OrderLineIdIn;
        product = productIn;
        quantity = quantityIn;
        lineTotal = lineTotalIn;
    }
    
    //**************************************************************************
    //Constructor with all parameters except lineTotal
    public OrderLine(int OrderLineIdIn, Product productIn, int quantityIn)
    {
        orderLineId = OrderLineIdIn;
        product = productIn;
        quantity = quantityIn;
        lineTotal = product.getPrice()*quantity;
        //the price will come from the class 'Product' and it is used to calculate the total sum of the products' price
        //it is possible then moltiply the price for the quantyti to find the total.       
    }
}
