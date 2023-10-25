package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class MioThread extends Thread{
    Socket s;
    
    public MioThread(Socket s){
        this.s = s;
    }

    public void run(){
        try{
            Scanner scanner = new Scanner(System.in);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            System.out.print("Connessione effettuata\n");
            System.out.print("Inserisci un numero: ");
            int num = scanner.nextInt();
            scanner.nextLine();
        
            out.writeBytes(String.valueOf(num) + "\n");

            int risposta = in.read();

            while(risposta != 3){
                if(risposta == 1){
                    System.out.print("Numero piccolo\n");
                }
                else{
                    System.out.print("numero grande\n");
                }

                System.out.print("Inserisci un numero: ");
                num = scanner.nextInt();
                scanner.nextLine();
                out.writeBytes(String.valueOf(num) + "\n");

                risposta = in.read();
            }

            int tentativi = in.read();

            System.out.print("Numero indovinato in " + tentativi + " tentativi\n");
            
            scanner.close();
            s.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
