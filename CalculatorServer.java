/*Author: Vishal Agarwal, a1812047, The University of Adelaide.
 * 
 * 
 * Together with the CalculatorServer and the  CalculatorImplementation the server is created
 * for clients to access the methods
 * 
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer {
    public static void main(String[] args){
        try {
            //Firstly, the object  is created and exported on a random port from where the communication
            //will happen.Port 0 indicates the object is ready  to communicate and to receive incoming calls 
            //via a random port chosen by RMI at runtime.
            CalculatorImplementation  obj = new CalculatorImplementation();
            Calculator  skeleton = (Calculator) UnicastRemoteObject.exportObject(obj, 0);

            //Secondly, the remote object is stored in the RMI registry at port 2001 and the information
            //about the skeleton is bind to this name : "calculator".
            Registry registry = LocateRegistry.createRegistry(2001);
            registry.rebind("calculator", skeleton);

            //Lastly, on success of the above two stub creation the system prints out "Calculator is ready on the terminal"
            System.out.println("Calculator is ready! ! ! ");
        } catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }
    }
    
}
