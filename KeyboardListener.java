/*****************************
	Author: Christian Miller
	Date: 4/10/2014
	Program Specifications: Chat Server and Client similar to previous programming assignment, except that it is multithreaded accepting any amount of inputs from
	both the client and server without having to stop and wait for a reply.
*****************************/


import java.io.*;
import java.net.*;

public class KeyboardListener extends Thread{
	private Socket socket;
	private FlagObject flag;
	public String name;
	
	public KeyboardListener(Socket s, FlagObject f, String username){
			this.socket = s;
			this.flag = f;
			this.name = username;
	}//keyboardListener


	public void run(){
			try{
					String clientInput;
					BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
					DataOutputStream outToChat = new DataOutputStream(socket.getOutputStream());
					System.out.println("Chat initialized");
					do{
							//System.out.println("Client: ");
							clientInput = inFromUser.readLine();
							outToChat.writeBytes(username + ": " + clientInput + "\n");
					}while(!clientInput.equalsIgnoreCase("exitexit") && flag.getFlag());

					flag.setFalse();
					outToChat.writeBytes("exitexit\n");
			}catch(Exception e){}
	}//run
}

