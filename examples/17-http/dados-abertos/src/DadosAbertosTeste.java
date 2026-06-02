import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class DadosAbertosTeste {
    public static void main(String[] args) {

        try {
                HttpClient client = HttpClient.newBuilder()
                                            .version(HttpClient.Version.HTTP_2)
                                            .build();

                HttpRequest request = HttpRequest.newBuilder()
                                            .uri(URI.create("https://legis.senado.leg.br/dadosabertos/senador/lista/atual"))
                                            .header("accept", "application/json")
                                            .GET()
                                            .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            System.out.println(request.toString());
            System.out.println(response);
            System.out.println(response.statusCode());
            //System.out.println(response.headers());
            //System.out.println(response.uri());
            //System.out.println(response.body());

            ListaParlamentarEmExercicio dados =
            mapper.readValue(response.body(), ListaParlamentarEmExercicio.class);
            dados.Parlamentares().Parlamentar().forEach(p -> System.out.println(p.IdentificacaoParlamentar().NomeParlamentar()));

        } catch (IOException | InterruptedException ie) {
            System.out.println(ie);
        }
    }
}
