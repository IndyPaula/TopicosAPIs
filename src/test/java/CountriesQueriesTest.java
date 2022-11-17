import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public class CountriesQueriesTest {

    String url = "https://countries.trevorblades.com/";
    String  queryCountries = "{\"query\":\"query country {\\r\\n\\tcountry(code:\\\"BR\\\"){\\r\\n    name\\r\\n    emoji\\r\\n    continent{\\r\\n      code\\r\\n      name\\r\\n      countries{\\r\\n        name\\r\\n        code\\r\\n        emoji\\r\\n      }\\r\\n    }\\r\\n  }\\r\\n}\\r\\n\",\"variables\":{}}";


    @Test
    public void shouldReturnStatusCode200(){
//        Response response = (Response) given().
//                                header("Content-Type","application/json").
//                                and().
//                                body(queryCountries).
//                        when().
//                                post(url);
//                                //post(url).then().log().status().equals("200");
        CountriesQueries countriesQueries = new CountriesQueries();

        Response response = countriesQueries.setUpQueryRequisicaoCountry();
        response.body();
        Object continent = response.jsonPath().get("data.country.continent.countries[0].name");
        System.out.println(continent.toString());

        HashMap continents = response.jsonPath().get("data.country.continent.countries[1]");
        System.out.println(continents.get("name"));

        response.then().statusCode(200);
        response.then().body("data.country.name", equalTo("Brazil"));
        response.then().body("data.country.continent.countries[0].name", equalTo("Argentina"));
        response.then().body("data.country.continent.countries[0].name", instanceOf(String.class));
        response.then().log().body();
    }

}
