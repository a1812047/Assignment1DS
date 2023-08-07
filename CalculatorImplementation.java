package Assignment1DS;


public class CalculatorImplementation implements Calculator{
    public int getValue(){
        return myStack.peek();
    }
    private int min(){
        try{Thread.sleep(30*1000);}catch(Exception e){System.out.println("there was  an  error in min function");}
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
        if(a%b == 0){
            return Math.min(a,b);
        }
        if(a == 1 || b == 1){
            return Math.max(a,b);
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
