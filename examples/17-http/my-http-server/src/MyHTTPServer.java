import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class MyHTTPServer {
    
    public static void main(String[] args) {
        try {

            HttpServer myServer = HttpServer.create(
                                        new InetSocketAddress(3333),
                                        10,
                                        "/hello",
                                        new HelloHandler(),
                                        new HelloFilter()
            );

            //HttpContext context = myServer.createContext("/hello", new HelloHandler());
            //System.out.println(context);
            
            myServer.setExecutor(null);
            myServer.start();

        } catch (Exception e) {
            System.out.println(e);

        }

        

    }

}
