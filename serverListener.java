/*****************************
        Author: Christian Miller
        Date: 4/10/2014
        Program Specifications: Chat Server and Client similar to previous programming assignment, except that it is multithreaded accepting any amount of inputs from
        both the client and server without having to stop and wait for a reply.
*****************************/


import java.io.*;
import java.net.*;

public class serverListener extends Thread{
	private Socket socket;
	private FlagObject flag;

	public serverListener(Socket s, FlagObject f){
		this.socket = s;
		this.flag = f;
	}//SocketListener

	public void run(){
		try{
			String serverInput;
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			do{
				//System.out.println("Server: ");
				serverInput = inFromServer.readLine();
				//System.out.println(serverInput);
				chatServer.send(serverInput);
			}while(!serverInput.equalsIgnoreCase("exitexit") && flag.getFlag());

			flag.setFalse();
		} catch(Exception e){}
	}//run
}//SocketListener
