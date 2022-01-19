package julioapm.springresttestes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AloMundoController {
	private final AloMundoService service;

	@Autowired
	public AloMundoController(AloMundoService service) {
		this.service = service;
	}
	
	@GetMapping("/alo")
	public @ResponseBody String getAlo() {
		return service.gerarSaudacao();
	}
}
