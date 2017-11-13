// Fig. 28.6: ClientTest.java
// Class that tests the Client.

import javax.swing.*;
import java.io.IOException;

public class ClientTest {
    public static void main(String[] args) {
        Client client; // declare client application

        // if no command line args
        if (args.length == 0)
            client = new Client("127.0.0.1"); // connect to localhost
        else
            client = new Client(args[0]); // use args to connect

        try {
            client.runClient(); // run client application
        }
        catch (IOException e){
            System.out.println("something something client doesnt work");
        }
    }
}

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
