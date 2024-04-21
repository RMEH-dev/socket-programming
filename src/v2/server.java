package v2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {

        //Socket -> ip + port
        // 1 port -> 1 process only

        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("listening for v1.client connection on port 5555");
        Socket socket = serverSocket.accept();

        System.out.println("Client connected");

        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String message = dataInputStream.readUTF();

        System.out.println("v1.client says " + message);


    }
}