run: ../bin/ ../data/
	cd .. && java -classpath bin Main

../bin/:
	make build

../data/:
	make filldata
	
build:
	javac -sourcepath ./ -d ../bin/ Main.java FillDatabaseMain.java TestDatabaseMain.java

filldata: ../bin/
	cd .. && java -classpath bin FillDatabaseMain
	
clean:
	rm -rf ../bin/
