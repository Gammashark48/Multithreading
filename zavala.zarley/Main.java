import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import animal.carnivore.*;
import animal.herbivore.*;
import animal.*;

public class Main {
	public static void main(String[] args) {

		MyThread mt1 = MyThread.createAndStart("Child #1", "C:\\Users\\Zarley\\Desktop\\Java Workspace\\CIS-18B\\zavala.zarley\\output1.txt");
		MyThread mt2 = MyThread.createAndStart("Child #2", "C:\\Users\\Zarley\\Desktop\\Java Workspace\\CIS-18B\\zavala.zarley\\output2.txt");

		try {
			mt1.thrd.join();
			System.out.println("Child #1 joined.");
			mt2.thrd.join();
			System.out.println("Child #2 joined.");
		}
		catch(InterruptedException exc) {
			System.out.println("Main thread interrupted.");
		}
	}
}