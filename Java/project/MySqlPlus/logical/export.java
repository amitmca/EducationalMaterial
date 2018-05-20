import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.File; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 

public class export
{ 
public static void export()
{ 
String path="D:/Programs/Java/project/MySqlPlus/back.sql"; 
String dumpCommand = "mysqldump -u root -p amit12 MysqlPlus > " + path; 
File tst = new File(path); 
FileWriter fw = null; 
try{ 
fw = new FileWriter(tst); 
fw.close(); 
}catch(IOException ex){ 
ex.printStackTrace(); 
} 
Runtime rt = Runtime.getRuntime(); 
try { 
Process proc = rt.exec(dumpCommand); 
InputStream in = proc.getInputStream(); 
InputStreamReader read = new InputStreamReader(in,"latin1"); 
BufferedReader br = new BufferedReader(read); 
BufferedWriter bw = new BufferedWriter(new FileWriter(tst,true)); 
String line=null; 
StringBuffer buffer = new StringBuffer(); 
while((line=br.readLine())!=null){ 
buffer.append(line+"\n"); 
} 
String toWrite = buffer.toString(); 
bw.write(toWrite); 
bw.close(); 
br.close(); 
} catch (IOException e) { 
e.printStackTrace(); 
} 

} 
public static void main(String args[]){ 
export(); 
} 
} 
