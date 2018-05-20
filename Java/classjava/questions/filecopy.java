import java.io.*;
class filecopy
        {
        public static void main(String args[])throws IOException
                {
                int i;
                FileInputStream fin;
                FileOutputStream fout;
		DataInputStream dis=new DataInputStream(System.in);
                try
                        {
                        fin=new FileInputStream(args[0]);
                        fout=new FileOutputStream(args[1]);
			String decision="";
			System.out.println("\n Do you want to copy the file(yes/no)?  ");
			decision=dis.readLine();
		
			if(decision.equals("yes"))
				{
				do
        	              	  {
                	          i=fin.read();
                        	  if(i!=-1)
	                               fout.write(i);
        	                  }while(i!=-1);
				System.out.println("1 file copied");     
		                fin.close();
		                fout.close();                                                                                 
                		}     
			else
				{
				System.out.println("File copied cancelled......");     
				}
                        }
                catch(FileNotFoundException e)
                        {
                        System.out.println("File Not Found");
                        return;
                        }

		catch(IOException e)
                	{
	                }                                                               
                     
                catch(ArrayIndexOutOfBoundsException e1)
                        {
                        return;
                        }
                
                                               
    
                }
        }
