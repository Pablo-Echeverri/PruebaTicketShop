import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements IServer {

	public Server() throws RemoteException {
		super();
	}


	@Override
	public double suma(double op1, double op2) throws RemoteException {
		return op1 + op2;
	}

	@Override
	public double resta(double op1, double op2) throws RemoteException {
		return op1 - op2;
	}

	@Override
	public double producto(double op1, double op2) throws RemoteException {
		return op1 * op2;
	}

	@Override
	public double division(double op1, double op2) throws RemoteException {
		return op1 / op2;
	}

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.createRegistry(7777);
			registry.rebind("calculadora", new Server());
			System.out.println("El servidor está en espera...");
		} catch (Exception e) {
			System.out.println("Error. El servidor no está en espera.");
		}

	}

}
