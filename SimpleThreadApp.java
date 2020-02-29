package main;

public class SimpleThreadApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Printer p1 = new Printer("Canon", 100);
		Printer p2 = new Printer("HP", 6);
		//p1.printForever();
		//p2.printForever();
		p1.start();
		p2.start();
		
		p1.join();
		p2.join();
		
		System.out.println("-----------------END!------------------");
	}

}

class Printer extends Thread{
	private String name;
	private int q;

	public Printer(String name, int q) {
		super();
		this.name = name;
		this.q = q;
	}
	
	public void printForever(){
		int n = 1;
		while(n <= q){
			System.out.println(name + ": " + n);
			n++;
		}
	}

	@Override
	public void run() {
		this.printForever();
		super.run();
	}
	
	
}