
public class GeometricDemo {

	public static void main(String[] args) {
		
		Circle aCircle = new Circle(4.0);
		aCircle.printCircle();		
		System.out.println("The area of the circle is: " + aCircle.getArea());
		System.out.println("The perimeter of the circle is: " + aCircle.getPerimeter());

		
		Rectangle tempRect = new Rectangle(2, 4);
		System.out.println("The area of the rect is: " + tempRect.getArea());
		System.out.println("The perimeter of the rect is: " + tempRect.getPerimeter());
	}
}
