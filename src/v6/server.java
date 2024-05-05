package v6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException {

        //Socket -> ip + port
        // 1 port -> 1 process only

        ServerSocket serverSocket = new ServerSocket(5555);
        int clientCount =0;

        while(clientCount < 5){
            System.out.println("listening for v6.client connection on port 5555");
            Socket socket = serverSocket.accept();

            serverClientThread serverClientThread = new serverClientThread(socket, clientCount);
            serverClientThread.start();

            clientCount++;
        }
       serverSocket.close();
    }
}