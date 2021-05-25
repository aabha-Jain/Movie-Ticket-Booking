/*

 * GROUP:
 * NAME - 1.SHRUTA BHAJIKHAYE       ROLL - 2405
 * 		  2.PRACHI GHALSASI         ROLL - 2417
 *        3.AABHA JAIN              ROLL - 2419
 * 
 A DSA mini project in java on Ticket Booking Management in a Theatre. In this, the Admin can log in separately to modify details about movies and price of tickets. 
 //Through the customer log in, one can see all movies being screened, search for a particular movie,book tickets in both VIP and economy sections, order food. 
 //One can also modify account details. 
 //The data structures used are: 
 //Linear:
 // Arrays (Array of objects of customers, Array of food items.)
 // Queue: (level wise display) 
 // Non linear:
 // Tree: Binary Search Tree: (To save all movies for efficient searching)
 */

package psa;
import java.awt.image.*;	//Provides classes for creating and modifying images.
import java.io.*;			//This package provides for system input and output through data streams, serialization and the file system. 
import javax.swing.*;		//used for JFrame.
import javax.imageio.ImageIO;
import java.util.*;

class node
{//start of class node
	
    node left,right;
    String mname;	//movie name
    String time;	//movie time
    double price1;	//economy price
    double price2;	//vip price
    int screen;		
    int nseats1;	//economy seats
    int nseats2;	//vip seats
    
    //parameterized constructor
    node(String mn,String t,int n,int n1,double p,double p1,int s)
    {
        left=null;
        right=null;
        mname=mn;
        time=t;
        price1=p;
        price2 = p1;
        nseats1=n;
        nseats2=n1;
        screen=s;
        
    }
}//end of class node

class Customer
{//start of Customer class 

		Scanner sc = new Scanner(System.in);
		
		String cname;	//customer name
		String email;
		String pass;
		long contact;
		
		//default constructor
		Customer()
		{
			cname = "";
			email ="" ;
			pass = "";
			contact = 0;
		}
		
		//Function to get details of the Customer
		public Customer get_details()
		{
			
		
			int i,flag=0;
			Customer c=new Customer();
			
			//beginning of do while loop
			do{  		
				System.out.println("\n\nEnter your name:");
				c.cname = sc.next();
				int len = c.cname.length();
				for(int j=0;j<len;j++)
				{
					//condition to check if name contains no special characters or digits
				if((c.cname.charAt(j)>='a'&& c.cname.charAt(j)<='z') || (c.cname.charAt(j)>='A'&& c.cname.charAt(j)<='Z'))   
				{
					flag=1;
				}
				else
					flag=0;
				}
				if(flag==0)
				{
					System.out.println("\nEnter valid name ");
				}
				
			}while(flag==0);
			
		
			//beginning of do while loop
			do{		
				System.out.println("\nEnter your contact number: ");
				c.contact = sc.nextLong();
				
				
				long n=c.contact;
				//loop to check number of digits in contact number
				for( i=0;n!=0;n=n/10)		
				{
					i++;
				}
				if(i!=10)
				{
					System.out.println("\nEnter valid 10 digit contact number");
				}
				}while(i!=10);			//end of do-while loop
				
			
			System.out.println("\nEnter your email id: ");
			c.email = sc.next();
			
			System.out.println("\nEnter the password you wish to set: ");
			c.pass = sc.next();
			
			return c;	
		}//end of get_details()
		
		
		//Function to display details of the Customer
		public void show_details()
		{
			System.out.println("\n\nNAME: "+cname);
			System.out.println("\nCONTACT NUMBER: "+contact);
			System.out.println("\nEMAIL ID:" +email);
			
		}//end of show_details()

	}//end of Customer class


//start of theatre class
 class theatre
{
     node root;
     Scanner sc=new Scanner(System.in);
     
     //Array for objects of customer class
     Customer c[]=new Customer[20];
        
        int flag,ans;
        node temp,ptr;
        String mn,t;
        int n,n1,g,f;
        String m;
        double p,p1;
   	 	int s,ns;
       
       //default constructor
        theatre()
       {
           root=null;    
       }
        
   
    void create()                                //creating binary search tree.
        {
    	
    	for(int i=0;i<20;i++)
    	{
    		c[i]=new Customer();
    	}
        
    	Scanner sc=new Scanner(System.in);
                
            do 
            {
            	//start of do-while loop
            System.out.println("\nEnter the name of the movie: ");
            mn=sc.next();
            System.out.println("\nEnter the timings of the show: ");
            t=sc.next();    
            System.out.println("\nEnter the number of seats available in economic section: ");
            n=sc.nextInt();
            System.out.println("\nEnter the number of seats available in VIP section: ");
            n1=sc.nextInt();
            System.out.println("\nEnter the price of one economic ticket: ");
            p=sc.nextDouble();
            System.out.println("\nEnter the price of one VIP ticket: ");
            p1=sc.nextDouble();
            System.out.println("\nEnter the screen number: ");
            ns=sc.nextInt();
            
            //creating a new node
            temp=new node(mn,t,n,n1,p,p1,ns);
                
            if(root==null)
            {
                root=temp;
            }
            
            else
            {
                ptr=root;
                flag=0;
                while(flag==0)
                {
                    if(temp.mname.compareTo (ptr.mname)<0)
                    
                    {
                        if(ptr.left!=null)
                        {
                            ptr=ptr.left;
                        }
                        else
                        {        
                            ptr.left=temp;
                            flag=1;
                        }
                    
                    }
                    
                    if(temp.mname.compareTo (ptr.mname)>0)
                    {
                        if(ptr.right!=null)
                        {
                            ptr=ptr.right;
                        }
                        else
                        {
                            ptr.right=temp;
                            flag=1;
                        }
                    }
                }
            }
            
            System.out.println("\nDo you want to continue: (yes=1,no=0)");
            
            ans=sc.nextInt();
        }while(ans==1);
        
     }
     
     void update()
     {
         //Function to update customer details.
    	 int ch4=0; int i;
    	 Long con1;
    	 do
    	 {
    	 System.out.println("\nUPDATE MENU:");
    	 System.out.println("\n0.Exit\n1.Email ID\n2.Contact Number\n3.Password");
    	 System.out.println("\nEnter your choice : ");
    	 ch4=sc.nextInt();
    	 switch(ch4)
    	 {
    	 case 1: System.out.println("Enter new email id: ");
 		 		 String mail1=sc.next();
 		 		 c[g].email=mail1;
 		 		 System.out.println("\nEMAIL ID UPDATED SUCCESFULLY!\n");
 		 		 c[g].show_details();
    		 break;
    	 case 2: do{		
				System.out.println("\nEnter your new contact number: ");
				con1 = sc.nextLong();
				
				
				
				long n1=con1;
				//loop to check number of digits in contact number
				for( i=0;n1!=0;n1=n1/10)		
				{
					i++;
				}
				if(i!=10)
				{
					System.out.println("\nEnter valid 10 digit contact number");
				}
				}while(i!=10);						//end of do-while loop
 		         
    	 		 c[g].contact=con1;
    	 		 System.out.println("\nCONTACT NUMBER UPDATED SUCCESFULLY!\n");
 		         c[g].show_details();
 		         
    	 	 break;
    	 case 3: System.out.println("Enter new password: ");
    	 		 String pass1=sc.next();
    	 		 c[g].pass=pass1;
    	 		 System.out.println("\nPASSWORD UPDATED SUCCESFULLY!\n");
    		 break;
    	 case 0: System.out.println("Exiting...");
    		 break;
    		 default: System.out.println("Invalid Input");
    	 }
    	 }while(ch4!=0);
    	 
     }
     
     void update_movie()	
     //Function for updating movie timings
     {
    	 System.out.println("\nEnter the movie whose time to be updated :");
 		String key=sc.next();
 		
 		ptr=root;
 		int flag=0;
 		while(ptr!=null)
 		{
 			if(key.equals(ptr.mname))
 			{
 				flag=1;
 				break;
 			}
 			
 			if(key.compareTo(ptr.mname)<0)
 			
 				ptr=ptr.left;
 			
 			else
 				ptr=ptr.right;
 		}//end of while
 		
 		if(flag==1)
 		{
 			System.out.println("\nEnter new timing of "+ptr.mname+" :");
 			String mean=sc.next();
 			ptr.time=mean;
 			
 			System.out.println("\nNew Timing Updated");
 			
 			System.out.println("\nMovie :"+ptr.mname+"\nTime  :"+ptr.time);
 			
 		}
 			
 			else
 				System.out.println(ptr.mname+" not found");
     }
     
     //Function for updating movie price
     void update_price()
     {
    	 System.out.println("\nEnter the movie whose price to be updated:");
  		String key=sc.next();
  		
  		ptr=root;
  		int flag=0;
  		while(ptr!=null)
  		{
  			if(key.equals(ptr.mname))
  			{
  				flag=1;
  				break;
  			}
  			
  			if(key.compareTo(ptr.mname)<0)
  			
  				ptr=ptr.left;
  			
  			else
  				ptr=ptr.right;
  		}//end of while
  		
  		if(flag==1)
  		{
  			System.out.println("\nEnter seat type you want to update price : (vip,economy)");
  			String v=sc.next();
  			System.out.println("\nEnter new price of "+ptr.mname+" :");
  			double mean=sc.nextDouble();
  			
  			if(v.equals("vip"))
  			{
  				ptr.price2=mean;
  				System.out.println("\nMovie :"+ptr.mname+"\nPrice :"+ptr.price2);
  			}
  		
  				if(v.equals("economy"))
  				{
  					ptr.price1=mean;
  					System.out.println("price ="+ptr.price1);
  				}
  		}
  			
  			else
  				System.out.println(ptr.mname+" not found");
     }
     
     //Function to delete a movie
     void delete_movie()
     {
         //delete node with two child.
    	 
    	 node parent=root,ptr;
 		
 		int flag=0;
 		System.out.println("Enter the movie to be deleted:");
 		String key=sc.next();
 		
 		ptr=root;
 		while(ptr!=null)
 		{
 			
 			if(key.equals(ptr.mname))
 			{
 				flag=1;
 				break;
 			}
 			
 			else if(key.compareTo(ptr.mname)<0)
 			{
 				parent=ptr;
 				ptr=ptr.left;
 			}
 				
 			else
 			{
 				parent=ptr;
 				ptr=ptr.right;
 			}
 		}//end of while
 		
 		
 		if(flag==1)
 		{
 			
 			System.out.println("\nMovie Found!");
 			
 			
 			//deleting node with no child.
 			if(ptr.left==null && ptr.right==null)
 			{
 				if(parent.left==ptr)
 					parent.left=null;
 				
 				else
 					parent.right=null;
 				
 				
 			}
 			
 			
 			//deleting node with left child and right child null.
 			else
 				if(ptr.left!=null && ptr.right==null)
 				{
 					if(parent.left==ptr)
 						parent.left=ptr.left;
 					
 					else
 						parent.right=ptr.right;
 				}
 			
 			//deleting node with right child and left child as null.
 			else
 				if(ptr.left==null && ptr.right!=null)
 					{
 						if(parent.left==ptr)
 							parent.left=ptr.right;
 						
 						else
 							parent.right=ptr.right;
 					}
 			
 			//deleting node with 2 children.
 				else
 					if(ptr.left!=null&&ptr.right!=null)
 					{
 						node p;
 						parent=ptr;
 						p=ptr.left;
 						while(p.right!=null)
 						{
 							parent=p;
 							p=p.right;
 						}
 						if(p==ptr.left&&parent==ptr)
 							parent.left=null;
 						else
 						{
 							if(p.left==null)
 								parent.left=null;
 							else
 								parent.right=p.left;
 							
 						}
 						
 						ptr.mname=p.mname;
 						ptr.mname=p.mname;
 					}
 			
 		}
 		else
 			System.out.println("not found");
 		
 	}
     

     
     int login()
     		//log in to account
     {
    	 
    	 	String n="admin";
    	 	String password="root123";
    	 	String a;
    	 	String p;
    	 	int ans;
    	 	int flag=0,i;
    	 	
    	 	System.out.println("\n\nLOGIN MENU\n1.Admin Login\n2.Customer Login");
    	 	System.out.println("\nEnter your choice: ");
    	 	ans=sc.nextInt();
    	 	System.out.println("\nENTER USERNAME: ");
    	 	a=sc.next();
    	 	System.out.println("\nENTER PASSWORD: ");
    	 	p=sc.next();
    	 	switch(ans)
    	 	{
    	 	case 1:	  if(a.equals(n) && p.equals(password))		//checking for valid username and password
    	 				{
	 	    				flag=1;
    	 				}
    		if(flag==0)
	 		{
	 		System.out.println("\nAdmin Login Failed");
	 		System.out.println("\nCheck user name or password");
	 		return 0;

	 		}
	 		else
	 		{
	 	    	System.out.println("\nAdmin Login Successful");
	 	    	return 2;
	 		}
    	 		
    	 	case 2:
    	 		for(i=0;i<f;i++)
    	 		{
    	 	
    	 	    if(a.equals(c[i].cname) && p.equals(c[i].pass))		//checking for valid username and password
    	 	    {
    	 	    	
    	 	    	flag=1;
    	 	    	g=i;
    	 	    }
    	 		}    
    	 		if(flag==0)
    	 		{
    	 		System.out.println("\nCustomer Login Failed");
    	 		System.out.println("\nCheck user name or password");
    	 		return 0;

    	 		}
    	 		else
    	 		{
    	 	    	System.out.println("\nCustomer Login Successful");
    	 	    	System.out.println("\n\nWELCOME "+c[g].cname+"!");
    	 	    	return 1;
    	 		}
    	 	
    	 		default: return 0;
    	 	}
    	 	
    	
     }
     
     //Function to create already existing accounts
     void create_acc()
     {
    	System.out.println("\nEnter the number of already existing customers : ");
 		f=sc.nextInt();
 		
 		for(int i=0;i<f;i++)
 		{
 			c[i] = new Customer();		//assigning memory.
 			System.out.println("\nEnter your credentials as follows");
 			c[i]=c[i].get_details();
 			System.out.println("\n'ACCOUNT CREATED SUCCESSFULLY!'\n");
 		}
 		
 		
     }
     
     //Function to create a new account
     void create_new_acc()
     {
    	 int v=0;
    	 c[f]=new Customer();
    	 c[f]=c[f].get_details();
    	 for(int k=0;k<(f+1);k++)
    	 {
    		  v = c[f].email.compareTo(c[k].email);

    		  v=1;
    	 }  
 	    	if(v==0)
 	    		{
 	    			System.out.println("\nAccount already exists.");
 	    		    System.out.println("\nNew account not created.");
 	    		}
 	    	else
 	    		System.out.println("\n'NEW ACCOUNT CREATED'");
    	 f++;
     }
     
     
     //Function to display tree of movies level-wise
     public void level1()
		{
			display(root);
		}
     
     //Level wise display of tree of movies
     void display(node tree)
     {

			Queue<node> q=new LinkedList<node>() ;
			
			while(tree!=null)
			{
				System.out.println(tree.mname);
				
				
				if(tree.left!=null)
				{
					q.add(tree.left);
				}
				
				if(tree.right!=null)
				{
					q.add(tree.right);
				}
				if(q.isEmpty()==true)
				{
					tree=null;
				}
				else
				{
					tree=q.remove();
				}
				
				
				}
     }
     
     
     //Function to search a particular movie in the tree 
     void search()
     {
         
    	 node ptr;
 		
 		int flag=0;
 		System.out.println("\nEnter the movie to be searched:");
 		String key=sc.next();
 		
 		ptr=root;
 		while(ptr!=null)
 		{
 			if(key.equals(ptr.mname))
 			{
 				flag=1;
 				break;
 			}
 			
 			if(key.compareTo(ptr.mname)<0)
 			
 				ptr=ptr.left;
 			else
 				ptr=ptr.right;
 		}//end of while
 		
 		if(flag==0)
 		
 			System.out.println("\nMOVIE IS NOT BEING SCREENED.");
 		else
 			System.out.println("\nMOVIE IS BEING SCREENED.");
     }
     
     //Function to book tickets of a particular movie 
     void book()
     {
    	 int type;
    	 char ans;
         System.out.println("\nEnter the movie name you want to book: ");
         m=sc.next();
         node ptr;
  		
  		int flag=0;
  		
  		ptr=root;
  		while(ptr!=null)
  		{
  			if(m.equals(ptr.mname))
  			{
  				flag=1;
  				break;
  			}
  			
  			if(m.compareTo(ptr.mname)<0)
  			
  				ptr=ptr.left;
  			else
  				ptr=ptr.right;
  		}//end of while
  		
  		if(flag==1)
  		{
  			System.out.println("\n"+ptr.mname+" Found");
  			
  			
  			System.out.println("Types of seats :");
  			System.out.println("1-VIP        Available seats = "+ptr.nseats2+" \tPrice : Rs "+ptr.price2);
  			System.out.println("2-Economy    Available seats = "+ptr.nseats1+" \tPrice : Rs "+ptr.price1);
  			
  			if(ptr.nseats1==0 && ptr.nseats2==0)
  				System.out.println("\n******HOUSEFULL******");
  			
  			else {
  			System.out.println("\nEnter the type of seat you wish to book: ");
  			type = sc.nextInt();
  			
  			switch(type)
  			{
  				case 1:
  					System.out.println("\n****VIP****\n");
  				System.out.println("\nEnter the number of seats: ");
  	  			s=sc.nextInt();
  	  			if(s<=ptr.nseats2)
  	  			{
  	  				System.out.println("\n");
  	  				System.out.println(s+" Seats booked successfully!");
  	  				ptr.nseats2=ptr.nseats2-s;
  	  				bill(ptr,s,ptr.price2);
  	  			}
  	  			else
  	  				if(ptr.nseats2==0)
  	  				{
  	  					System.out.println("\nVIP SEATS FULL!!");
  	  				}
  	  				 
  	  				
  	  				
  	  			else
  	  			{
  	  				System.out.println("\nSorry! Entered number of seats are not available");
  	  			}
  				
  					break;
  					
  				case 2:
  					System.out.println("****ECONOMY****");
  	  				System.out.println("\nEnter the number of seats: ");
  	  	  			s=sc.nextInt();
  	  	  			if(s<=ptr.nseats1)
  	  	  			{
  	  	  				System.out.println("\n");
  	  	  				System.out.println(s+" seats booked successfully!");
  	  	  				ptr.nseats1=ptr.nseats1-s;
  	  	  				bill(ptr,s,ptr.price1);
  	  	  			}
  	  	  			else
  	  	  				if(ptr.nseats1==0)
  	  	  				{
  	  	  				System.out.println("\nECONOMY SEATS FULL!!");
  	  	  				}
  	  	  			
  	  	  			else
  	  	  			{
  	  	  			System.out.println("\nSorry! Entered number of seats are not available");
  	  	  			}
  	  				
  	  	  			break;
  					
  					default: System.out.println("Invalid Choice.");
  			}
  			
  			}
  		}
  		else
  			System.out.println("Movie Not Found");
     }
     
     
     void bill(node ptr,int s,double p)
     {
    	 double bill;
    	 double gst;
    
    	 bill=s*p;
    	 gst=(0.18*bill);
    	
    	 bill=bill+gst;
    	 
        System.out.println("\t\t-------------------------------------------------------------------");
 		System.out.println("\t\t                       TICKET CONFIRMATION                       ");
 		System.out.println("\t\t                                                                 ");
 		System.out.println("\t\t     MOVIE:   "+ptr.mname+"                                      ");
 		System.out.println("\t\t                                                                 ");
 		System.out.println("\t\t     TIMING:  "+ptr.time+"                                       ");
 		System.out.println("\t\t                                                                 ");
 		System.out.println("\t\t     SCREEN:  "+ptr.screen+"                                     ");
 		System.out.println("\t\t                                                                 ");
 		System.out.println("\t\t     TICKETS: "+s+"                                              ");
 		System.out.println("\t\t                                                                 ");
 		System.out.println("\t\t     DATE:    11/03/2019                                         ");
 		System.out.println("\t\t                                                                 ");
 		System.out.println("\t\t     GST 18%: "+gst+"                                            ");
 		System.out.println("\t\t                                                                 ");
 		System.out.println("\t\t     TOTAL:   "+bill+"                                           ");
 		System.out.println("\t\t                                                                 ");
 		System.out.println("\t\t                                                                 ");
 		System.out.println("\t\t  **********THANK YOU FOR BOOKING! ENJOY YOUR SHOW*********      ");
 		System.out.println("\t\t                                                                 ");
 		System.out.println("\t\t-------------------------------------------------------------------");
    	
     }
    
     
     //Function to order food 
    void food()
    {
        System.out.println("\nFOOD MENU:");
        System.out.println("\n1-Popcorn\t\tRs.250\n2-Nachos\t\t\tRs.150\n3-Coke    \t\t\tRs.100\n4-Samosa\t\t\tRs.75\n5-Burger\t\t\tRs.160\n6-Combo(Popcorn+Coke) \t\tRs.320\n7-Combo(Samosa+Nachos+Coke)  \tRs.300");
        String a[]=new String[7];
        double b[]=new double[7];
        int a1;
        double bill=0;
        char ch6;
        a[0]="Popcorn";
        a[1]="Nachos";
        a[2]="Coke";
        a[3]="Samosa";
        a[4]="Burger";
        a[5]="Combo(Popcorn+Coke)";
        a[6]="Combo(Samosa+Nachos+Coke)";
        
        b[0]=250;
        b[1]=150;
        b[2]=100;
        b[3]=75;
        b[4]=160;
        b[5]=320;
        b[6]=300;
        
        do {
       System.out.println("\nEnter the item you wish to order :");
        a1=sc.nextInt();
       System.out.println("\nEnter the quantity :");
       int q=sc.nextInt();
       
       bill=bill+(q*b[a1-1]); 
       System.out.println("\nDo you wish to add anything else? (Yes-y,No-n)"); 
       ch6=sc.next().charAt(0);
        }while(ch6=='y');
       
        double gst;
        gst=0.05*bill;
        System.out.println("\t\t-------------------------------------------------------------------\n");
        System.out.println("\t\tGST 5%          : "+gst);
        bill=bill+gst;
        System.out.println("\t\tTOTAL FOOD BILL : "+bill);
        System.out.println("\t\t-------------------------------------------------------------------\n");
    }
    
    

    	int logout()		
    	//Function to log out from account
    	{
    		char ans;
    		do
    		{
    			System.out.println("\nDo you wish to confirm LOG OUT?(Press 'y' for YES and Press 'n' for NO): ");
    		ans= sc.next().charAt(0);
    				
    		if(ans!='y')
    		{
    			 if(ans!='Y')
    			{
    				if(ans!='n')
    				{
    					 if(ans!='N')
    					{
    						 System.out.println("INVALID ANSWER ENTERED.ENTER ONLY 'y' for yes or 'n' for no.");
    					}
    				}
    			}
    		}

    		}while(ans!='y' && ans!='Y' && ans!='n'&& ans!='N');


    		if(ans=='y'||ans=='Y')
    		{
    			System.out.println("\nLogged Out Successfully.");
    			 System.out.print("\nTHANK YOU FOR USING OUR SERVICES!");
    			return 1;
    	    }

    		else
    		{
    			return 0;
    		}
    	}

}

//start class of Main class psa
public class psa 
{
	
	//start of main function
    public static void main(String[] args) throws IOException 
    { //handling io exception.
        
    	// code for adding image.
    	JPanel panel = new JPanel();	//it is a part of java swing package. Various layout can be set.

		BufferedImage image = ImageIO.read(new File("C:/Users/Aabha jain/Desktop/final.jpg"));	//add path of file.
		JLabel label = new JLabel(new ImageIcon(image));		//JLabel is used to display a short string or an image icon. JLabel can display text, image or both .
		panel.add(label);

		// main window
		JFrame.setDefaultLookAndFeelDecorated(true);  //for compatibility with different os.
		JFrame frame = new JFrame("WELCOME");	//adding name of frame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add the Jpanel to the main window
		frame.add(panel); 

		frame.pack();
		frame.setVisible(true);	// makes the GUI component visible to the user 
    	
    	theatre t=new theatre();
    	System.out.println("\t ____     ___    ___");
    	System.out.println("\t|    |   |      |   | ");
    	System.out.println("\t|____|   |___   |___|");
    	System.out.println("\t|            |  |   |");
    	System.out.println("\t|         ___|  |   |");
    	t.create();
    	System.out.println("\nTHE MOVIES BEING SCREENED ARE :"); 
    	t.level1();
    	
    	int ans,logans=0,ch1;
    	t.create_acc();
    	Scanner s=new Scanner(System.in);
    	do{
    		System.out.println("\n\nMAIN MENU");		//main menu
    		System.out.println("0.Exit");
    		System.out.println("1.Create New Account");
    		System.out.println("2.Login");

    		System.out.println("\n\nEnter you choice : ");
    		ans=s.nextInt();

    		switch(ans)
    		{
    		case 0:
    			System.out.println("\n\nExiting...");
    			break;

    		case 1:
    			t.create_new_acc();
    			break;

    		case 2:
    			int answer = t.login();

    			if(answer==2)
	    		{
    				int ans3=0;
    				do
    				{
	    			System.out.println("\nADMIN LOGIN MENU");
	    			System.out.println("1.Update Movie Timings");
	    			System.out.println("2.Update Movie Price");
	    			System.out.println("3.Remove A Movie");
	    			System.out.println("4.Logout");
	    			System.out.println("\nEnter your choice: ");
	    			ch1=s.nextInt();
	    			switch(ch1)
	    			{
	    			case 1:	t.update_movie();
	    				break;
	    			case 2:
	    				t.update_price();
	    				break;
	    				
	    			case 3: t.delete_movie();
	    			System.out.println("\nAfter Deletion :\n");
	    			t.level1();
	    				break;
	    			case 4:	ans3=t.logout();
	    				break;
	    			default:
	    			}//end switch
    				}while(ans3!=1);
	    		}//end if
			

    			
    			
    			if(answer==1)
    			{
    				int ans2;
    				do{
    					System.out.print("\n\n\nCUSTOMER LOGIN MENU: \n");		//log in menu
    					System.out.print("\n1.See All Movies");
    					System.out.print("\n2.Search A Movie");
    				
    					System.out.print("\n3.Book Seats");
    					System.out.print("\n4.Order Food");
    					System.out.print("\n5.Modify Account Details");
    					System.out.print("\n6.Logout");

    					System.out.print("\n\nEnter your choice: ");
    					ans2=s.nextInt();

    					switch(ans2)
    					{
    					case 1:
    						t.level1();
    						break;
    						
    					case 2:
    						t.search();
    						break;
    							
    					case 3:
    						t.book();
    						break;
    						
    					case 4:
    						t.food();
    						break;
    						
    					case 5:
    						t.update();
    						break;
    						
    					case 6:
    						 logans = t.logout();
    						 break;

    					default:  System.out.print("\nInvalid Choice Entered.");

    					}//end switch
    					
    				
    				
    				}while(logans!=1); //end do
    				
    			}//end if
    			break;
    		default:
    			System.out.println("\nInvalid choice");
    		
    		}//end of big switch

    	}while(ans!=0);
    	}//end of main function
  
    	
    //end of program
    }




/*
 * ---------------------OUTPUT------------------------
 * 
 * 	 ____     ___    ___
	|    |   |      |   | 
	|____|   |___   |___|
	|            |  |   |
	|         ___|  |   |

Enter the name of the movie: 
marvel

Enter the timings of the show: 
8:00am

Enter the number of seats available in economic section: 
80

Enter the number of seats available in VIP section: 
20

Enter the price of one economic ticket: 
150

Enter the price of one VIP ticket: 
250

Enter the screen number: 
1

Do you want to continue: (yes=1,no=0)
1

Enter the name of the movie: 
gullyboy

Enter the timings of the show: 
9:00am

Enter the number of seats available in economic section: 
90

Enter the number of seats available in VIP section: 
10

Enter the price of one economic ticket: 
130

Enter the price of one VIP ticket: 
260

Enter the screen number: 
2

Do you want to continue: (yes=1,no=0)
1

Enter the name of the movie: 
dangal

Enter the timings of the show: 
10:45am

Enter the number of seats available in economic section: 
70

Enter the number of seats available in VIP section: 
30

Enter the price of one economic ticket: 
150

Enter the price of one VIP ticket: 
230

Enter the screen number: 
3

Do you want to continue: (yes=1,no=0)
1

Enter the name of the movie: 
aiyari

Enter the timings of the show: 
2:30pm

Enter the number of seats available in economic section: 
140

Enter the number of seats available in VIP section: 
60

Enter the price of one economic ticket: 
150

Enter the price of one VIP ticket: 
300

Enter the screen number: 
5

Do you want to continue: (yes=1,no=0)
1

Enter the name of the movie: 
fan

Enter the timings of the show: 
1:00pm

Enter the number of seats available in economic section: 
55

Enter the number of seats available in VIP section: 
12

Enter the price of one economic ticket: 
160

Enter the price of one VIP ticket: 
290

Enter the screen number: 
2

Do you want to continue: (yes=1,no=0)
1

Enter the name of the movie: 
jackpot

Enter the timings of the show: 
7:00pm

Enter the number of seats available in economic section: 
60

Enter the number of seats available in VIP section: 
20

Enter the price of one economic ticket: 
200

Enter the price of one VIP ticket: 
300

Enter the screen number: 
3

Do you want to continue: (yes=1,no=0)
1

Enter the name of the movie: 
ishq

Enter the timings of the show: 
6:45pm

Enter the number of seats available in economic section: 
50

Enter the number of seats available in VIP section: 
50

Enter the price of one economic ticket: 
170

Enter the price of one VIP ticket: 
230

Enter the screen number: 
1

Do you want to continue: (yes=1,no=0)
1

Enter the name of the movie: 
kick

Enter the timings of the show: 
4:15pm

Enter the number of seats available in economic section: 
190

Enter the number of seats available in VIP section: 
200

Enter the price of one economic ticket: 
160

Enter the price of one VIP ticket: 
220

Enter the screen number: 
5

Do you want to continue: (yes=1,no=0)
1

Enter the name of the movie: 
roma

Enter the timings of the show: 
9:00pm

Enter the number of seats available in economic section: 
90

Enter the number of seats available in VIP section: 
10

Enter the price of one economic ticket: 
150

Enter the price of one VIP ticket: 
230

Enter the screen number: 
2

Do you want to continue: (yes=1,no=0)
1

Enter the name of the movie: 
pitchperfect

Enter the timings of the show: 
3:00pm

Enter the number of seats available in economic section: 
80

Enter the number of seats available in VIP section: 
20

Enter the price of one economic ticket: 
120

Enter the price of one VIP ticket: 
290

Enter the screen number: 
4

Do you want to continue: (yes=1,no=0)
1

Enter the name of the movie: 
nightscream

Enter the timings of the show: 
3:00pm

Enter the number of seats available in economic section: 
60

Enter the number of seats available in VIP section: 
40

Enter the price of one economic ticket: 
140

Enter the price of one VIP ticket: 
200

Enter the screen number: 
3

Do you want to continue: (yes=1,no=0)
1

Enter the name of the movie: 
quality

Enter the timings of the show: 
4:00pm

Enter the number of seats available in economic section: 
65

Enter the number of seats available in VIP section: 
35

Enter the price of one economic ticket: 
175

Enter the price of one VIP ticket: 
250

Enter the screen number: 
3

Do you want to continue: (yes=1,no=0)
1

Enter the name of the movie: 
unstoppable

Enter the timings of the show: 
9:15pm

Enter the number of seats available in economic section: 
70

Enter the number of seats available in VIP section: 
25

Enter the price of one economic ticket: 
275

Enter the price of one VIP ticket: 
375

Enter the screen number: 
4

Do you want to continue: (yes=1,no=0)
1

Enter the name of the movie: 
Terminator

Enter the timings of the show: 
7:30pm

Enter the number of seats available in economic section: 
50

Enter the number of seats available in VIP section: 
10

Enter the price of one economic ticket: 
175

Enter the price of one VIP ticket: 
220

Enter the screen number: 
3

Do you want to continue: (yes=1,no=0)
1

Enter the name of the movie: 
Vacany

Enter the timings of the show: 
11:00am

Enter the number of seats available in economic section: 
80

Enter the number of seats available in VIP section: 
20

Enter the price of one economic ticket: 
150

Enter the price of one VIP ticket: 
210

Enter the screen number: 
2

Do you want to continue: (yes=1,no=0)
0

THE MOVIES BEING SCREENED ARE :
marvel
gullyboy
roma
dangal
jackpot
pitchperfect
unstoppable
aiyari
fan
ishq
kick
nightscream
quality
Terminator
Vacany

Enter the number of already existing customers : 
1

Enter your credentials as follows


Enter your name:
aabha

Enter your contact number: 
9004552808

Enter your email id: 
aabha@gmail.com

Enter the password you wish to set: 
hello

'ACCOUNT CREATED SUCCESSFULLY!'



MAIN MENU
0.Exit
1.Create New Account
2.Login


Enter you choice : 
1


Enter your name:
prachi

Enter your contact number: 
741258963

Enter valid 10 digit contact number

Enter your contact number: 
7412589630

Enter your email id: 
prachi@gmail.com

Enter the password you wish to set: 
yello

'NEW ACCOUNT CREATED'


MAIN MENU
0.Exit
1.Create New Account
2.Login


Enter you choice : 
2


LOGIN MENU
1.Admin Login
2.Customer Login

Enter your choice: 
1

ENTER USERNAME: 
admin

ENTER PASSWORD: 
root123

Admin Login Successful

ADMIN LOGIN MENU
1.Update Movie Timings
2.Update Movie Price
3.Remove A Movie
4.Logout

Enter your choice: 
1

Enter the movie whose time to be updated :
gullyboy

Enter new timing of gullyboy :
5:30pm

New Timing Updated

Movie :gullyboy
Time  :5:30pm

ADMIN LOGIN MENU
1.Update Movie Timings
2.Update Movie Price
3.Remove A Movie
4.Logout

Enter your choice: 
2

Enter the movie whose price to be updated:
dangal

Enter seat type you want to update price : (vip,economy)
vip

Enter new price of dangal :
400

Movie :dangal
Price :400.0

ADMIN LOGIN MENU
1.Update Movie Timings
2.Update Movie Price
3.Remove A Movie
4.Logout

Enter your choice: 
3
Enter the movie to be deleted:
roma

Movie Found!

After Deletion :

marvel
gullyboy
quality
dangal
jackpot
pitchperfect
unstoppable
aiyari
fan
ishq
kick
quality
Terminator
Vacany

ADMIN LOGIN MENU
1.Update Movie Timings
2.Update Movie Price
3.Remove A Movie
4.Logout

Enter your choice: 
4

Do you wish to confirm LOG OUT?(Press 'y' for YES and Press 'n' for NO): 
y

Logged Out Successfully.

THANK YOU FOR USING OUR SERVICES!

MAIN MENU
0.Exit
1.Create New Account
2.Login


Enter you choice : 
2


LOGIN MENU
1.Admin Login
2.Customer Login

Enter your choice: 
2

ENTER USERNAME: 
prachi

ENTER PASSWORD: 
yello

Customer Login Successful


WELCOME prachi!



CUSTOMER LOGIN MENU: 

1.See All Movies
2.Search A Movie
3.Book Seats
4.Order Food
5.Modify Account Details
6.Logout

Enter your choice: 1
marvel
gullyboy
quality
dangal
jackpot
pitchperfect
unstoppable
aiyari
fan
ishq
kick
quality
Terminator
Vacany



CUSTOMER LOGIN MENU: 

1.See All Movies
2.Search A Movie
3.Book Seats
4.Order Food
5.Modify Account Details
6.Logout

Enter your choice: 2

Enter the movie to be searched:
unstoppable

MOVIE IS BEING SCREENED.



CUSTOMER LOGIN MENU: 

1.See All Movies
2.Search A Movie
3.Book Seats
4.Order Food
5.Modify Account Details
6.Logout

Enter your choice: 2

Enter the movie to be searched:
transformer

MOVIE IS NOT BEING SCREENED.



CUSTOMER LOGIN MENU: 

1.See All Movies
2.Search A Movie
3.Book Seats
4.Order Food
5.Modify Account Details
6.Logout

Enter your choice: 3

Enter the movie name you want to book: 
gullyboy

gullyboy Found
Types of seats :
1-VIP        Available seats = 10 	Price : Rs 260.0
2-Economy    Available seats = 90 	Price : Rs 130.0

Enter the type of seat you wish to book: 
1

****VIP****


Enter the number of seats: 
10


10 Seats booked successfully!
		-------------------------------------------------------------------
		                       TICKET CONFIRMATION                       
		                                                                 
		     MOVIE:   gullyboy                                      
		                                                                 
		     TIMING:  5:30pm                                       
		                                                                 
		     SCREEN:  2                                     
		                                                                 
		     TICKETS: 10                                              
		                                                                 
		     DATE:    11/03/2019                                         
		                                                                 
		     GST 18%: 468.0                                            
		                                                                 
		     TOTAL:   3068.0                                           
		                                                                 
		                                                                 
		  **********THANK YOU FOR BOOKING! ENJOY YOUR SHOW*********      
		                                                                 
		-------------------------------------------------------------------



CUSTOMER LOGIN MENU: 

1.See All Movies
2.Search A Movie
3.Book Seats
4.Order Food
5.Modify Account Details
6.Logout

Enter your choice: 3

Enter the movie name you want to book: 
gullyboy

gullyboy Found
Types of seats :
1-VIP        Available seats = 0 	Price : Rs 260.0
2-Economy    Available seats = 90 	Price : Rs 130.0

Enter the type of seat you wish to book: 
1

****VIP****


Enter the number of seats: 
12

VIP SEATS FULL!!



CUSTOMER LOGIN MENU: 

1.See All Movies
2.Search A Movie
3.Book Seats
4.Order Food
5.Modify Account Details
6.Logout

Enter your choice: 3

Enter the movie name you want to book: 
gullyboy

gullyboy Found
Types of seats :
1-VIP        Available seats = 0 	Price : Rs 260.0
2-Economy    Available seats = 90 	Price : Rs 130.0

Enter the type of seat you wish to book: 
2
****ECONOMY****

Enter the number of seats: 
90


90 seats booked successfully!
		-------------------------------------------------------------------
		                       TICKET CONFIRMATION                       
		                                                                 
		     MOVIE:   gullyboy                                      
		                                                                 
		     TIMING:  5:30pm                                       
		                                                                 
		     SCREEN:  2                                     
		                                                                 
		     TICKETS: 90                                              
		                                                                 
		     DATE:    11/03/2019                                         
		                                                                 
		     GST 18%: 2106.0                                            
		                                                                 
		     TOTAL:   13806.0                                           
		                                                                 
		                                                                 
		  **********THANK YOU FOR BOOKING! ENJOY YOUR SHOW*********      
		                                                                 
		-------------------------------------------------------------------



CUSTOMER LOGIN MENU: 

1.See All Movies
2.Search A Movie
3.Book Seats
4.Order Food
5.Modify Account Details
6.Logout

Enter your choice: 3

Enter the movie name you want to book: 
gullyboy

gullyboy Found
Types of seats :
1-VIP        Available seats = 0 	Price : Rs 260.0
2-Economy    Available seats = 0 	Price : Rs 130.0

******HOUSEFULL******



CUSTOMER LOGIN MENU: 

1.See All Movies
2.Search A Movie
3.Book Seats
4.Order Food
5.Modify Account Details
6.Logout

Enter your choice: 4

FOOD MENU:

1-Popcorn		Rs.250
2-Nachos			Rs.150
3-Coke    			Rs.100
4-Samosa			Rs.75
5-Burger			Rs.160
6-Combo(Popcorn+Coke) 		Rs.320
7-Combo(Samosa+Nachos+Coke)  	Rs.300

Enter the item you wish to order :
2

Enter the quantity :
5

Do you wish to add anything else? (Yes-y,No-n)
y

Enter the item you wish to order :
1

Enter the quantity :
2

Do you wish to add anything else? (Yes-y,No-n)
n
		-------------------------------------------------------------------

		GST 5%          : 62.5
		TOTAL FOOD BILL : 1312.5
		-------------------------------------------------------------------




CUSTOMER LOGIN MENU: 

1.See All Movies
2.Search A Movie
3.Book Seats
4.Order Food
5.Modify Account Details
6.Logout

Enter your choice: 5

UPDATE MENU:

0.Exit
1.Email ID
2.Contact Number
3.Password

Enter your choice : 
1
Enter new email id: 
prachi123@gmail.com

EMAIL ID UPDATED SUCCESFULLY!



NAME: prachi

CONTACT NUMBER: 7412589630

EMAIL ID:prachi123@gmail.com

UPDATE MENU:

0.Exit
1.Email ID
2.Contact Number
3.Password

Enter your choice : 
2

Enter your new contact number: 
9004552808

CONTACT NUMBER UPDATED SUCCESFULLY!



NAME: prachi

CONTACT NUMBER: 9004552808

EMAIL ID:prachi123@gmail.com

UPDATE MENU:

0.Exit
1.Email ID
2.Contact Number
3.Password

Enter your choice : 
3
Enter new password: 
hello12344

PASSWORD UPDATED SUCCESFULLY!


UPDATE MENU:

0.Exit
1.Email ID
2.Contact Number
3.Password

Enter your choice : 
0
Exiting...



CUSTOMER LOGIN MENU: 

1.See All Movies
2.Search A Movie
3.Book Seats
4.Order Food
5.Modify Account Details
6.Logout

Enter your choice: 6

Do you wish to confirm LOG OUT?(Press 'y' for YES and Press 'n' for NO): 
y

Logged Out Successfully.

THANK YOU FOR USING OUR SERVICES!

MAIN MENU
0.Exit
1.Create New Account
2.Login


Enter you choice : 
0


Exiting...

 * 
 */

