package chat_system;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	int port = 8080;
	int user_num = 0;
	ArrayList<ServerThread> serverThreadList = new ArrayList<>();
	
	public Server() throws IOException {
		ServerSocket sSock = new ServerSocket(port);
		
		while (true) {
			//cnt++;
			Socket clSock = sSock.accept();
			System.out.println(clSock.getInetAddress().getHostName() + " is connected");
			
			ServerThread st = new ServerThread(this, clSock);
			serverThreadList.add(st);
			Thread th = new Thread(st);
			th.start();
		}
	}
	
	public void sendAll(String msg) {
		for (ServerThread serverThread : serverThreadList) {
			serverThread.sendMessage(msg);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Server();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
