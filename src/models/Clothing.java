package models;

/**
 *
 * @author Giacomo
 */
public class Clothing extends Product{
    //The keyword "extends" allow to create an hiteritance between the superclass (Product) and this subclass (Clothing)
    //The subclass Clothing can now use the actribuses and methods of the superclass Person whitout writing them again.
    
    //**************************************************************************
    //attributes
    
    private String measurement;
    
    //**************************************************************************
    //getters
    
    public String getMeasurement()
    {
        return measurement;
    }
    
    //**************************************************************************
    //setters
    
    public void setMeasurement(String measurementIn)
    {
        measurement = measurementIn;
    }
    
    //**************************************************************************
    //Constructor 0 parameters
    //The subclass "clothing" must have a starting value for User attribuses
    public Clothing()
    {
        //keyword "super" allows to call the parameters from the superclass "Product" without writing them again.
        super();
        measurement = "";
    }
    
    //**************************************************************************
    //Constructor imput paramenters except "productId" (4 parameters)
    //it possible to create a constructtor joined to the constructor of the parent class without some of its paramenters only if 
    //there is a constructor, in the parent class, without the paramenters remuved.
    //the parameters must be declared the same order as declared in the Superclass "Product"
    
    public Clothing(String productNameIn, double priceIn, int StockLevelIn, String measurementIn)
    {
        super(productNameIn, priceIn, StockLevelIn);
        measurement = measurementIn;
    }
    
    //**************************************************************************
    //Constructor imput paramenters (5 parameters)
    //the parameters must be declared the same order as declared in the Superclass "Product"
    
    public Clothing(int productIdIn, String productNameIn, double priceIn, int StockLevelIn, String measurementIn)
    {
        super(productIdIn, productNameIn, priceIn, StockLevelIn);
        measurement = measurementIn;
    }
}
