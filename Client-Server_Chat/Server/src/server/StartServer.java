package server;

import java.io.IOException;

/**
 *
 * @author Almons
 */
public class StartServer {

    
    public static void main(String[] args) throws IOException {
        
    	ClientHandler1 start = new ClientHandler1();
		start.go();
    }
    
}
