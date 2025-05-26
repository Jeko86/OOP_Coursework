package models;

/**
 *
 * @author Giacomo
 */
public class Staff extends User{
    
    //The keyword "extends" allow to create an hiteritance beitween the superclass (User) and this subclass (Staff)
    //The subclass Staff can now use the actribuses and methods of the superclass Person whitout writing them again.
 
    //**************************************************************************    
    //Attributes
    
    private String position;
    private double salary;
    
    //*****************************************************************************   
    //this method will display a greeting message from a string using Html for formatting the text from the string 
    public String displayGreeting()
    {
        String greeting = "<html>Welcome " + getFirstName() + "<br>" 
                + " You are logged in as Staff </html>";
        return greeting;
    }   
    
    //**************************************************************************
    //getter
    
    public String getPosition()
    {
        return position;
    }
    
    public double getSalary()
    {
        return salary;
    }
    
    //**************************************************************************
    //setter
    
    public void setPosition(String positionIn)
    {
        position = positionIn;
    }
    
    public void setSalary(double salaryIn)
    {
        salary = salaryIn;
    }
    
    //**************************************************************************
    //constructor 0 parameters
    //The subclass "Staff" must have a starting value for User attribuses
    
    public Staff()
    {
        super();//keyword "super" allows to call the parameters from the superclass "User" without writing them again.
        position = "";
        salary = 0;
    }
   
    //**************************************************************************
    //Constructor imput parameters with all parameters (6 paramenters)
    //the parameters must be declared the same order as declared in the Superclass "User"
    
    public Staff(String usernameIn, String passwordIn, String firstNameIn,
            String lastNameIn,String positionIn, double salaryIn)
    {
        //method called from class "User" are written without datatype.
        super(usernameIn, passwordIn, firstNameIn, lastNameIn);
        position = positionIn;
        salary = salaryIn;
    }
}
