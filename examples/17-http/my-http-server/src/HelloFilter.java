import java.io.IOException;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpExchange;

public class HelloFilter extends Filter {

    @Override
    public String description(){
        return "this is a hello filter";
    }

    @Override
    public void doFilter(HttpExchange httpex, Filter.Chain chain) throws IOException {
        System.out.println("doFilter");
        chain.doFilter(httpex);
    }
}
