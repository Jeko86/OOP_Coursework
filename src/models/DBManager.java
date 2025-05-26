package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giacomo
 */
public class DBManager {
    //driver declaration and path to the database 
    //final variable is a costant Variable which won't change
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private final String connectionString = "jdbc:ucanaccess://C:\\Users\\Giacomo\\Documents\\Giacomo\\Software Development HND\\Software Development - Object Oriented Programming\\Assesment\\30190434_Shop\\Data\\ShopDB.accdb";
    
//******************************************************************************
    //select statement to displays tables Products into the Customer's menu
    public HashMap<Integer, Product> loadProducts()
    {
        //it will be used the integer ProductId As Key into the hashmap
        HashMap<Integer, Product> products = new HashMap();
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
            
            
            while (rs.next()) 
            {
                //insert all the Products's colums from the database
                int productId = rs.getInt("ProductId");
                String productName = rs.getString("ProductName");
                double price = rs.getDouble("Price");
                int stockLevel = rs.getInt("StockLevel");
                String measurement = rs.getString("Measurement");
                int size = rs.getInt("Size");
                
                //recreate the object Footwear and Clothing from the variables above 
                if(measurement == null || measurement.equals(""))
                {   
                    //int productIdIn, String productNameIn, double priceIn, int StockLevelIn, int sizeIn
                    Footwear footwear = new Footwear(productId, productName, price, stockLevel, size);
                    products.put(productId, footwear);
                }
                else
                {
                    //int productIdIn, String productNameIn, double priceIn, int StockLevelIn, String measurementIn
                    Clothing clothing = new Clothing(productId, productName, price, stockLevel, measurement);
                    products.put(productId, clothing);
                }
            }
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error Loading Products: " + ex.getMessage());
        }
        finally
        {
            return products;
        }     
    }
       
//******************************************************************************
    
    //method to load customer from the databse 
    public HashMap<String, Customer>loadCustomers()
    {
        //this hashMap will be populate by the database and it will returned at the end
        HashMap<String, Customer>customers = new HashMap();
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers");
            
            while(rs.next())
            {
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String addressLine1 = rs.getString("AddressLine1");
                String addressLine2 = rs.getString("AddressLine2");
                String town = rs.getString("Town");
                String postcode = rs.getString("Postcode");
                 
                //The variable have to be inserted in the same order listed in the constructor
                Customer customer = new Customer(username, password, firstName, lastName, addressLine1, addressLine2, town, postcode);
                
                customers.put(username, customer);
            }
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error loading Customers: " + ex.getMessage());
        }
        finally
        {
            //call the loadCostomerOrder once a specif customer open the personal profile
            customers = loadCustomerOrders(customers);
            return customers;
        }
    }
    
    //******************************************************************************    
    //this method chech that customer has the correct username and password
    //returning customers if the customer's access data are correct or null if not.
    //the imput paramenter will be username & password
    public Customer customerLogin(String username, String password)
    {
        HashMap<String, Customer>customers = loadCustomers();
        
        
        //the method .containKey allows to check if the KEY (IN THIS CASE = USER) 
        //are within the hashmap. If not it will return NULL.
        if (customers.containsKey(username)) 
        {
            Customer customer = customers.get(username);
            
            //checks the customer password
            if (customer.getPassword().equals(password)) 
            {
                return customer;
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }
    
    //**************************************************************************
    
    //method to load staff from the databse 
    public HashMap<String, Staff>loadStaffs()
    {
        //this hashMap will be populate by the database and it will returned at the end
        HashMap<String, Staff>staffs = new HashMap();
        
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff");
            
            while(rs.next())
            {
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String position = rs.getString("Position");
                double salary = rs.getDouble("Salary");
                
                 
                //The variable have to be inserted in the same order listed in the constructor                
                Staff staff = new Staff(username, password, firstName, lastName, position, salary);
                
                staffs.put(username, staff);
            }
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error loading staff: " + ex.getMessage());
        }
        finally
        {
            return staffs;
        }
    }
    
    //******************************************************************************    
    //this method chech that staff has the correct username and password
    //returning customers if the staff's access data are correct or null if not.
    //The imput paramenter will be username & password
    public Staff staffLogin(String username, String password)
    {
        HashMap<String, Staff>staffs = loadStaffs();
        
        
        //the method .containKey allows to check if the KEY (IN THIS CASE = USER) 
        //are within the hashmap. If not it will return NULL.
        if (staffs.containsKey(username)) 
        {
            Staff staff = staffs.get(username);
            
            //checks the staff password
            if (staff.getPassword().equals(password)) 
            {
                return staff;
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }
    
    //******************************************************************************
    //it allow to inser the new zookeeper info into database
      public void registerCustomer(Customer customer)
      {
          try
          {             
              Class.forName(driver);
              Connection conn = DriverManager.getConnection(connectionString);
              Statement stmt = conn.createStatement();
              
              //to insert data correctly "getValues" must be in the same order of the data within the customer table into the database
              stmt.executeUpdate("INSERT INTO Customers (Username, Password, FirstName, LastName, AddressLine1, AddressLine2, Town, Postcode) VALUES (" +
                      "'" + customer.getUsername() + "'," + 
                      "'" + customer.getPassword() + "'," +
                      "'" + customer.getFirstName() + "'," +
                      "'" + customer.getLastName()+ "'," +
                      "'" + customer.getAddressLine1()+ "'," +
                      "'" + customer.getAddressLine2()+ "'," +
                      "'" + customer.getTown()+ "'," +
                      "'" + customer.getPostcode()+ "')");               
              conn.close();
          }
          catch(Exception ex)
          {
              System.out.println("Error writing customer: " + ex.getMessage());
          }
      }
      
      //******************************************************************************
      //it is one imput paramneter
      public void editProduct(Product product)
      {
          String measurement = "";
          String size = "null";//becaus the Value size is an integer It needs to create a string which holds "null" to allow to insert the corrrect value into footwear table
          
          //the if statement will allow to find if the product is a Clots or a shoe
          //getting products which 'measurement' if they are Clots
          //or size if shoes
          if(product.getClass().getName().equals("models.Clothing"))
          {
              Clothing clothing = (Clothing)product;
              measurement = String.valueOf(clothing.getMeasurement());
              
          }
          else
          {
              Footwear footwear = (Footwear)product;
              size = String.valueOf(footwear.getSize());
          }
          
          try
          {             
              Class.forName(driver);
              Connection conn = DriverManager.getConnection(connectionString);
              Statement stmt = conn.createStatement();
              //to SET data correctly "getValues" must be in the same order of the data within the product table into the database
              stmt.executeUpdate("UPDATE Products SET " +
                      "ProductName = '" + product.getProductName() + "'," +
                      "Price = '" + product.getPrice() + "'," +
                      "StockLevel = '" + product.getStockLevel() + "'," +
                      "Measurement = '" + measurement + "'," +
                      "Size = " + size + " WHERE ProductId = '" + product.getProductId() + "'");
                      //size is without quotation marks to avoid to insert the string null into the field "Size" (within the database) which value is an integer,
                      //giving it the value null only.
                                    
              conn.close();
          }          
          catch(Exception ex)
          {
              System.out.println("Error updating Product: " + ex.getMessage());
          }
      }
      
      //******************************************************************************
      //method to remove products from its table just have as refer their primary key ProductId only
      public void deleteProduct(int productId)
      {
          try
          {             
              Class.forName(driver);
              Connection conn = DriverManager.getConnection(connectionString);
              Statement stmt = conn.createStatement();
              stmt.executeUpdate("DELETE FROM Products WHERE ProductId = '" + productId + "'");
              
              conn.close();
          }
          
          catch(Exception ex)
          {
              System.out.println("Error deleting Product: " + ex.getMessage());
          }
      }
      
      //******************************************************************************
      //this method allow to write order info into the database once clicked the buy button 
      public int writeOrder(Order order, String customerUsername)
      {
          int orderId = 0;
          try
          {              
              Class.forName(driver);
              Connection conn = DriverManager.getConnection(connectionString);
              Statement stmt = conn.createStatement();
              
              stmt.executeUpdate("INSERT INTO Orders (OrderId, OrderDate, Username, OrderTotal, Status) " +
                      "VALUES (" + 
                      "'" + order.getOrderId() + "', " +
                      "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderDate()) + "', " + //sets the corret formtata data to insert into database
                      "'" + customerUsername + "'," + //customer unique identifier (String username)
                      "'" + order.getOrderTotal() + "', " +
                      "'" + order.getStatus() + "')"
              );
              
              ResultSet rs = stmt.getGeneratedKeys();//returns the PK of the order Id
              if (rs.next())
              {
                  orderId = rs.getInt(1);   
              }             
              conn.close();
          }
          catch(Exception ex)
          {
              System.out.println("Error writing order: " + ex.getMessage());
          } 
          return orderId;
      }
      
      //******************************************************************************
      //The method allows to add order lines of products previously bought into the into the order line table
      public void writeOrderLine(OrderLine orderLine, int orderId)//odred id will allow to link the order line to its order 
      {          
          try
          {              
              Class.forName(driver);
              Connection conn = DriverManager.getConnection(connectionString);
              Statement stmt = conn.createStatement();
              
              stmt.executeUpdate("INSERT INTO OrderLines (OrderLineId, ProductId, Quantity, LineTotal, OrderId) VALUES (" +
                      "'" + orderLine.getOrderLineId() + "', " +
                      "'" + orderLine.getProduct().getProductId() + "', " +
                      "'" + orderLine.getQuantity() + "', " +
                      "'" + orderLine.getLineTotal() + "', " + 
                      "'" + orderId + "')");
              
              conn.close(); 
          }
          catch(Exception ex)
          {
              System.out.println("Error writing orderLine: " + ex.getMessage());
          }  
      }
      
      //******************************************************************************
      //the method allows to upgrade the product availability into the product's table once a quantity of a specific product is bought
      public void updateProductAvailability(int productId, int quantity)
      {
          try
          {              
              Class.forName(driver);
              Connection conn = DriverManager.getConnection(connectionString);
              Statement stmt = conn.createStatement();
              //to upbrage the stoklevel it need to    
              stmt.executeUpdate("UPDATE Products SET StockLevel = (StockLevel - " + quantity + ") WHERE ProductId ='" + productId + "'");
              
              conn.close();
          }
          catch(Exception ex)
          {
              System.out.println("Error updating product availability: " + ex.getMessage());
          } 
      }
      
      //******************************************************************************
      //method to load the orders from the database using customers HashMap as imput and output paramenters
      //with te purpose to link Customer to its orders 
      public HashMap<String, Customer> loadCustomerOrders(HashMap<String, Customer>customers)
      {
          try
          {              
              Class.forName(driver);
              Connection conn = DriverManager.getConnection(connectionString);
              Statement stmt = conn.createStatement();
              
              ResultSet rs = stmt.executeQuery("SELECT * From Orders");
              
              while (rs.next()) 
              {
                  int orderId = rs.getInt("OrderId");
                  Date orderDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("OrderDate"));//to store the correct data and time format into the database
                  String username = rs.getString("Username");
                  double orderTotal = rs.getDouble("OrderTotal");
                  String status = rs.getString("Status");  
                  // public Order(int orderIdIn, Date orderDateIn, double orderTotalIn, String statusIn)
                  Order order = new Order(orderId, orderDate, orderTotal, status);
                  
                  //This if statement chechs if the username  of a specific customer is within customerOrder Hasmap
                  if (customers.containsKey(username)) 
                  {
                      Customer customer = customers.get(username);//customer who makes a specific order
                      customer.getOrders().put(orderId, order);//order made by a specific customer
                  }  
              }
              conn.close();
          }
          catch(Exception ex)
          {
              System.out.println("Error loading orders: " + ex.getMessage());
          }
          finally
          {       
              //call loadCuatomerOrderLines method
              customers = loadCustomerOrderLines(customers);
              return customers;
          } 
      }
      
      //******************************************************************************
      //this method will allow to display the details of previous orders line by line
      //it loads the orders from the database using customers HashMap as imput and output paramenters
      public HashMap<String, Customer> loadCustomerOrderLines(HashMap<String, Customer> customers)
      {
           try
          {              
              Class.forName(driver);
              Connection conn = DriverManager.getConnection(connectionString);
              Statement stmt = conn.createStatement();
              
              ResultSet rs = stmt.executeQuery("SELECT * From OrderLines");
              
              while (rs.next()) 
              {
                  int orderLineId = rs.getInt("OrderLineId");
                  int productId = rs.getInt("ProductId");
                  int quantity = rs.getInt("Quantity");
                  double lineTotal = rs.getDouble("LineTotal");
                  int orderId = rs.getInt("OrderId");
                  
                  //the following HashMap will load the product in the orderline
                  HashMap<Integer, Product> products = loadProducts();
                  Product productsBought = products.get(productId);
                  
                  //public OrderLine(int OrderLineIdIn, Product productIn, int quantityIn, double lineTotalIn)
                  OrderLine orderLine = new OrderLine(orderLineId, productsBought, quantity, lineTotal);
                  
                  //the purpose of this loop constist in looking for a customer has the order selected (OrderID) in their orders
                  for (Map.Entry<String, Customer> customerEntry : customers.entrySet()) 
                  {
                      Customer customer = customerEntry.getValue();
                      
                      if (customer.getOrders().containsKey(orderId)) 
                      {
                          Order orderForOrderLine = customer.getOrders().get(orderId);
                          orderForOrderLine.getOrderLines().put(orderLineId, orderLine);                         
                      }
                  }                 
               }         
          }
          catch(Exception ex)
          {
              System.out.println("Error loading orderLines: " + ex.getMessage());
          }
          finally
          {              
              return customers;
          } 
           
      }
}
