
all: Calculator.class CalculatorImplementation.class CalculatorClient.class CalculatorServer.class runServer
Calculator.class: Calculator.java
	javac Calculator.java
CalculatorImplementation.class: CalculatorImplementation.java Calculator.java
	javac CalculatorImplementation.java Calculator.java
CalculatorClient.class: Calculator.java CalculatorImplementation.java CalculatorClient.java
	javac CalculatorClient.java Calculator.java
CalculatorServer.class: Calculator.java CalculatorImplementation.java CalculatorServer.java
	javac CalculatorServer.java Calculator.java CalculatorImplementation.java
runServer:
	rmiregistry &
	java CalculatorServer &
run_one_client:
	java CalculatorClient input.txt >output.txt

run_multiple_clients:
	java CalculatorClient input1.txt >output1.txt &
	java CalculatorClient input2.txt >output2.txt &
	java CalculatorClient input3.txt >output3.txt &
	java CalculatorClient input4.txt >output4.txt &

	
clean:
	rm -f *.class
