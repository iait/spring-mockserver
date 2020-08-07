package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.mock.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dto.Usuario;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration
//@ComponentScan(basePackages = "com.eivfinanciero.data.das")
public class UsuarioServiceTest {
    
    @Autowired private UsuarioService usuarioService;
    
    private static ClientAndServer mockServer;

    @BeforeAll
    public static void startMockServer() {
        mockServer = ClientAndServer.startClientAndServer(8080);
    }

    @AfterAll
    public static void stopMockServer() {
        mockServer.stop();
    }
    
    @Test
    public void whenConsultaUsuarios_thenReturnOk() {
        
        MockServerClient client = new MockServerClient("localhost", mockServer.getPort());
        client 
            .when(
                    request()
                        .withPath("/usuarios")
                    )
            .respond(
                    response()
                        .withBody("{\"id\": 10, \"nombre\": \"Ismael\"}")
                        .withHeader("Content-Type", "application/json")
                    );
        
        Usuario usuario = usuarioService.buscarUsuarios();
        
        assertThat(usuario).isNotNull();
        assertThat(usuario.getId()).isEqualTo(10);
        assertThat(usuario.getNombre()).isEqualTo("Ismael");
        
        client.close();
    }

}
