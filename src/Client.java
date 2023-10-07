import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", Server.PORT);
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            pw.println("hello from Server");
            System.out.println("This client is running on port: " + br.readLine());
        } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }