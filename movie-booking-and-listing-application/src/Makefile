run: ../bin/
	cd .. && java -classpath build Main

../bin/:
	make build

build:
	javac -sourcepath ./ -d ../bin/ Main.java FillDatabaseMain.java TestDatabaseMain.java

clean:
	rm -rf ../bin/
