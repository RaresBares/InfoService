package de.service;

import com.sun.corba.se.spi.activation.ServerManager;
import de.service.api.ServiceCall;
import de.service.api.ServiceManager;
import de.service.api.custom.CUSTOM_DateTime;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        new CUSTOM_DateTime(10000);
        System.out.println(new ServiceCall(10000).getMessage());

    }

}
