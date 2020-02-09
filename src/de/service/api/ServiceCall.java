package de.service.api;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServiceCall extends Thread {
    private String Message  ="";
    final Socket socket;
    public ServiceCall(int port) throws IOException {
        socket = new Socket("localhost", port);

    }

    public String getMessage() {
        return Message;
    }


    private void reload(){
        try {
            Scanner sc = new Scanner(socket.getInputStream());
            while (sc.hasNextLine()){
                Message += sc.nextLine() + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
