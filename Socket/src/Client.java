import java.io.*;
import java.net.*;

public class Client {
	private Socket socketClient = null;
	private InputStream inputClient = null;
	private OutputStream outputClient = null;
	private BufferedReader reader;
	private String readLine= "";
	private String text = "";
	
	private void sendMessagetoServer() {
		PrintWriter writer = new PrintWriter(outputClient, true);
		Console console = System.console();
		while(!text.equals("exit")) {
			try {
				text = console.readLine("Enter text: ");
	            writer.println(text);
				readLine=reader.readLine();
				System.out.println(readLine);
			}
			catch(IOException e){
				System.out.println(e);
			}
		}
	}
	public void closeConection() {
		try {
			inputClient.close();
			outputClient.close();
			socketClient.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
		
	}
	public Client(String adress, int port) {
		try {
			socketClient= new Socket(adress,port);
			System.out.println("Connected");
			inputClient = socketClient.getInputStream();
			outputClient = socketClient.getOutputStream();
            reader = new BufferedReader(new InputStreamReader(inputClient));
			outputClient = new DataOutputStream(
		                socketClient.getOutputStream());
		} 
		catch (UnknownHostException e) {
	            System.out.println(e);
	            return;
	     }
	    catch (IOException e) {
	            System.out.println(e);
	            return;
	    }
		sendMessagetoServer();
		closeConection();
	}
	public static void main(String[] args) {
		Client localclient = new Client("127.0.0.1", 5000);
	}

}
