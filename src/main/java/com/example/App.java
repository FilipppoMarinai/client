package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            Socket s = new Socket("127.0.0.1", 4000);
            ArrayList client = new ArrayList();

            MioThread thread = new MioThread(s, client);
            thread.start();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
