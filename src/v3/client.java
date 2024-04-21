package v3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {

    public static void main(String[] args) throws IOException {

System.out.println("connecting to the v3.server");
Socket socket = new Socket("localhost", 5555);
System.out.println("Connected to the v3.server");

//send data from the v3.client to the v3.server

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);


        Scanner scanner = new Scanner(System.in);
        String message ="";

            while (!message.equals("stop")) {
                    message = scanner.nextLine();
                    dataOutputStream.writeUTF(message);
                    dataOutputStream.flush();
            }

            // as a best practice use flush to close the stream
        // as a best practice close the socket as well

        dataOutputStream.close();
        socket.close();


    }
}
