//Practice Exam 1
public static void main(String[] args){

}
/*
	1a: Instantiation is the creation of the instance of an object from its class
		the constructor class is used. Java creates a pointer to space in
		memory allocated for the new object and its attributes
	1b: Bytecode is the really low-level, hardly readable code that java compiles
		into (as a javac file).
	1c: Encapsulation: A practice in object oriented programming where each object
		takes care of its own data. This is what public and private are for: it 
		avoids confusing calls and memory issues across different objects
	1d: Compiler: A program that converts java written code into bytecode, checking
		for errors along the way
	1e: Method signature: the name of the method. The part used in the declaration
		minus the type and encapsulation keywords
*/

/*
	2a: -51.0
	b: -4
	c: 24
	d: 3
	e: 1
	f: 2.0
*/

	public class StringFun(String str1){
		int lastChar = str1.length() -1;
		System.out.println(str1,charAt(0));
		System.out.println(str1,charAt(lastChar));
	}
/*
	4: The code has a compilation error because of line 5, where val
	is assigned to an int added to a double. This is an issue becuase
	double is more precise than float, so this is a narrowing
	conversion that won't be accepted by Python.
*/
/*
	import java.util.Random
	Random magnitude = new Random;
	5a: int i = 10*(magnitude.nextInt(2)+1);
	5b: int j = 0.3+magnitude.nextFloat(1.0)*0.10;
*/
/*
	6:
*/