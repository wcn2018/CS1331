//9.7.1 CHECK ANSWERS
	
	System.out.println(f.i); is fine, 
	System.out.println(f.s); is also fine, printing data of f is fine
	f.imethod(); is fine, it calls a nonstaric method, with ref to an instance
	System.out.println
	f.smethod(); NOT OKAY
	*/

//9.7.2:
	public static void main(String[] args) {
		//main requires static
		public int getCount(){
		// a getter should never have static: it requires an instance to do its job
		}
		
		public static int factorial(int n){
			//Requires static because factorial should only take one input,
			//which is not part of an instance but just a plain arg
			int result = 1;
			for (int i = 1, i <=n, i++){
				result *= 1;
			return result;
			}
		}
	}

//9.7.3: Check this oen
	/*
	You cannot invoke instance methods or data from a static method
	, but you can reference static data/methods from instance method.

	what's wrong with code: 
		- method1 is an instace method being invoked as static. method1
		should really be a static method.
	*/

//9.9.1:
/*
	accessor method: This is basically a getter
	mutator method: This is basically a stter
*/

//9.9.2:
/*
	encapsulation is valuable because it encourages data safety. 
*/

//9.9.3:
/*
Yes the code causes issues because the System.out.println method attempts
to access a private variable of myCircle
*/
//CHECK ALL OF 9.9

//9.10.3: CHECK ANSWER
/*
a: a[0] = 2 a[1] = 1
b: same as a
c: same as a,b
d: no idea

//9.10.4:

*/