package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPunto6 {
	
	@RequestMapping(path="/punto6/{x}/{y}")
	public ModelAndView punto6(@PathVariable String cadena, @PathVariable String operacion){
	
		ModelMap modelo = new ModelMap();
		
		modelo.put("cadena", cadena);
		modelo.put("operacion", operacion);
		
		String resultado;
		String operacionInvalida = "Operación no encontrada, por favor escribir:\npasarAMayuscula\npasarAMinuscula";
		
		switch(operacion){
			
			case "pasarAMayuscula":
				resultado = cadena.toUpperCase();
				modelo.put("resultado", resultado);
				break;
			
			case "pasarAMinuscula":
				resultado = cadena.toLowerCase();
				modelo.put("resultado", resultado);
				break;
			
			case "invertirOrden":
				String resultado2 = null;
				
				for (int i= cadena.length()-1; i>=0; i--){
					resultado2 = resultado2 + cadena.charAt(i);		
					modelo.put("resultado", resultado2);
					}
				break;
				
			case "contarCaracteres":
				Integer resultado3 = null;
				
				resultado3 = cadena.length();
				modelo.put("resultado", resultado3);
				break;
				
			default:
				resultado = operacionInvalida;
				modelo.put("resultado", resultado);
		}
		
		
		
		return new ModelAndView("punto6",modelo);
	}
}
