import java.io.*;
class fileswap
        {
        public static void main(String args[])throws IOException
                {
                int i,j,k;
                RandomAccessFile raf,raf1,temp;
		
		
                try
                        {
                        raf=new RandomAccessFile(args[0],"rw");
			raf1=new RandomAccessFile(args[1],"rw");
			temp=new RandomAccessFile("temp.txt","rw");
			do
				{
				i=raf.read();
				if(i!=-1)
					temp.write(i);
				}while(i!=-1);
			do
				{
				j=raf1.read();
				if(j!=-1)
					raf.write(j);
				}while(j!=-1);

			do
				{
				k=temp.read();
				if(k!=-1)
					raf1.write(k);
				}while(k!=-1);
			
//			temp.delete();
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
