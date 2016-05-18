package chat_system;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
	
	private Server server;
	private Socket clSock;
	
	PrintWriter out;
	BufferedReader in;
	
	public ServerThread(Server server, Socket clSock) {
		this.server = server;
		this.clSock = clSock;
	}

	@Override
	public void run() {
		try {
			out = new PrintWriter(new OutputStreamWriter(clSock.getOutputStream()), true);
			in = new BufferedReader(new InputStreamReader(clSock.getInputStream()));
			
			//log-in i registracia
			/*
			boolean logged = false;
			while (!logged) {
				String type = in.readLine();
				String username = in.readLine();
				String 
			}
			*/
			while (true) {
				//poruka od klijenta
				String msg = in.readLine();
				server.sendAll(msg);
			}
			//clSock.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String msg) {
		//poruka ka klijentu
		out.println(msg);
	}

}
