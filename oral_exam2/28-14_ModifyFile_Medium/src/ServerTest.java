// Fig. 28.4: ServerTest.java
// Test the Server application.

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ServerTest {
    public static void main(String[] args) {
        //write the text file
        try {
            PrintWriter writer = new PrintWriter("C:\\Users\\Cooper\\IdeaProjects\\coopbell_swd\\oral_exam2\\28-14_ModifyFile_Medium\\src\\message.txt");
            writer.println("The first line");
            writer.println("The second line");
            writer.close();
        } catch (IOException e){
            System.out.println("Cannot write file");
        }
        Server application = new Server("C:\\Users\\Cooper\\IdeaProjects\\coopbell_swd\\oral_exam2\\28-14_ModifyFile_Medium\\src\\message.txt"); // create server
        application.runServer(); // run server application
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