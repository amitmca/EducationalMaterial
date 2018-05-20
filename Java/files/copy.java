                        import java.io.*;
class copy
        {
        public static void main(String args[])throws IOException
                {
                int i;
                FileInputStream fin;
                FileOutputStream fout;
                try
                        {
                        fin=new FileInputStream(args[0]);
                        fout=new FileOutputStream(args[1]);
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
                try
                {                        
                do
                        {
                        i=fin.read();
                        if(i!=-1)
                                fout.write(i);
                        }while(i!=-1);
                }     
                catch(IOException e)
                {
                }                                                               
                System.out.println("1 file copied");     
                                                    
                fin.close();
                fout.close();                                                                                 
                }
        }
