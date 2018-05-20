import java.io.*;

class FileDemo
	{
	static void p(String s)
		{
		System.out.println(s);
		}
	public static void main(String args[])
		{
		File f1=new File("/lib");
		File f2=new File("/mnt/D:/Programs/Java/io/myfile.txt");
		boolean r=f2.delete();
		if(r==true)
			System.out.println("Ok");
		else
			System.out.println("Not Ok");
		p("File Name:"+f1.getName());
		p("Path:"+f1.getPath());
		p("Absolute Path:"+f1.getAbsolutePath());
		p("Parent:"+f1.getParent());
		p(f1.canWrite() ? " is writable ": "is not writable");
		p(f1.canRead() ? " is Readable ": "is not Readable");
		p("is "+(f1.isDirectory() ? "Directory ": " not" +" a directory"));
		p(f1.isFile() ? "is normal file" : " might be a named pipe");
		p(f1.isAbsolute() ? "is Absolute":"is not absolute");
		p("File Last Modified:"+f1.lastModified());
		p("File Size:"+f1.length() + "Bytes");
		}
	}
