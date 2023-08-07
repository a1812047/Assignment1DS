

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;


public class CalculatorClient {
    public int num =  0;

    public static void main(String [] args)  throws IOException{
        try{
            //get the registry from  the location predefined by the server
            Registry registry = LocateRegistry.getRegistry(2001);
            //now get the remote objectreference from the registry table made
            //available by the server. 
            Calculator stub = (Calculator) registry.lookup("calculator");
            
            
            ArrayList<Integer> list = new ArrayList<Integer>();
            Scanner fileIn = new  Scanner(new FileInputStream(args[0]));
            while(fileIn.hasNext()){
                String s = fileIn.next();
                
                if(s.equals("min") || s.equals("max") || s.equals("lcm") || s.equals("gcd")){
                    
                    int response = stub.calculate(list,s);
                    System.out.println(response);
                    list.clear();
                }else{
                    list.add(Integer.parseInt(s));
                }
                
            }
            fileIn.close();
        }catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
         }
        //finally{
        //     System.out.println("Your session has ended");
        // }
    }
}
