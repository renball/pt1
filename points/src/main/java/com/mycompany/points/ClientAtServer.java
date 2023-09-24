/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.points;

import java.io.*;
import java.net.Socket;
/**
 *
 * @author q
 */

public class ClientAtServer implements Runnable{
    Socket cs;
    MainServer ms;

    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;
    public ClientAtServer(Socket cs) {
        this.cs = cs;
    }

    public ClientAtServer(Socket cs, MainServer ms) {
        this.cs = cs;
        this.ms = ms;

        try {
            os = cs.getOutputStream();
            dos = new DataOutputStream(os);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void run() {
        try {
            is = cs.getInputStream();
            dis = new DataInputStream(is);
            while (true) {
                String s = dis.readUTF();
                System.out.println("Conncet: " + s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
