import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
	
	private static Scanner scan = null;
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		IServer serverAPI = null;
		
		try {
			Registry registry = LocateRegistry.getRegistry(7777);
			serverAPI = (IServer) registry.lookup("calculadora");
			
			scan = new Scanner(System.in);
			for (;;) {
				System.out.println("*********************");
				System.out.println(" RMI_App Calculadora ");
				System.out.println("*********************");
				System.out.println();
				System.out.println("Choose an option:");
				System.out.println("1 - Suma");
				System.out.println("2 - Resta");
				System.out.println("3 - Producto");
				System.out.println("4 - División");
				System.out.println("5 - Salir");
				
				int choice = getChoice();
				switch(choice) {
				case 1:
					System.out.println(serverAPI.suma(getInputOne(), getInputTwo()));
					break;
				case 2:
					System.out.println(serverAPI.resta(getInputOne(), getInputTwo()));
					break;
				case 3:
					System.out.println(serverAPI.producto(getInputOne(), getInputTwo()));
					break;
				case 4:
					System.out.println(serverAPI.division(getInputOne(), getInputTwo()));
					break;
				case 5:
					System.exit(0);
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error. El cliente 1 no se ha conectado al servidor");
			e.printStackTrace();
		}
		
	}
	
	public static int getChoice() {
		try {
			System.out.println("Elija una opción: ");
			int input = scan.nextInt();
			if (input < 1 || input > 5) throw new Exception();
			return input;
		} catch (Exception e) {
			System.err.println("Error. La opción debe ser entre 1 y 5.");
			return getChoice();
		}
	}
	
	public static double getInputOne() {
		try {
			System.out.println("Selecciona un número: ");
			double input = scan.nextDouble();
			return input;
		} catch (Exception e) {
			System.err.println("Error. Elija un número válido.");
			return getInputOne();
		}
	}
	
	public static double getInputTwo() {
		try {
			System.out.println("Selecciona un número: ");
			double input = scan.nextDouble();
			return input;
		} catch (Exception e) {
			System.err.println("Error. Elija un número válido.");
			return getInputTwo();
		}
	}

}
