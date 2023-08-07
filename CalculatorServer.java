package Assignment1DS;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer {
    public static void main(String[] args){
        try {
            CalculatorImplementation  obj = new CalculatorImplementation();
            Calculator  skeleton = (Calculator) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(2001);
            registry.rebind("calculator", skeleton);
            System.out.println("Calculator is ready! ! ! ");
        } catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }
    }
    
}
