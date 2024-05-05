package v5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client2 {

    public static void main(String[] args) throws IOException {

        System.out.println("connecting to the v5.server");
        Socket socket = new Socket("localhost", 5555);
        System.out.println("Connected to the v5.server");

//send data from the v5.client to the v5.server

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        Scanner scanner = new Scanner(System.in);
        String message ="";

        while (!message.equals("stop")) {
            message = scanner.nextLine();
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();

            String serverMessage = dataInputStream.readUTF();
            System.out.println("Server says:" + serverMessage);
        }

        // as a best practice use flush to close the stream
        // as a best practice close the socket as well

        dataOutputStream.close();
        socket.close();


    }
}
