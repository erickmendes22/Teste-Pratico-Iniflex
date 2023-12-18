import java.io.*;
import java.net.*;

public class Server {
    private Socket socket   = null;
	private ServerSocket serverSocket = null;
	private InputStream inputClient = null;
	private OutputStream outputClient = null;

	private void readUserInput() {
		try {
			String readLine= "";
			outputClient = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(outputClient, true);
			while(!readLine.equals("exit")) {
					inputClient=socket.getInputStream();
					BufferedReader reader =new BufferedReader(new InputStreamReader(inputClient));
					readLine=reader.readLine();
					System.out.println(readLine);
					writer.println("Your message:"+readLine);
			}
		}
		catch(IOException e){
				System.out.println(e);
		}
   }
	
	public void closeConection() {
		try {
			serverSocket.close();
			inputClient.close();
			socket.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
		
	}
	
	public Server(int port) {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Server started");
			System.out.println("Waiting for a client");
			socket=serverSocket.accept();
			System.out.println("Client accepted");
			readUserInput();
			System.out.println("Closing conection with the client");
			closeConection();
		
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		Server localServer = new Server(5000);
	}
}
