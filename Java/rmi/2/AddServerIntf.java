import java.rmi.*;
import java.io.*;

public interface AddServerIntf extends Remote
	{
	int vowelcount()throws RemoteException,IOException;
	}
