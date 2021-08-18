package com.condominio.apicondominio.controller;


import com.condominio.apicondominio.Dto.VisitanteRequestDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.with;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import  static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestVisitanteController {

    @LocalServerPort
    private int port;


    @BeforeEach
    void setup(){
        RestAssured.port = port;
    }

    @Test
    void deveEnviarRequisicaoParaCadastraVisitanteComSucesso(){
        var endpoint = "/visitantes";
        var metodo = "Post";

        var cpf = "111111111111";
        var nome = "visitante do Condominio";
        var payload = new VisitanteRequestDto(nome , cpf);


        var response = with()
                .contentType(ContentType.JSON)
                .body(payload)
                .request(metodo, endpoint)
                .then()
                .extract()
                .response();

        var json = response.jsonPath();

        assertAll("Todos os testes",
                () -> assertEquals(HttpStatus.CREATED.value(), response.getStatusCode()),
                () -> assertNotNull(json.getString("id")));

    }

    @Test
    void deveEnviarRequisicaoParaCadastraVisitanteMasRetornaCpfInvalido(){
        var endpoint = "/visitantes";
        var metodo = "Post";


        var nome = "visitante do Condominio";
        var payload = new VisitanteRequestDto(null,nome  );


        var response = with()
                .contentType(ContentType.JSON)
                .body(payload)
                .request(metodo, endpoint)
                .then()
                .extract()
                .response();

        var json = response.jsonPath();

        assertAll("Todos os testes",
                () -> assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode()),
                () -> assertNotNull(json.getString("dataHora")),
                () -> assertEquals("cpf inválido ou não informado",json.getString("mensagem")));

    }

    @Test
    void deveEnviarRequisicaoParaCadastraVisitanteMasRetornaNomeInvalido(){
        var endpoint = "/visitantes";
        var metodo = "Post";


        var cpf = "111111111111";
        var payload = new VisitanteRequestDto(cpf,null  );


        var response = with()
                .contentType(ContentType.JSON)
                .body(payload)
                .request(metodo, endpoint)
                .then()
                .extract()
                .response();

        var json = response.jsonPath();

        assertAll("Todos os testes",
                () -> assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode()),
                () -> assertNotNull(json.getString("dataHora")),
                () -> assertEquals("nome não informado",json.getString("mensagem")));

    }


}
