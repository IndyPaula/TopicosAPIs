import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public class ContinentsQueriesTest {

    ContinentsQueries continentsQueries;
    Response response;

    @Test
    public void shouldReturnStatusCode200(){

        continentsQueries = new ContinentsQueries();

        response = continentsQueries.setUpQueryRequisicaoContinents();
        response.body();
        response.then().
                log().body();

        response.then().
                assertThat().
                statusCode(200);

    }

    @Test
    public void shouldReturnContinenteItem(){
        continentsQueries = new ContinentsQueries();

        response = continentsQueries.setUpQueryRequisicaoContinents();
        response.body();
        response.then().
                log().body();

        response.then().
                body("data.continents[0].code", equalTo("AF"));
    }

    @Test
    public void shouldReturnType(){
        continentsQueries = new ContinentsQueries();

        response = continentsQueries.setUpQueryRequisicaoContinents();
        response.body();
        response.then().
                log().body();

        response.then().
                body("data.continents[0].code", instanceOf(String.class));
    }

    @Test
    public void shouldReturnContinentByPath(){
        continentsQueries = new ContinentsQueries();

        response = continentsQueries.setUpQueryRequisicaoContinents();
        response.body();
        response.then().
                log().body();

        String continent = response.jsonPath().
                get("data.continents[0].code");
        System.out.println(continent);

    }

    @Test
    public void shouldReturnSizeContinentsList(){
        continentsQueries = new ContinentsQueries();

        response = continentsQueries.setUpQueryRequisicaoContinents();
        response.body();
        response.then().
                log().body();

       ArrayList continents = response.jsonPath().get("data.continents");

       System.out.println(continents.size());
       assert(continents.size() == 1);

    }
}
