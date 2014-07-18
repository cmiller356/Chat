/*****************************
        Author: Christian Miller
        Date: 4/10/2014
        Program Specifications: Chat Server and Client similar to previous programming assignment, except that it is multithreaded accepting any amount of inputs from
        both the client and server without having to stop and wait for a reply.
*****************************/

import java.io.*;
import java.net.*;

public class chatClient{
        public static void main(String argv[]) throws Exception{
                System.out.println("Connecting client to server...");
                Socket clientSocket = new Socket("10.0.65.10", 40356);
                System.out.println("Client has connected to server...");

                FlagObject clientFlag = new FlagObject();
                SocketListener socket = new SocketListener(clientSocket, clientFlag);
                KeyboardListener key = new KeyboardListener(clientSocket, clientFlag);

                socket.start();
                key.start();

                socket.join();
                key.join();

                clientSocket.close();
        }//main
}//chatClient
