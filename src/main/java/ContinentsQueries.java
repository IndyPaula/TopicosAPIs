import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ContinentsQueries {

    public Response setUpQueryRequisicaoContinents(){
        Constantes constantes = new Constantes();
        Response response = given().
                header("Content-Type","application/json").
                and().
                body(Constantes.QUERYCONTINENTS).
                when().
                post(Constantes.URL);
        //post(url).then().log().status().equals("200");
        return  response;
    }


}
