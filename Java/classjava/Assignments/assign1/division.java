import java.io.*;

class myaexception extends ArithmeticException
        {
        myaexception(String s)
        	{
        		System.out.println(s);
        	}
        }  

class division
        {
        public static void main(String args[])throws IOException
                {
                try
                        {
                        DataInputStream dis=new DataInputStream(System.in);
                        System.out.println("\n Enter First Number:");
                        int a=Integer.parseInt(dis.readLine());
                        System.out.println("\n Enter Second Number:");
                        int b=Integer.parseInt(dis.readLine());
                        if(b==0)
                                throw new myaexception("Arimetic Exception Caught"); 
                        else
                                {
                                int c=a/b;
                                System.out.println("\n Division is:"+c);
                                }
                        }
                catch(myaexception e)
                        {
                        
                        }                                         
                }        
        }