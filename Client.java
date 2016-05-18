package chat_system;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Client {
	PrintWriter out;
	BufferedReader in;
	ClientApp clientApp;
	
	public Client() throws Exception {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				clientApp = new ClientApp(Client.this);
			}
		});
		
		String host = "192.168.1.5";
		int port = 8080;
		
		Socket sock = new Socket(host, port);
		
		out= new PrintWriter(new OutputStreamWriter(sock.getOutputStream()), true);
		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		
		while (true) {
			//poruka sa servera
			String msg = in.readLine();
			clientApp.printMessage(msg);
		}
	}
	
	public void sendMessage(String msg) {
		//poruka ka serveru
		out.println(msg);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Client();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
