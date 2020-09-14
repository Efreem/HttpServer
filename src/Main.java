import cgi.CreateCgi;

import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        FileReader reader = new FileReader("resources/main.html");
        String htmlContent = "";
        int byteElement = 0;

        while(true) {
            byteElement = reader.read();

            if(byteElement == -1) {
                break;
            } else {
                htmlContent += (char)byteElement;
            }
        }

        while(true) {
            Socket socket = serverSocket.accept();
            OutputStream socketOutput = socket.getOutputStream();
            CreateCgi cgi = new CreateCgi();

            cgi.addHttpHeader()
                    .addCodeStatus("200")
                    .addContentType()
                    .addContentLength(htmlContent.length())
                    .addContent(htmlContent);

            socketOutput.write(cgi.getReadyCgi().getBytes());
            socket.close();
        }
    }
}