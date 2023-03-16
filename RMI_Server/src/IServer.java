import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
	
	/**
	 * Suma de dos números
	 * @param op1
	 * @param op2
	 * @return 
	 * @throws RemoteException
	 */
	public double suma(double op1, double op2) throws RemoteException;
	
	/**
	 * Resta de dos números
	 * @param op1
	 * @param op2
	 * @return
	 * @throws RemoteException
	 */
	public double resta(double op1, double op2) throws RemoteException;
	
	/**
	 * Multiplicación de dos números
	 * @param op1
	 * @param op2
	 * @return
	 * @throws RemoteException
	 */
	public double producto(double op1, double op2) throws RemoteException;
	
	/**
	 * División de dos números
	 * @param op1
	 * @param op2
	 * @return
	 * @throws RemoteException
	 */
	public double division(double op1, double op2) throws RemoteException;

}
