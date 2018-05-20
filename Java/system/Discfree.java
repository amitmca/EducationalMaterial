import java.io.*;

public class Discfree {

public static void main (String [] args) throws IOException {

        String [] Command = null;

        if (System.getProperty("os.name").equals("Linux")) {
                Command = new String[1];
                Command[0] = "df";
                }
        if (System.getProperty("os.name").equals("Solaris")) {
                Command = new String[2];
                Command[0] = "df";
                Command[1] = "-k";
                }
        if (Command == null) {
                System.out.println("Can't find free space on this OS");
                System.exit(1);
                }

        Process Findspace = Runtime.getRuntime().exec(Command);

        BufferedReader Resultset = new BufferedReader(
                        new InputStreamReader (
                        Findspace.getInputStream()));

        String line;
        while ((line = Resultset.readLine()) != null) {
                System.out.println(line);
                }
        }
} 