import java.io.*;

class file2
        {
        public static void main(String args[])throws IOException
                {
                FileInputStream fin,fin1;
                FileOutputStream fout,fout1;
                int i,j;
                try
                        {
                        fin=new FileInputStream(args[0]);
			fout1=new FileOutputStream(args[1]);
                        fin1=new FileInputStream(args[1]);
                        fout=new FileOutputStream(args[2]);
                        }
                catch(FileNotFoundException e)
                        {
                        System.out.println("File Cannot Opened");
                        return; 
                        }                
                catch(ArrayIndexOutOfBoundsException e1)
                        {
                        return;
                        }
                   
                                         
                try
                        {
                         do     
                                {
                                i=fin.read();
                                if(Character.isUpperCase((char)i))
                                     {   
                                     i=Character.toLowerCase((char)i);                      
                                     fout1.write(i);
                                     }
                                
                                 else
                                    { 
                                    if(Character.isLowerCase((char)i))
                                    i=Character.toUpperCase((char)i);
                                    fout1.write(i);
                                    }          
                                }while(i!=-1);
			  }  
                catch(IOException e2)
                        {
                        }
		System.out.println("1 File is Copied"); 
		 try
                        {
                        do
                                {
                                i=fin.read();
                                if(i!=-1)
                                         fout.write((char)i);
                                }while(i!=-1);
                         do
                                {
                                j=fin1.read();
                                if(j!=-1)
                                         fout.write((char)j);
                                }while(j!=-1);                                                  
                        }   
		catch(IOException e3)
                        {
                        } 
		System.out.println("1 File is Copied");
                                                                                               
                } 
        } 