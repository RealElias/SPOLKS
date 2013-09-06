import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String args[]) {

		ServerSocket echoServer = null;
		Socket clientSocket = null;

		BufferedReader inputStream;
		PrintStream outputStream;

		try {
			echoServer = new ServerSocket(228);
		}
		catch (IOException e) {
			System.out.println("We have a problem: " + e);
		} 

		try {
			clientSocket = echoServer.accept();
			inputStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			outputStream = new PrintStream(clientSocket.getOutputStream());

			String message;
			while (true) {
				message = inputStream.readLine();
				outputStream.println(message); 
			}
		} 
		catch (IOException e) {
			System.out.println("We have a problem: " + e);
		}
	}
}
