import java.io.*;

class file implements Runnable
	{
	Thread t;		
	FileInputStream fin;
	FileOutputStream fout;
	String name;
	int i;
	file(String tname)
		{
		name=tname;
		t=new Thread(this,name);
		t.start();
		try
			{
				fin=new FileInputStream("test.txt");
				fout=new FileOutputStream("test1.txt");
			}
		catch(FileNotFoundException e)			
			{
				System.out.println(e);
				return;
			}
	   catch(ArrayIndexOutOfBoundsException e1)
            {
            return;
            }
		}	
	public void run()
		{
			System.out.println("Preparing for copy....");
			//Thread.sleep(1000);
			System.out.println("Please wait while copying....");
		   try
                {                        
                do
                        {
                        i=fin.read();
                        if(i!=-1)
                                fout.write(i);
                                Thread.sleep(500);
                        }while(i!=-1);
                }  
                	catch(InterruptedException e1)
				{
				}      
                catch(IOException e)
                {
                }     
			 
	catch(NullPointerException e2)
	{
	}           	                                                          
                System.out.println("1 file copied"); 
			/*	finally
				{
					fin.close();
					fout.close();
				}    */            	
		}			
	}

public class threadf 
	{
      
    public static void main(String[] args) 
    	{
    	file f=new file("Copy");
    	FileInputStream input;
    	FileOutputStream output;
    	int c;
    	
    	try	{
    		input=new FileInputStream("test.txt");
    		output=new FileOutputStream("test2.txt");
    		do	
	    		{
    			c=input.read();
    			if(Character.isUpperCase((char)c))	
    				c=Character.toLowerCase((char)c);
    			if(Character.isLowerCase((char)c))
    				c=Character.toUpperCase((char)c);
				output.write((char)c);
    			}while(c!=-1);
    	
    		
    		Thread.sleep(1000);
	  		}
	
		catch(FileNotFoundException e2)	  		
			{
				return;
			}	
			catch(IOException e4)
			{
			}				
		catch(ArrayIndexOutOfBoundsException e3)				
			{
				return;
			}
		catch(InterruptedException e1)
			{
			}     		
	/*	finally
			{
				input.close();
				output.close();
			}	*/	
    	}
}
