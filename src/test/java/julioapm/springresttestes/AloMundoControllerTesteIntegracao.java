package julioapm.springresttestes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//É um teste com o suporte Spring Boot completo
//Observe que é necessário por ser um teste de integração
class AloMundoControllerTesteIntegracao {
	//Injetando um testador do Spring Boot para requisições HTTP
	@Autowired
    private TestRestTemplate restTemplate;
	//Injetando a porta aleatória utilizada pelo ambiente de execução
	@LocalServerPort
    private int port;
	
	@Test
	void aloDeveRetornarMensagem() throws Exception {
		//Realizando o teste
		String resposta = restTemplate.getForObject("http://localhost:"+port+"/alo", String.class);
		assertEquals("Alô Mundo!", resposta);
	}
	
}
