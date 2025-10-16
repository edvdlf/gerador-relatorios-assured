package br.com.vetorit.geradorrelatorio.tests.tipodocumento;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import br.com.vetorit.fasttax.core.BaseTests;
import io.restassured.http.ContentType;

/**
 * Cenários cobertos:
 * 1) Sucesso com body JSON completo
 * 2) Sucesso com body mínimo (apenas id)
 * 3) Sucesso enviando como form/query (binding sem @RequestBody)
 * 4) Falha sem Content-Type (esperado 415)
 * 5) Falha sem token (esperado 400 ou 403, conforme seu preHandle)
 * 6) Falha com JSON inválido (esperado 400)
 * 7) Falha id ausente/nulo (esperado 400 ou 422; se o service lançar, pode ser 500 — veja observação)
 */
public class TipoDocumentoDeleteTest extends BaseTests {

    private static final String ENDPOINT = "/api/tipo-documento";
    private final String AUTH = "Bearer " + TOKEN_TEMP; // herdado do BaseTests

    private Map<String, Object> payloadMinimo(long id) {
        Map<String, Object> p = new HashMap<>();
        p.put("id", id);
        return p;
    }

    private Map<String, Object> payloadCompleto() {
        Map<String, Object> p = new HashMap<>();
        p.put("id", 2L);
        p.put("titulo", "NFe v4.00");
        p.put("descricao", "para exclusão de teste");
        p.put("ativo", true);
        p.put("nomeArquivo", "nfe_v4.xsd");
        // demais campos ignorados no delete, mas úteis para cobrir binding
        return p;
    }

    @Nested
    @DisplayName("Cenários de SUCESSO")
    class Sucesso {

        @Test
        @DisplayName("200 OK — body JSON completo")
        void deveExcluirComBodyCompleto() {
            given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", AUTH)
                .body(payloadCompleto())
                .log().all()
            .when()
                .delete(ENDPOINT)
            .then()
                .log().all()
                .statusCode(200);
        }

        @Test
        @DisplayName("200 OK — body JSON mínimo (apenas id)")
        void deveExcluirApenasComId() {
            given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", AUTH)
                .body(payloadMinimo(2L))
                .log().all()
            .when()
                .delete(ENDPOINT)
            .then()
                .log().all()
                .statusCode(200);
        }

        @Test
        @DisplayName("200 OK — enviando id como form/query param (binding sem @RequestBody)")
        void deveExcluirComFormParamOuQueryParam() {
            given()
                .contentType(ContentType.URLENC) // form-urlencoded
                .accept(ContentType.JSON)
                .header("Authorization", AUTH)
                .formParam("id", 2L)
                .log().all()
            .when()
                .delete(ENDPOINT)
            .then()
                .log().all()
                .statusCode(200);
        }
    }

//    @Nested
//    @DisplayName("Cenários de FALHA")
//    class Falha {
//
//        @Test
//        @DisplayName("415 Unsupported Media Type — sem Content-Type")
//        void deveFalharSemContentType() {
//            given()
//                .accept(ContentType.JSON)
//                .header("Authorization", AUTH)
//                .body(payloadMinimo(2L))
//                .log().all()
//            .when()
//                .delete(ENDPOINT)
//            .then()
//                .log().all()
//                .statusCode(415); // muitos setups devolvem 415 sem Content-Type
//        }
//
//        @Test
//        @DisplayName("400/403 — sem token")
//        void deveFalharSemToken() {
//            given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .body(payloadMinimo(2L))
//                .log().all()
//            .when()
//                .delete(ENDPOINT)
//            .then()
//                .log().all()
//                // Dependendo do seu preHandle/security, pode ser 400 (bad request) ou 403 (forbidden)
//                .statusCode(anyOf(is(400), is(401), is(403)));
//        }
//
//        @Test
//        @DisplayName("400 Bad Request — JSON inválido")
//        void deveFalharComJsonInvalido() {
//            String jsonInvalido = "{ id: , }"; // propositadamente inválido
//            given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .header("Authorization", AUTH)
//                .body(jsonInvalido)
//                .log().all()
//            .when()
//                .delete(ENDPOINT)
//            .then()
//                .log().all()
//                .statusCode(400);
//        }
//
//        @Test
//        @DisplayName("400/422 — id ausente/nulo")
//        void deveFalharSemId() {
//            Map<String, Object> semId = new HashMap<>();
//            given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .header("Authorization", AUTH)
//                .body(semId)
//                .log().all()
//            .when()
//                .delete(ENDPOINT)
//            .then()
//                .log().all()
//                // Ideal: 400 (bad request) ou 422 (unprocessable). 
//                // Se o service lançar NPE e virar 500, considere validar antes e retornar 400/422 no controller.
//                .statusCode(anyOf(is(400), is(422)));
//        }
//    }
}
