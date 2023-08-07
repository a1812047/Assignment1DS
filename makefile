
all: Calculator.class CalculatorImplementation.class CalculatorClient.class CalculatorServer.class
Calculator.class: Calculator.java
	javac Calculator.java
CalculatorImplementation.class: CalculatorImplementation.java Calculator.java
	javac CalculatorImplementation.java Calculator.java
CalculatorClient.class: Calculator.java CalculatorImplementation.java CalculatorClient.java
	javac CalculatorClient.java Calculator.java
CalculatorServer.class: Calculator.java CalculatorImplementation.java CalculatorServer.java
	javac CalculatorServer.java Calculator.java CalculatorImplementation.java

run:
	rmiregistry &
	java CalculatorServer &
	java CalculatorClient 2 3 min &
	java CalculatorClient 1 1 max &

