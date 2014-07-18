
/*****************************
        Author: Christian Miller
        Date: 4/10/2014
        Program Specifications: Chat Server and Client similar to previous programming assignment, except that it is multithreaded accepting any amount of inputs from
        both the client and server without having to stop and wait for a reply.
*****************************/

import java.io.*;
import java.net.*;
import java.util.*;

public class chatServer{    
	private static LinkedList<serverListener> clients = new LinkedList<serverListener>();
	private static ListIterator<serverListener> iterator = clients.listIterator();
	
    public static void main(String argv[]) throws Exception{
			ServerSocket serverSocket = new ServerSocket(40356);
			System.out.println("Server is waiting for client to connect...");
			Socket clientSocket = serverSocket.accept();
			System.out.println("Client has connected...");

			FlagObject serverFlag = new FlagObject();
			SocketListener socket = new SocketListener(clientSocket, serverFlag);
			KeyboardListener key = new KeyboardListener(clientSocket, serverFlag);
			socket.start();
			key.start();
			while(true){
				Socket clientsSocket = serverSocket.accept();
				System.out.println("Client has connected...");
				BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientsSocket.getInputStream()));
				DataOutputStream outToChat = new DataOutputStream(clientsSocket.getOutputStream());
				serverListener server = new serverListener(inFromServer, outToChat);
				server.start();
				clients.addLast(server);				
			}
			
			clientSocket.close();
			serverSocket.close();
        }//main
		
		public static synchronized void send(String message){
			for(int i = 0; i < clients.size; i++){
				try{
					clients.get(i).getOutputStream().writeBytes(message + '\n');
				} catch (IOException e){
					System.out.println(e);
				}//try catch
			}//for
		}//send
		
		public static void removeClient(DataOutputStream dos){
			while(iterator.hasNext()){
				if(iterator.hasNext() == dos){
					
				}//
			}//
		}//
}//chatServer
