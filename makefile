all:
	javac CCScriptWriter.java
	cd JOING && make nojar

clean:
	rm *.class || continue
	rm ./JOING/*.class || continue
