import java.io.*;
class file1
        {
        public static void main(String args[])throws IOException
                {
                int i;
                FileInputStream fin;
                try
                        {
                        fin=new FileInputStream(args[0]);
                        }
                catch(FileNotFoundException e)
                        {
                        System.out.println("File Not Found");
                        return;
                        }      
                catch(ArrayIndexOutOfBoundsException e1)
                        {
                        return;
                        }
                do
                        {
                        i=fin.read();
                        if(i!=-1)
                                System.out.print((char)i);
                        }while(i!=-1);                    
                fin.close();                                                                                      
                }
        }