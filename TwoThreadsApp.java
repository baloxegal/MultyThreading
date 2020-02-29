package main;

public class TwoThreadsApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Plate commonPlate = new Plate(100);
		
		Cat Arnold = new Cat("Arnold", commonPlate);
		Dog Archibald = new Dog("Archibald", commonPlate);
		
		System.out.println("Start: " + commonPlate.food);
		Arnold.start();
		Archibald.start();
		Arnold.join();
		Archibald.join();
		System.out.println("End: " + commonPlate.food);
	}

}

class Cat extends Thread{
	private String name;
	private Plate plate; 

	public Cat(String name, Plate plate) {
		super();
		this.name = name;
		this.plate = plate;
	}
	public void eat(){
		while(plate.food > 0){
			System.out.println("Cat eating!");
			System.out.println(plate.food--);
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.eat();
		super.run();
	}
}

class Dog extends Thread{
	private String name;
	private Plate plate; 

	public Dog(String name, Plate plate) {
		super();
		this.name = name;
		this.plate = plate;
	}
	public void eat(){
		while(plate.food >= 2){
			System.out.println("Dog eating!");
			System.out.println(plate.food -=2);
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.eat();
		super.run();
	}
}

class Plate{
	public int food;

	public Plate(int food) {
		super();
		this.food = food;
	}
	
}