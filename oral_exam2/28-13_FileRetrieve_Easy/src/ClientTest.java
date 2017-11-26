// Fig. 28.6: ClientTest.java
// Class that tests the Client.

import javax.swing.*;

/**
 * Driver class for Client
 */
public class ClientTest {
    public static void main(String[] args) {
        Client application; // declare client application

        // if no command line args
        if (args.length == 0)
            application = new Client("127.0.0.1"); // connect to localhost
        else
            application = new Client(args[0]); // use args to connect

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runClient(); // run client application
    }
}

