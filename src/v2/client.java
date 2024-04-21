package v2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class client {

    public static void main(String[] args) throws IOException {

System.out.println("connecting to the v2.server");
Socket socket = new Socket("localhost", 5555);
System.out.println("Connected to the v2.server");

//send data from the v2.client to the v2.server

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);


        dataOutputStream.writeUTF("Hello server.");
        dataOutputStream.flush();
        // as a best practice use flush to close the stream
        // as a best practice close the socket as well

        dataOutputStream.writeUTF("How are you doing");
        dataOutputStream.flush();

        dataOutputStream.writeUTF("When are you visiting");
        dataOutputStream.flush();

        dataOutputStream.writeUTF("stop");
        dataOutputStream.flush();

        dataOutputStream.close();
        socket.close();


    }
}
