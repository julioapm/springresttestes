package julioapm.springresttestes;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(AloMundoController.class)
//Utiliza somente a camada web e não o contexto completo de execução do Spring
//Carrega somente o controlador indicado
class AloMundoControllerTesteRestMock {
	//Injetando o duble do ambiente de execução
	@Autowired
	private MockMvc mockMvc;
	
	//Injetando o duble da dependência via Mockito
	//pois teste unitário utiliza dubles das dependências
	@MockBean
	private AloMundoService aloMundoService;
	
	@Test
	void aloDeveRetornarMensagem() throws Exception {
		//Configurando o retorno do duble
		when(aloMundoService.gerarSaudacao()).thenReturn("Alô Mundo!");
		//Realizando o teste
		mockMvc.perform(get("/alo"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.TEXT_PLAIN))
			.andExpect(content().string("Alô Mundo!"));
	}

}
