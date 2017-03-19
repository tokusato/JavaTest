package design.decorator;

public class DecoratorMain {

	public static void main(String[] args) {
		HumbergerMenu hm = new Humberger();
		System.out.println(hm.getCost());//150

		//Create Cheese Burger
		hm = new Cheese(hm);
		System.out.println(hm.getCost());//180

	}

}
