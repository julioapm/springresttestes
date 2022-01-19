package julioapm.springresttestes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//É um teste com o suporte Spring Boot, cria um Mock do contexto de execução do Spring
class SpringresttestesApplicationTests {
	//Injetando as dependências reais sem dubles
	@Autowired
	private AloMundoController aloMundoController;
	
	//Testar se o contexto é criado com sucesso
	@Test()
	void contextLoads() {
		assertThat(aloMundoController).isNotNull();
	}

}
