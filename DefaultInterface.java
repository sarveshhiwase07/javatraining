interface Shape{
	default void print(int x,int y) {
		System.out.println("I'm a shape with dimensions " + x + " " + y);
	}

	void print();

}

class Rectangle implements Shape{
	int x,y;

	public Rectangle(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Rectangle [x=" + x + ", y=" + y + "]";
	}
	@Override
	public void print() {
		Shape.super.print(x, y);
	}
}

public class DefaultInterface {
	public static void main(String[] args) {
		Rectangle r = new Rectangle(1,2);
		r.print();
	}
}
