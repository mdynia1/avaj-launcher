find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java avaj.simulator.Main  testFile/*