package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
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

            Scanner scanner = new Scanner(System.in);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            System.out.print("Connessione effettuata\n");
            System.out.print("Inserisci un numero: ");
            int num = scanner.nextInt();
            scanner.nextLine();
        
            out.writeBytes(String.valueOf(num) + "\n");
            int tentativi = 1;

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
                tentativi++;

                risposta = in.read();
            }

            System.out.print("Numero indovinato in " + tentativi + " tentativi\n");
            scanner.close();
            s.close();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
