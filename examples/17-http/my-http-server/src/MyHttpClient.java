import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class MyHttpClient {

    public static void main(String[] args){
    
        try {
            HttpClient client = HttpClient.newHttpClient(); //.newBuilder()
                        //.version(Version.HTTP_1_1)
                        //.followRedirects(Redirect.NORMAL)
                        //.connectTimeout(Duration.ofSeconds(20))
                        //.proxy(ProxySelector.of(new InetSocketAddress("localhost", 3334)))
                        //.authenticator(Authenticator.getDefault())
                        //.build();

            HttpRequest request = HttpRequest.newBuilder()
                                .POST(HttpRequest.BodyPublishers.ofString("Hello from client"))
                                //.header("test", "hello, world")
                                //.version(Version.HTTP_1_1)
                                .uri(new URI("http://localhost:3333/hello"))
                                .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

}
