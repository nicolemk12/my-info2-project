package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class NanoHttpServer {

    public static void main(String[] args) throws IOException {
        int port = 8008;
        if (args.length > 0)
            port = Integer.parseInt(args[0]);

        NanoHttpServer server = new NanoHttpServer();
        server.listen(port);
    }

    public void listen(int port) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("NanoHTTPServer listening on port " + port);
                Scanner scn = new Scanner(System.in);
                if(scn.hasNextLine()) {
                    System.out.println("Message:" + scn.nextLine());
                }
                try (
                        Socket socket = serverSocket.accept();
                     InputStream input = socket.getInputStream();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                     OutputStream output = socket.getOutputStream();
                     PrintWriter writer = new PrintWriter(new OutputStreamWriter(output))

                ) {
                    System.out.println("-------------------- request from " + socket.getRemoteSocketAddress());

                    String message = reader.readLine();
                    if (message != null)
                        System.out.println("Server received message - Client said: " + message);
                    writer.write(message.toUpperCase());
                } catch (Exception e) {
                    System.out.println("Caught Exception in While Loop:");
                    throw e;
                }

            }
        }
    }
}