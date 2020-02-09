package de.service.api;

import java.net.Socket;

public abstract class Service extends Thread {

    public Service listen(){
        this.start();
        return this;
    }
    public abstract void onConnect(Socket t);

    @Override
    public void run() {
        super.run();
    }
}
