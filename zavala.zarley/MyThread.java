import java.io.*;
import java.lang.*;
import java.util.Scanner;
import animal.carnivore.*;
import animal.herbivore.*;
import animal.*;
import java.util.ArrayList;

class MyThread implements Runnable {

	public String threadName;
	private String filePathWithName;
	private ArrayList<Animal> animalList = new ArrayList<Animal>();
	Thread thrd;

	public MyThread(String threadName, String fileName) {
		thrd = new Thread(this, threadName);
		filePathWithName = fileName;
	}

	public static MyThread createAndStart(String threadName, String filePathWithName) {
		MyThread myThrd = new MyThread(threadName, filePathWithName);

	myThrd.thrd.start();
	return myThrd;
	}

	public void run() {
		int numOfLions;
		int numOfGiraffes;
		String ani;
		System.out.println("How many Giraffes?");
	    
		Scanner input = new Scanner(System.in);
		numOfGiraffes = input.nextInt();
		
		System.out.println("How many Lions?");
		numOfLions = input.nextInt();

		try(BufferedReader bookworm = new BufferedReader(new FileReader("C:\\Users\\Zarley\\Desktop\\Java Workspace\\CIS-18B\\zavala.zarley\\names.txt"))) {
			for(int i = 0; i < numOfGiraffes; i++) {
				ani = bookworm.readLine();
				animalList.add(new Giraffe(ani));
			}			
		}
		catch(IOException exc) {
			System.out.println("I/O Error: " + exc);
		}			
		
		try(BufferedReader bookworm = new BufferedReader(new FileReader("C:\\Users\\Zarley\\Desktop\\Java Workspace\\CIS-18B\\zavala.zarley\\names.txt"))) {
			for(int i = 0; i < numOfLions; i++) {
				ani = bookworm.readLine();
				animalList.add(new Lion(ani));
			}			
		}
		catch(IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
		
		animalList.trimToSize();

		try(FileWriter journalist = new FileWriter(filePathWithName)) {
			for(Animal thisAnimal : animalList) {
    				journalist.write(thisAnimal.getName() + " is a " + thisAnimal.getType() + "\n");
			}
		}
		catch(IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
	}

}