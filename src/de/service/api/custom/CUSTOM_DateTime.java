package de.service.api.custom;

import de.service.api.Service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CUSTOM_DateTime  extends Service {
    public CUSTOM_DateTime(int port) throws IOException {
        super(port,"date");
    }

    @Override
    public void onConnect(Socket t, PrintWriter pw) {
        pw.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + "\n");
        pw.flush();
    }
}
