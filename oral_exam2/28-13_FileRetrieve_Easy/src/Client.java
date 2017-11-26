// Fig. 28.5: Client.java
// Client portion of a stream-socket connection between client and server.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Class for the client
 */
public class Client extends JFrame {

    /**
     * enters file path from user
     */
    private JTextField enterField;

    /**
     * display information to user
     */
    private JTextArea displayArea;

    /**
     * output stream to server
     */
    private ObjectOutputStream output;

    /**
     * input stream from server
     */
    private ObjectInputStream input;

    /**
     * message from server
     */
    private String message = "";

    /**
     * host server for this application
     */
    private String chatServer;

    /**
     * socket to communicate with server
     */
    private Socket client;

    /**
     * initialize chatServer and set up GUI
     *
     * @param host
     */
    public Client(String host) {
        super("Client");

        chatServer = host;

        enterField = new JTextField();
        enterField.setEditable(false);
        enterField.addActionListener(
                new ActionListener() {
                    // send message to server
                    public void actionPerformed(ActionEvent event) {
                        sendData(event.getActionCommand());
                        enterField.setText("");
                    }
                }
        );

        add(enterField, BorderLayout.NORTH);

        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(300, 150);
        setVisible(true);
    }

    /**
     * connect to server and process messages from server
     */
    public void runClient() {
        try {
            connectToServer();
            getStreams();
            processConnection();
            displayMessage("Send a file path.");
        } catch (EOFException eofException) {
            displayMessage("\nClient terminated connection");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    /**
     * connect to server
     *
     * @throws IOException if InetAddress cannot find address
     */
    private void connectToServer() throws IOException {
        displayMessage("Attempting connection\n");

        client = new Socket(InetAddress.getByName(chatServer), 12345);

        displayMessage("Connected to: " +
                client.getInetAddress().getHostName());
    }

    /**
     * get streams to send and receive data
     *
     * @throws IOException if streams are not found
     */
    private void getStreams() throws IOException {
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();

        input = new ObjectInputStream(client.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }

    /**
     * process connection with server
     *
     * @throws IOException if input cannot read object
     */
    private void processConnection() throws IOException {
        setTextFieldEditable(true);

        do {
            try {
                message = (String) input.readObject();
                displayMessage("\n" + message);
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            }

        } while (!message.equals("SERVER>>> TERMINATE"));
    }

    /**
     * close streams and socket
     */
    private void closeConnection() {
        displayMessage("\nClosing connection");
        setTextFieldEditable(false);

        try {
            output.close();
            input.close();
            client.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * send message to server
     *
     * @param fileLocation the file path
     */
    private void sendData(String fileLocation) {
        try {
            output.writeObject(fileLocation);
            output.flush();
            displayMessage("\nCLIENT>>> " + fileLocation);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
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

    /**
     * manipulates enterField in the event-dispatch thread
     *
     * @param editable boolean whether the displayArea should be editable
     */
    private void setTextFieldEditable(final boolean editable) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // sets enterField's editability
                    {
                        enterField.setEditable(editable);
                    }
                }
        );
    }
}
