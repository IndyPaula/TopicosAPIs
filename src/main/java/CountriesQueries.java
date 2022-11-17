
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CountriesQueries {




    public Response setUpQueryRequisicaoCountry(){
         Constantes constantes = new Constantes();
         Response response = given().
                       header("Content-Type","application/json").
                       and().
                       body(Constantes.QUERYCOUNTRY).
                   when().
                        post(Constantes.URL);
            //post(url).then().log().status().equals("200");
            return  response;
    }




}
