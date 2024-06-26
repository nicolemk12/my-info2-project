package lab5;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/*
A very basic Client that connects to Server.
It takes input message from the user and sends them to the serve
 */
public class Client {
    private int port;
    private String host;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private Socket socket;

    public static void main(String[] args) {
        Client client = new Client("localhost", 8008);
        client.start();
        System.out.println("Please enter text: ");

        while (true) {
            try(Scanner scanner = new Scanner(System.in)) {
                if(scanner.hasNext()){
                    String m = scanner.nextLine();

                    client.writeMessage(m);
                    client.readMessage();
                }
            }
            try{
                //wait 5 seconds to display the message, to see if it works
                Thread.sleep(5000);
            } catch(InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    private void writeMessage(String m) {
        printWriter.println(m);
    }

    private void readMessage() {
        try {
            String message = bufferedReader.readLine();
            System.out.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     Stores the IP address & port nr the client is connecting to.
     @param host The String of the host's IP address.
     @param port The port nr to listen to on connection.
     */

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }
    /*
    Starts the client and sets up  streams to and from it
     */

    private void start(){
        connectSocket();
        setupStreams();
    }

    /*
    Creates a socket to communicate through
     */
private void connectSocket() {
    try{
        socket = new Socket(host,port);
    }catch(UnknownHostException uhe){
        uhe.printStackTrace();
    }catch(IOException ioe){
        ioe.printStackTrace();
    }
}

//From here on, almost 1:1 copy-paste from Server!
/*
    Create IO-Streams
 */

private void setupStreams() {

    try {
        InputStreamReader input = new InputStreamReader(socket.getInputStream());
        OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream());
        bufferedReader = new BufferedReader(input);
        printWriter = new PrintWriter(output,true);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
}
