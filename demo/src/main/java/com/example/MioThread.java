package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MioThread extends Thread {

    Socket s;

    public MioThread(Socket s) {
        this.s = s;
    }

    public void run() {

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            do {

                switch (in.readLine()) {
                    case "1":
                        out.writeBytes(in.readLine().toUpperCase() + "\n");
                    break;

                    case "2":
                        out.writeBytes(in.readLine().toLowerCase() + "\n");
                    break;

                    case "3":
                        String parola = in.readLine();
                        String ribalto = "";
                        for(int i=parola.length()-1; i>=0; i--){
                            ribalto += parola.charAt(i);
                        }
                        out.writeBytes(ribalto + "\n");
                    break;

                    case "4":
                        out.writeBytes(in.readLine().length() + "\n");
                    break;

                    case "5":
                        System.out.println("server in chiusura");
                        s.close();
                    break;

                    
                }

            } while (true);

        } catch (Exception e) {

        }

    }

}
