import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;

/**
 * Class for the server
 */
public class Server extends JFrame {

    /**
     * display information to user
     */
    private JTextArea displayArea;

    /**
     * output stream to client
     */
    private ObjectOutputStream output;

    /**
     * input stream from client
     */
    private ObjectInputStream input;

    /**
     * server socket
     */
    private ServerSocket server;

    /**
     * connection to client
     */
    private Socket connection;

    /**
     * counter of number of connections
     */
    private int counter = 1;

    /**
     * Constructor sets up GUI
     */
    public Server() {
        super("Server");

        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(300, 150);
        setVisible(true);
    }

    /**
     * set up and run server
     */
    public void runServer() {
        try {
            server = new ServerSocket(12345, 100);

            while (true) {
                try {
                    waitForConnection();
                    getStreams();
                    processConnection();
                } catch (EOFException eofException) {
                    displayMessage("\nServer terminated connection");
                } finally {
                    closeConnection();
                    ++counter;
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * wait for connection to arrive, then display connection info
     *
     * @throws IOException if server cannot accept connection
     */
    private void waitForConnection() throws IOException {
        displayMessage("Waiting for connection\n");
        connection = server.accept();
        displayMessage("Connection " + counter + " received from: " +
                connection.getInetAddress().getHostName());
    }

    /**
     * get streams to send and receive data
     *
     * @throws IOException if input or output streams do not exist
     */
    private void getStreams() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();

        input = new ObjectInputStream(connection.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }

    /**
     * process connection with client
     *
     * @throws IOException if input cannot read object
     */
    private void processConnection() throws IOException {
        String message = "Connection successful";
        sendData(message);


        do {
            try {
                message = (String) input.readObject();
                displayMessage("\n" + message);
                getFile(message);
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

        } while (!message.equals("CLIENT>>> TERMINATE"));
    }

    /**
     * close streams and socket
     */
    private void closeConnection() {
        displayMessage("\nTerminating connection\n");

        try {
            output.close();
            input.close();
            connection.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * send message to client
     *
     * @param message String message to send to client
     */
    private void sendData(String message) {
        try {
            output.writeObject("SERVER>>> " + message);
            output.flush();
            displayMessage("\nSERVER>>> " + message);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }

    /**
     * Opens file and sends it to the client line by line
     * @param fileLocation String file path
     * @throws URISyntaxException if URI syntax is wrong
     */
    private void getFile(String fileLocation) throws URISyntaxException {
        String line;
        BufferedReader fileReader;
        File aaa = new File(getClass().getResource(fileLocation).toURI());
        try {
            fileReader = new BufferedReader(new FileReader(aaa));
            while ((line = fileReader.readLine()) != null) {
                sendData(line);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * manipulates displayArea in the event-dispatch thread
     *
     * @param messageToDisplay String to append to displayArea
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay);
                    }
                }
        );
    }
}