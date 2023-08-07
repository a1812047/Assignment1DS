/*Author: Vishal Agarwal, a1812047, The University of Adelaide.
 * 
 * 
 * CalculatorImplementation is the class that essentially implements the Calculator interface.
 * This is done to hide away the implementation of the interface from the client
 * and to not give away the code for security reasons. This also helps save a lot of space and 
 * distributes the computing power and resources. 
 * 
 */


import java.util.ArrayList;


public class CalculatorImplementation implements Calculator{
    
    //the method calculates the function like "min", "max","gcd", "lcm" of all the numbers in the array list.
    public synchronized int calculate(ArrayList<Integer> list, String function){
        
        for(int i =0; i < list.size(); i++){
            myStack.push(list.get(i));
        }
        pushOperation(function);
        return  getValue();
    }
    
    //the method simply returns the top value from the stack myStack.
    public int getValue(){
        return myStack.peek();
    }

    //this  method calculates the minimum from all the numbers in the stack and returns that number. 
    private int min(){
        //answer is first initialised to the maximum value it can take. 
        //and then stores the minimum  of itself and the current value at the top of the stack.
        //while poping all  the values  from the stack
        int answer = Integer.MAX_VALUE;
        while(isEmpty() == false){
            answer = Math.min(answer,pop());
        }
        return answer;
    }

    //the method max , calculates the maximum value of all the numbers on the stack and returns that number
    private int max(){
        //answer is first initialised to the minimum value an Integer  or  an int can take. 
        //and then stores the max of itself and the current value at the top of the stack.
        //while poping all  the values  from the stack
        int answer = Integer.MIN_VALUE;
        while(isEmpty() == false){
            answer = Math.max(answer,pop());
        }
        return answer;
    }

    //gcd method calculates the greatest of the two numbers a and b
    private int gcd(int a, int b){
       //recursive calls are made to the method gcd(a,b)
       //Base case being: 
            //1. if b is 1 return a
            //2. if the  remainder of a and b is 0 returns the minimum(a,b) or simply b.

            //This idea  is an algorithm called  Euclidean gcd  algorithm.    
        if(a<b){
            return gcd(b,a);
        }
        if(b == 1){
            return a;
        }
        if(a%b == 0){
            return Math.min(a,b);
        }
        
        return gcd(b, a-b);
    }

    //stackGCD calculates the gcd of all the numbers on the stack while popping them off and 
    // returns the final answer. 
    private int stackGCD(){
        //answer is initialised to the identity and then while  there are  numbers on the stack  
        //calculate  the gcd of  answer and this top value on the stack and store it in answer
        //finally return answer. 
        int answer = 1;
        while(isEmpty() == false){
            
           answer = gcd(myStack.pop(), answer);
        }

        return answer;
    }

    // stackLCM calculates the lcm of all the numbers from the stack and returns it to  the user.
    private int stackLCM(){
        //lcm is inititalised to the identity and then while there  is a number on the top of the stack 
        //pops of this number and uses it to calculate the lcm using the formula:
        //  lcm = a*b/gcd(a,b). 
        //The algorithm has  a= lcm and b = the stack's top value.
        int lcm = 1;
        while(isEmpty() == false){
            lcm = (myStack.peek()*lcm)/gcd(myStack.pop(),lcm);
        }
        return lcm;
    }

    //simply pushes the value on to the  stack
    public synchronized void pushValue(int val){
        myStack.push(val);
    }

    //pushOperation recognises the operator namely : min, max, gcd, lcm and pushes the 
    //value returned  to it on the top  of the stack, myStack.
    public synchronized void pushOperation(String operator){
        if(operator.equals("min")){
            pushValue(min());
        }else if(operator.equals("max")){
            pushValue(max());
        }else if(operator.equals("gcd")){
            pushValue(stackGCD());
        }else if(operator.equals("lcm")){
            pushValue(stackLCM());
        }
    }

    //pop pops off the current value on the top of the stack, myStack
    public int pop(){
        return myStack.pop();
    }

    //returns true if myStack is empty, else returns false
    public boolean isEmpty(){
        return myStack.empty();
    }

    //this function simply delays the pop by millis milliseconds. 
    public int delayPop(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pop();
    }

    
}
