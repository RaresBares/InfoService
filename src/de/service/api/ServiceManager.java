package de.service.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.BiConsumer;

public class ServiceManager {

    private static ServiceManager serviceManager = null;

    public static ServiceManager getServerManager() {
        if (serviceManager == null) {
            serviceManager = new ServiceManager();
        }
        return serviceManager;
    }


    public Service createNewService(int port, String name, BiConsumer bi) throws IOException {
        return new Service(port, name) {
            @Override
            public void onConnect(Socket t, PrintWriter pw) {
                bi.accept(t, pw);
            }
        };
    }

    public ServiceCall createNewServiceCall(int port) throws IOException {
        return new ServiceCall(port);
    }

    public ArrayList<Service> getServices(){
        return Sets.getServices();
    }

    public int ServiceLentgh(){
       return getServices().size();
    }
    public Service getService(String name){
        return Sets.getServicebyName(name);
    }


}
