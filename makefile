all:
	javac *.java
	jar cvfe CCScriptWriter.jar CCScriptWriter *
	rm *.class
	
dev:
	javac *.java
	jar cvfe CCScriptWriter.jar CCScriptWriter *