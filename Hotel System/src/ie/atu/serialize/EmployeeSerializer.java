package ie.atu.serialize;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;


import ie.atu.hotel.Employee;

public class EmployeeSerializer  {
	private ArrayList<Employee> employees;
	
	private final String FILENAME = "employees.bin";	
	private File employeesFile;	
	
	// Default Constructor
	public EmployeeSerializer(){
		// Construct EmployeeList ArrayList
		employees = new ArrayList<Employee>();

		
		employeesFile = new File(FILENAME);
		

		
        
        try {
            
            if (!employeesFile.exists()) {
                boolean fileCreated = employeesFile.createNewFile();
                if (fileCreated) {
                    System.out.println("File created: " + FILENAME);
                } else {
                    System.out.println("File already exists: " + FILENAME);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

		

	
	
	
	
	/////////////////////////////////////////////////////////////
	// Method Name : add()								              //
	// Return Type : void								              //
	// Parameters : None								                 //
	// Purpose : Reads one Employee record from the user       //
	//           and adds it to the ArrayList called employees //
	/////////////////////////////////////////////////////////////
	public void add(){ 
	    // Create an Employee object
		 Employee employee = new Employee();
 
       
		 {
		 if (employee.read()==true) 
			 employees.add(employee);
		 else
		     Employee.setNextNumber(Employee.getNextNumber() - 1);  
		 
		 
		   
		        
		    }
	}	

	///////////////////////////////////////////////////////
	// Method Name : list()						              //
	// Return Type : void					   	           //
	// Parameters : None						                 //
	// Purpose : Lists all Employee records in employees //
	///////////////////////////////////////////////////////		
	public void list(){
		String employeesToList="";

		if(!employees.isEmpty()) {
			
			for(Employee tmpEmployee : employees) {
				
				employeesToList+=tmpEmployee;
				
				employeesToList+="\n";
			}
			
			
		   JOptionPane.showMessageDialog(null, employeesToList, "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);	
		}
		else
			
		   JOptionPane.showMessageDialog(null, "No Employees to list.", "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);	
	}	

	////////////////////////////////////////////////////////////////
	// Method Name : view()									              //
	// Return Type : Employee								              //
	// Parameters : None								                    //
	// Purpose : Displays the required Employee record on screen  //
	//         : And returns it, or null if not found             //   
	////////////////////////////////////////////////////////////////	
	public Employee view() {
	    // 
	    String empnumAsString = JOptionPane.showInputDialog("Enter Employee Number:");

	 
	    if (empnumAsString == null) {
	        return null;  
	    }

	    
	    int employeeNum;
	    try {
	        employeeNum = Integer.parseInt(empnumAsString); 
	    } catch (NumberFormatException e) {
	    
	        JOptionPane.showMessageDialog(null, "Invalid employee number. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
	        return null;  
	    }

	    
	    for (Employee tmpEmployee : employees) {
	        if (tmpEmployee.getNumber() == employeeNum) {
	            
	            JOptionPane.showMessageDialog(null, tmpEmployee.toString(), "Employee Details", JOptionPane.INFORMATION_MESSAGE);
	            return tmpEmployee;  
	        }
	    }

	  
	    JOptionPane.showMessageDialog(null, "Employee with number " + employeeNum + " not found.", "Employee Not Found", JOptionPane.INFORMATION_MESSAGE);
	    return null; 
	}

	///////////////////////////////////////////////////////////////////
	// Method Name : delete()							        	           //
	// Return Type : void								        	           //
	// Parameters : None									                    //
	// Purpose : Deletes the required Employee record from employees //
	///////////////////////////////////////////////////////////////////	
	public void delete(){
		// Call view() to find, display, & return the employee to delete
				Employee tempEmployee = view();

				// If the employee != null, i.e. it was found then...
			    if(tempEmployee != null)
				   // ...remove it from employee
			       employees.remove(tempEmployee);		
			}		
	

	///////////////////////////////////////////////////////////////
	// Method Name : edit()			  					                //
	// Return Type : void								    	          //
	// Parameters : None								     	             //
	// Purpose : Edits the required Employee record in employees //
	///////////////////////////////////////////////////////////////	
	public void edit(){
		// Call view() to find, display, & return the Employee to edit
		Employee tempEmployee = view();

		// If the Employee != null, i.e. it was found then...
	    if(tempEmployee != null){
		   // get it's index
		   int index=employees.indexOf(tempEmployee);
		   // read in a new Employee and...
		   tempEmployee.read();
		   // reset the object in Employees
		   employees.set(index, tempEmployee);
	    }			
	}
	
	// This method will serialize the employees ArrayList when called, 
	// i.e. it will write employees to a file called employees.bin
			
	
	public void serializeEmployees() {
	    ObjectOutputStream os = null;
	    FileOutputStream fileStream = null;

	    try {
	      
	        fileStream = new FileOutputStream(employeesFile);
	        os = new ObjectOutputStream(fileStream);

	       
	        os.writeInt(Employee.getNextNumber()); 

	        
	        os.writeObject(employees);

	    } catch (FileNotFoundException fNFE) {
	        System.out.println("Cannot create file to store employees.");
	    } catch (IOException ioE) {
	        System.out.println("Cannot write to " + employeesFile.getName() + ".");
	    } finally {
	        try {
	            if (os != null) os.close();
	            if (fileStream != null) fileStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// This method will deserialize the Employees ArrayList when called, 
	// i.e. it will restore the employees ArrayList from the file employees.bin
	public void deserializeEmployees() {
	    ObjectInputStream is = null;
	    FileInputStream fileStream = null;

	    try {
	        
	        fileStream = new FileInputStream(employeesFile);
	        is = new ObjectInputStream(fileStream);

	       
	        int savedNextNumber = is.readInt();  
	        Employee.setNextNumber(savedNextNumber); 

	        
	        employees = (ArrayList<Employee>) is.readObject();

	    } catch (FileNotFoundException fNFE) {
	        System.out.println("Cannot create file to store employees.");
	    } catch (IOException ioE) {
	        System.out.println("Cannot read from " + employeesFile.getName() + ".");
	    } catch (ClassNotFoundException cnfe) {
	        System.out.println("Class not found during deserialization.");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    } finally {
	        try {
	            if (is != null) is.close();
	            if (fileStream != null) fileStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	
}