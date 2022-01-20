package julioapm.springresttestes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AloMuntoControllerTesteUnitario {
	@Mock
	private AloMundoService aloMundoService;
	
	@InjectMocks
	private AloMundoController aloMundoController;
	
	@BeforeEach
	void configureMocks( ) {
		when(aloMundoService.gerarSaudacao()).thenReturn("Alô Mundo!");
	}
	
	@Test
	void getAloDeveRetornarMensagem()  {
		assertThat(aloMundoController.getAlo()).isEqualTo("Alô Mundo!");
	}

}
