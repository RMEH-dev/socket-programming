package v4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException {

        //Socket -> ip + port
        // 1 port -> 1 process only

        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("listening for v4.client connection on port 5555");
        Socket socket = serverSocket.accept();

        System.out.println("Client connected");

        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        Scanner scanner = new Scanner(System.in);

        String message = "";
        while (!message.equals("stop")){
            message = dataInputStream.readUTF();
            System.out.println("v4.client says: " + message);

            //send a message to the client

            String message2 = scanner.nextLine();
                dataOutputStream.writeUTF(message2);
                dataOutputStream.flush();
        }
       serverSocket.close();
    }
}