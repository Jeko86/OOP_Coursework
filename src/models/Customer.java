package models;


import java.util.HashMap;

/**
 *
 * @author Giacomo
 */

public class Customer extends User{ 
    
    //The keyword "extends" allow to create an hiteritance between the superclass (User) and this subclass (Customer)
    //The subclass Customer can now use the actribuses and methods of the superclass Person whitout writing them again.
    
    //**************************************************************************
    
    //Attributes
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    private boolean isRegistered;
    private HashMap<Integer, Order> orders;
    
    //*****************************************************************************   
    //this method will display a greeting message from a string using Html for formatting the text from the string 
    public String displayGreeting()
    {
        String greeting = "<html>Welcome " + getFirstName()+ "!<br>" 
                +" Enjoy Shopping</html>";
        return greeting;
    }   
    //**************************************************************************    
    //Getters
    public String getAddressLine1()
    {
        return addressLine1;
    }
    
    public String getAddressLine2()
    {
        return addressLine2;
    }
    
    public String getTown()
    {
        return town;
    }
    
    public String getPostcode()
    {
        return postcode;
    }
    
    public boolean getIsRegistered()
    {
        return isRegistered;
    }
    
    //hashMap getter
    
    public HashMap<Integer, Order>getOrders()
    {
        return orders;
    }
    
    //**************************************************************************
    //Setter
    
    public void setAddressLine1(String addressLine1In)
    {
        addressLine1 = addressLine1In;
    }
    
    public void setAddressLine2(String addressLine2In)
    {
        addressLine2 = addressLine2In;
    }
    
    public void setTown(String townIn)
    {
        town = townIn;
    }
    
    public void setPostcode(String postcodeIn)
    {
        postcode = postcodeIn;
    }
    
    public void setIsRegistered(boolean isRegisteredIn)
    {
        isRegistered = isRegisteredIn;
    }    
    //hashMap setter
    public void setOrders(HashMap<Integer, Order>OrdersIn)
    {
        orders = OrdersIn;
    }
    
    //**************************************************************************   
    //Constructor0 parameters
    //The subclass "Customer" must have a starting value for User attribuses 
    public Customer()
    {
        super(); //keyword "super" allows to call the parameters from the superclass "User" without writing them again.
        addressLine1 = "";
        addressLine2 = "";
        town = "";
        postcode = "";
        isRegistered = true;
        orders = new HashMap();
    }
    
    //**************************************************************************
    //Constructor imput parameters Except "isRegistered" (8 paramenters)
    //the parameters must be declared the same order as declared in the Superclass "User"
    
    public Customer(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn, 
            String addressLine1In, String addressLine2In, String townIn, String postcodeIn)
    {
        //methods called from the superclass "User" are written without datatype.
        super(usernameIn, passwordIn, firstNameIn, lastNameIn);
        addressLine1 = addressLine1In;
        addressLine2 = addressLine2In;
        town = townIn;
        postcode = postcodeIn; 
        isRegistered = true;
        orders = new HashMap();
    }
 
}
