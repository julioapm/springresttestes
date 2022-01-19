package julioapm.springresttestes;

import org.springframework.stereotype.Service;

@Service
public class AloMundoService {
	public String gerarSaudacao() {
		return "Alô Mundo!";
	}
}
