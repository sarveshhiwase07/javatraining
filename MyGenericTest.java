public class MyGenericTest {
	public static void main(String[] args) {
		AnyValues<String> av1 = new AnyValues<String>("Sarvesh", "Amol");
		AnyValues<Character> av2 = new AnyValues<Character>('S', 'D');
		AnyValues<Integer> av3 = new AnyValues<Integer>(45, 67);
		AnyValues<Double> av4 = new AnyValues<Double>(45.6579,8971.464);
		AnyValues<Float> av5 = new AnyValues<Float>(894.4f,466.89f);
		av1.print();
		av1.swap();
		av1.print();
		av2.print();
		av2.swap();
		av2.print();
		av3.print();
		av3.swap();
		av3.print();
		av4.print();
		av4.swap();
		av4.print();
		av5.print();
		av5.swap();
		av5.print();
	}
}

class AnyValues<T>{
	T x;
	T y;
	 
	public AnyValues(T x, T y) {
		super();
		this.x = x;
		this.y = y;
	}

	void print() {
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
	}
	
	void swap() {
		T temp;
		temp = x;
		x = y;
		y = temp;
		System.out.println("Values swapped succesfully...");
	}
}

/*
 * 
 * 
 * 										
 * 							1
 * 							/\
 * 						2 		3
 *                    / \     /\
 * 					 4   5  6  7
 * 	INORDER - LEFT ROOT RIGHT
 * 4 2 5 1 6 3 7
 * PREORDER - ROOT LEFT RIGHT
 * 1 2 4 5 3 6 7
 * POST ORDER - LEFT RIGHT ROOT
 * 4 5 2 6 7 3 1
 * */

