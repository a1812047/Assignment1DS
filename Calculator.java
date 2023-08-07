
/* Author: Vishal Agarwal, a1812047, The University of Adelaide.
 * 
 * The code below is an interface that is created for remote access
 * Remote is a class that abstracts away the communication between the client
 * and the server. A class that can interact from a  different computer. 
 * Calculator is the remote child of this class. 
 * 
 * 
 * Calculator has many functions listed below as the names suggest.
 * 
 * 
 */


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Stack;

public interface  Calculator extends Remote{
    
    //fields
    public Stack<Integer> myStack = new Stack<Integer>();
    
    //methods or functionalities
    public int calculate(ArrayList<Integer> list, String function) throws RemoteException;
    public void pushValue(int val) throws RemoteException;
    public void pushOperation(String operator) throws RemoteException;
    public int pop() throws RemoteException;
    public boolean isEmpty() throws RemoteException;
    public int delayPop(int millis) throws RemoteException;
    public int getValue() throws RemoteException;
}