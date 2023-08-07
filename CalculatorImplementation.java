import java.util.ArrayList;


public class CalculatorImplementation implements Calculator{
    // public static void main(String [] args){
    //     CalculatorImplementation A = new CalculatorImplementation() ;
    //     ArrayList<Integer> list =  new ArrayList<Integer>();
    //     list.add(10);
    //     list.add(20);
    //     int answer = A.calculate(list, "gcd");
    //     System.out.println(answer);
    // }
    public synchronized int calculate(ArrayList<Integer> list, String function){
        
        for(int i =0; i < list.size(); i++){
            myStack.push(list.get(i));
        }
        pushOperation(function);
        return  getValue();
    }
    
    public int getValue(){
        return myStack.peek();
    }
    private int min(){
        //try{Thread.sleep(30*1000);}catch(Exception e){System.out.println("there was  an  error in min function");}
        int answer = Integer.MAX_VALUE;
        while(isEmpty() == false){
            answer = Math.min(answer,pop());
        }
        return answer;
    }
    private int max(){
        int answer = Integer.MIN_VALUE;
        while(isEmpty() == false){
            answer = Math.max(answer,pop());
        }
        return answer;
    }
    private int gcd(int a, int b){
       
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
    private int stackGCD(){
        int answer = 1;
        while(isEmpty() == false){
            
           answer = gcd(myStack.pop(), answer);
        }

        return answer;
    }
    private int stackLCM(){
        int lcm = 1;
        while(isEmpty() == false){
            lcm = (myStack.peek()*lcm)/gcd(myStack.pop(),lcm);
        }
        return lcm;
    }
    public synchronized void pushValue(int val){
        myStack.push(val);
    }
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
    public int pop(){
        return myStack.pop();
    }
    public boolean isEmpty(){
        return myStack.empty();
    }
    public int delayPop(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pop();
    }

    
}
