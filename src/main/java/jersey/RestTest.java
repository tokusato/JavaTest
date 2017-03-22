package jersey;

import javax.ws.rs.core.MediaType;

public class RestTest {

//	https://www.agilegroup.co.jp/technote/java-rest-client01.html
    public static void main(String[] args) {
        RestClient client = new RestClient("admin", "admin");
        String uri = "http://localhost:8080/magnoliaAuthor/.rest/nodes/v1/website/demo-project";    // 実際のリクエスト先を指定

        String xml = client.getString(uri, MediaType.APPLICATION_XML_TYPE);
        System.out.println(xml);

        String json = client.getString(uri, MediaType.APPLICATION_JSON_TYPE);
        System.out.println(json);
    }
}
