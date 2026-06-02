import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HelloHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpEx) throws IOException {

        System.out.println("Hello, World");

        try (httpEx){
            System.out.println(httpEx.getLocalAddress());
            System.out.println(httpEx.getProtocol());
            System.out.println(httpEx.getRemoteAddress());

            InputStream i = httpEx.getRequestBody();
            String body = new String(i.readAllBytes());
            System.out.println(body);

            System.out.println(httpEx.getRequestHeaders());
            System.out.println(httpEx.getRequestMethod());
            System.out.println(httpEx.getRequestURI());
            System.out.println(httpEx.getProtocol());
            System.out.println(httpEx.getRequestBody());

            String response = "<h1>This is the response</h1>\n";
            response += "Received: " + body;
            httpEx.sendResponseHeaders(200, response.length());
            
            System.out.println(httpEx.getResponseHeaders());
            System.out.println(httpEx.getResponseCode());


            System.out.println(httpEx.getResponseBody());

            try (OutputStream os = httpEx.getResponseBody()){
                os.write(response.getBytes());
            }            
        }
    }
}
