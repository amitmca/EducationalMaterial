/*
        Project Done by t_prash1007@yahoo.com & msagar2005@yahoo.com
        for compressing files 
        Contsructors: 
            ZipDemo(FileInputStream,FileOutputStream)
            ZipDemo(ByteArrayInputStream,FileOutputStream)
            ZipDemo(ByteArrayInputStream,ByteArrayOutputStream)
            ZipDemo(BufferedInputStream,BufferedOutputStream)

        Member Variables:
                public boolean Verbose=false; // turn progress messages on/off

        Methods:
            ZipDemo_CompressStream()   // compress the attached stream
            ZipDemo_DeCompressStream() // decompress the attached stream   


*/


import java.io.*;

public class FileCompress 
{
	public static void main(String args[]) 
	{
		
        try{
            String option;
            ZipDemo c=null;

            if(args.length == 3)
            {
                option = args[0].toUpperCase();
                FileInputStream in   = new FileInputStream(args[1]);
                FileOutputStream out = new FileOutputStream(args[2]);
                c = new ZipDemo(in,out);
                c.Verbose = true;  
            }
            else  option   = ""; // invalid options passed

            if("C".equals(option))
                c.ZipDemo_CompressStream();
            else if("D".equals(option))
                c.ZipDemo_DeCompressStream();
            else
                System.out.println("Ussage : java MCSComp [c/d] infile outfile");
        }
        catch (Exception e)
        {
        	System.out.println ("Dangerous error: Requested File Not Found");
        }

	}
}