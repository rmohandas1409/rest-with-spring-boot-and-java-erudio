package br.com.rwm;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	//Retorna o conteudo hello Word
	private static final String template = "Hello, %s!";
	
	//Gera o id automatico
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(
			
			//Recebe um paramentro do tipo string e retorna no json caso não seja passado nada ele retorna 
			//word exeplo da url: localhost:8080/greeting?name=nome se tiver mais de um parametro a url
			// é passada assim localhost:8080/greeting?name=nome&idade=alguma_coisa
			@RequestParam(value ="name", defaultValue = "Word") 
			String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
