package de.service.api;

import de.service.utils.Sets;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class Service extends Thread {
        private final ServerSocket serverSocket;
    public Service(int port, String name) throws IOException {
        serverSocket = new ServerSocket(port);
        setName(name);
        Sets.add(this);
        listen();
    }

    private Service listen(){
        this.start();
        return this;
    }
    public abstract void onConnect(Socket t, PrintWriter pw);

    @Override
    public void run() {
       while (true){
           try {
               Socket t = serverSocket.accept();
               if(t.getInetAddress().getHostAddress() == "127.0.0.1"){
                        onConnect(t, new PrintWriter(t.getOutputStream()));
                        t.close();
               }else{
                   System.err.println("External Connection IP: " + t.getInetAddress().getHostAddress());
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }
}
