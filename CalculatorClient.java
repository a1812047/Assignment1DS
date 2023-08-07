package Assignment1DS;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class CalculatorClient {
    public int num =  0;

    public static void main(String [] args){
        try{
            //get the registry from  the location predefined by the server
            Registry registry = LocateRegistry.getRegistry(2001);
            //now get the remote objectreference from the registry table made
            //available by the server. 
            Calculator stub = (Calculator) registry.lookup("calculator");
            
            int i = 0;
            while(i < args.length){
                System.out.println(args[i]);
                if(args[i].equals("min") || args[i].equals("max") || args[i].equals("lcm") || args[i].equals("gcd")){
                    
                    stub.pushOperation(args[i]);
                    System.out.print("this is the result of "+args[i]+": ");
                    // System.out.println(stub.pop());
                    System.out.println(stub.getValue());
                }else{
                    stub.pushValue(Integer.parseInt(args[i]));
                }
                i++;
            }
        }catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }finally{
            System.out.println("Your session has ended");
        }
    }
}
