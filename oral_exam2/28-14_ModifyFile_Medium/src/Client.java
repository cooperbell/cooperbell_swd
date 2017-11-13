// Fig. 28.5: Client.java
// Client portion of a stream-socket connection between client and server.

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private String host;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket connection;
    private String message;

    public Client(String host) {
        this.host = host;
    }

    public void runClient() throws IOException {
        try {
            connectToServer();
            getStreams();
            processConnection();
        }
        catch (EOFException e){
            System.out.println("Client Terminated Connection");
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
        finally {
            closeConnection();
        }
    }


    private void connectToServer() throws IOException {
        System.out.println("Attempting connection");
        connection = new Socket(InetAddress.getByName(host), 12345);
        System.out.println("Connection successful");
    }

    private void getStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();

        input = new ObjectInputStream(connection.getInputStream());

        System.out.println("Got I/O streams");
    }

    private void processConnection() throws IOException {
        do {
            try{
                message = (String) input.readObject();
                System.out.println("CLIENT PROCESS CONNECTION>>" + message);
            } catch (ClassNotFoundException classNotFoundException) {
                System.out.println("Unknown object received");
            }
        } while(!message.equals("SERVER>> TERMINATE"));
    }

    private void closeConnection() {
        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void sendData(String message) {
        try // send object to server
        {
            output.writeObject("CLIENT>>> " + message);
            output.flush(); // flush data to output
            System.out.println("CLIENT>>> " + message);
        } catch (IOException ioException) {
            System.out.println("Error writing object");
        }
    }
}


