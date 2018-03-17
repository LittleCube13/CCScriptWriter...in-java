all:
	javac CCScriptWriter.java
	cd JOING && make dev

clean:
	rm *.class
