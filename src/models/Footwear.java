package models;

/**
 *
 * @author Giacomo
 */
public class Footwear extends Product{
    //The keyword "extends" allow to create an hiteritance between the superclass (Product) and this subclass (Clothing)
    //The subclass Footwear can now use the actribuses and methods of the superclass Person whitout writing them again.
    
    //**************************************************************************
    //attributes
    
    private int size;
    
    //**************************************************************************
    //getter
    
    public int getSize()
    {
        return size;
    }
    
    //**************************************************************************
    //setter
    
    public void setSize(int sizeIn)
    {
        size = sizeIn;
    }
    
    //**************************************************************************
    //constructor 0 paramenters
    
    public Footwear()
    {
        super();//keyword "super" allows to call the parameters from the superclass "User" without writing them again.
        size = 0;
    }
    
    //**************************************************************************
    //Constructor imput parameters except "ProductId" paramenter (4 Paramenters)
    //it possible to create a constructtor joined to the constructor of the parent class without some of its paramenters only if 
    //there is a constructor, in the parent class, without the paramenters remuved.
    //the parameters must be declared the same order as declared in the Superclass "Product"
    
    public Footwear(String productNameIn, double priceIn, int StockLevelIn, int sizeIn)
    {
        super(productNameIn, priceIn, StockLevelIn);
        size = sizeIn;       
    }
    
    //**************************************************************************
    //Constructor imput parameters (5 Paramenters)
    //the parameters must be declared the same order as declared in the Superclass "Product"
    
    public Footwear(int productIdIn, String productNameIn, double priceIn, int StockLevelIn, int sizeIn)
    {
        super(productIdIn, productNameIn, priceIn, StockLevelIn);
        size = sizeIn;       
    }    
}
