package de.service;

import de.service.api.ServiceCall;
import de.service.api.custom.CUSTOM_DateTime;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        new CUSTOM_DateTime();
        System.out.println(new ServiceCall(10000).getMessage());
    }

}
