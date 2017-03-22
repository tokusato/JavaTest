package jersey;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

/**
 * RESTリクエストを行うためのクライアントクラス
 * cited from
 * https://www.agilegroup.co.jp/technote/java-rest-client01.html
 */
public class RestClient {

    private String account = null;
    private String password = null;

    public RestClient(String account, String password) {
        this.account = account;
        this.password = password;
    }

    private Client getClient() {
        Client client = new Client();
        client.addFilter(new HTTPBasicAuthFilter(account, password));
        return client;
    }

    public String getString(String url, MediaType type) {
        Client client = getClient();
        WebResource resource = client.resource(url);
        ClientResponse response = resource.accept(type).get(ClientResponse.class);
        switch (response.getStatus()) {
        case 200 :  // OK
            break;
        default:
            return String.format("Code:%s Entity:%s",
                    response.getStatus(),
                    response.getEntity(String.class));
        }
        return response.getEntity(String.class);
    }
}