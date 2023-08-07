package Assignment1DS;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Stack;

public interface  Calculator extends Remote{
    public Stack<Integer> myStack = new Stack<Integer>();
    public void pushValue(int val) throws RemoteException;
    public void pushOperation(String operator) throws RemoteException;
    public int pop() throws RemoteException;
    public boolean isEmpty() throws RemoteException;
    public int delayPop(int millis) throws RemoteException;
    public int getValue() throws RemoteException;
}