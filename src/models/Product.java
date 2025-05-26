package models;

/**
 *
 * @author Giacomo
 */
public class Product {
    //Attributes
    //Are setted private attribuse to avoid that other classeds can have acces to them.
    private int productId;
    private String productName;
    private double price;
    private int stockLevel; 
    //**************************************************************************
    //This allow to change the product info displayed into the second listbox list "Products"
    //different from the reference number displayed as a default.
    @Override
    public String toString()
    {
        String display = "Product: " + productName + "\t  £" + price;
        return display; 
    }
    
    //**************************************************************************
    //Getters Methods  
    //are methods which the purpose to return the private attributes created in their typology. 
    
    public int getProductId()
    {
        return productId;
    }
    
    public String getProductName()
    {
        return productName;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public int getStockLevel()
    {
        return stockLevel;
    }
    
    //**************************************************************************
    //Setter Methods
    //They are void methods for each attribute which one imput parameter "public void setUserName(String usernameIn)"   
    //The value within the brackes is used to change the value of the attribute 
    //The imput parameter have to have a different name as to the attribute.    
    public void setProductId(int productIdIn)
    {
        productId = productIdIn;
    }
    
    public void setProductName(String productNameIn)
    {
        productName = productNameIn;
    }
    
    public void setPrice(double priceIn)
    {
        price = priceIn;
    }
    
    public void setStockLevel(int stockLevelIn)
    {
        stockLevel = stockLevelIn;
    }
    
    //**************************************************************************
    //Contructors (0 paramenters)
    //the constructor give a starting value to each attribute
    //constructor must have a starting value to avoid errors.    
    
    public Product()
    {
        productId = 0;
        productName = "";
        price = 0;
        stockLevel = 0;
    }
        
    //**************************************************************************
    //Constructor with impuct paramenters except "productId" (3 paramenters)
    // it is possible to create aothers constructors as well as they have different paramneters 
    public Product(String productNameIn, double priceIn, int StockLevelIn)
    {
        productId = 0;
        productName = productNameIn;
        price = priceIn;
        stockLevel = StockLevelIn;
    }
    
    //**************************************************************************
    //Constructor with imput paramenters for each attribute allowing to create an object whit values assigned to each attributes.    
    
    public Product(int productIdIn, String productNameIn, double priceIn, int StockLevelIn)
    {
        productId = productIdIn;
        productName = productNameIn;
        price = priceIn;
        stockLevel = StockLevelIn;
    }   
}




