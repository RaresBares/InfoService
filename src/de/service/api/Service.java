package de.service.api;

import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class Service extends Thread {
        private final ServerSocket serverSocket;
    public Service(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public Service listen(){
        this.start();
        return this;
    }
    public abstract void onConnect(Socket t);

    @Override
    public void run() {
       while (true){
           try {
               Socket t = serverSocket.accept();
               if(t.getInetAddress().getHostAddress() == "127.0.0.1"){
                        onConnect(t);
               }else{
                   System.err.println("External Connection IP: " + t.getInetAddress().getHostAddress());
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }
}
