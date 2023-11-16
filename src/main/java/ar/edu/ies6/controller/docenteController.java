package ar.edu.ies6.controller;
	import java.time.LocalDate;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.servlet.ModelAndView;
	import ar.edu.ies6.model.docente;
import ar.edu.ies6.util.ListadoDocente;
	@Controller
		public class docenteController {
			
			//mostrar el formulario
			@GetMapping("/formulario")
			public ModelAndView cargarDocente() {
			
				docente doc = new docente();

				doc.setFechaNacimiento(LocalDate.parse("2000, 2, 18"));
				
				System.out.println("edad: "+ doc.getEdad());
			
				//mandar el objeto a la vista 
	        ModelAndView modelView= new ModelAndView ("index");
	        
			modelView.addObject ("docente", doc);
			return modelView;
	        }
			// procesar los datos del formulario
	        @PostMapping("/docente/submitForm")
	        public String procesarFormulario(docente docente) {
	        // Lógica para procesar el formulario (guardar en la base de datos, etc.)
	        return "confirmacion";
	        }
	    
	       @PostMapping("/cargaDocente")
	       public ModelAndView cargarDocente (@ModelAttribute ("docente") docente docete) {
	    	
	     //TODO guardar al docente en una list
	    	ListadoDocente.getListado().add(docete);
	    	
	        // cargar al docente al array list 
	        ModelAndView modelView = new ModelAndView("listadoDocente");
	    
			//TODO enviar el listado a la tabla
	        modelView.addObject("listado",ListadoDocente.getListado());
	         return modelView;
	       }
	       

}
