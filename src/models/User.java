package models;

/**
 *
 * @author Giacomo
 */
public class User {
    
    //Attributes
    //Are setted private attribuse to avoid that other classeds can have acces to them.
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    //**************************************************************************
    //Getters Methods  
    //are methods which the purpose to return the private attributes created in their typology.    
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    //**************************************************************************
    //Setter Methods
    //They are void methods for each attribute which one imput parameter "public void setUserName(String usernameIn)"   
    //The value within the brackes is used to change the value of the attribute 
    //The imput parameter have to have a different name as to the attribute.    
    public void setUsername(String usernameIn)
    {
        username = usernameIn;
    }
    
    public void setPassword(String passwordIn)
    {
        password = passwordIn;
    }
    
    public void setFirstName(String firstNameIn)
    {
        firstName = firstNameIn;
    }
    
    public void setLastName(String lastNameIn)
    {
        lastName = lastNameIn;
    }
    
    //**************************************************************************
    //Contructors (0 paramenters)
    //the constructor give a starting value to each attribute
    //constructor have to have a starting value to avoid errors.    
    public User()
    {
        username = "";
        password = "";
        firstName = "";
        lastName = "";
    }
    
    //**************************************************************************
    //Constructor with imput paramenters for each attribute allowing to create an object whit values assigned to each attributes.
    public User(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn)
    {
        username = usernameIn;
        password = passwordIn;
        firstName = firstNameIn;
        lastName = lastNameIn;
    }   
}
