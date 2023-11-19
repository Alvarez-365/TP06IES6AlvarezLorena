package ar.edu.ies6.controller;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.ies6.model.docente;
import ar.edu.ies6.service.DocenteService;
import ar.edu.ies6.util.ListadoDocente;
	
@Controller
		public class docenteController {
			
			
				@Autowired 
				docente doc;
				@Autowired
				DocenteService docenteService;
				
				
				//mostrar el formulario
				@GetMapping("/formulario")
				public ModelAndView cargarDocente() {
				
					
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
	  		 
	 	  // metodo para eliminar un registro
	        @GetMapping("/eliminarDocente/{dni}") 
	 	   public ModelAndView eliminarDocente(@PathVariable Integer dni) {
	     	  
	     	     //eliminarUnProducto (id);
	     	   for (int i=0; i<ListadoDocente.getListado().size();i++) {
	     		// System.out.printlh("aaaaaa"dni);
	     		   if (ListadoDocente.getListado().get(i).getdni().equals(dni));{
	     			   //ListadoDocente.getListado().get(i).setEstado(false);
	     			   ListadoDocente.getListado().remove(i);
	     			   //System.out.printlh{"bbbbbbbb"+ListadoDocente.getListado().size()};
	     		   }
	     	   }
	     	      ModelAndView modelView = new ModelAndView("listadoDocente");
	     	   modelView.addObject("listado",ListadoDocente.getListado());
	     	   
	     	   return modelView;
	     }
	        //metodo para mostrar listado
	        @PostMapping("/mostrarListado")
	        public ModelAndView mostrarDocente() {
	     	   
	     	   ModelAndView listado = new ModelAndView("listadoDocente");
	     	    listado.addObject("listado", ListadoDocente.getListado());
	     	    return listado;
	     	}
	        //metodo para modificar un registro 
	        @GetMapping("/modificarDocente/{dni}") 
	 	   public ModelAndView modificarDocente(@PathVariable Integer dni) throws Exception {
	     	   ModelAndView modificarDocente = new ModelAndView("index");
	     	   modificarDocente.addObject("nuevoDocente",docenteService.encontrarUnDocente(dni));
	     	   return modificarDocente;
	        }
	        
	        @PostMapping("/modificarDocente")
	        public ModelAndView modificarUnDocente(@ModelAttribute("docente")docente docente) {
	     	   ModelAndView modelView = new ModelAndView("listadoDocente");
	     	   
	     	   modelView.addObject("listado",docenteService.buscarTodosDocente());
	     	   return modelView;
	        }
	         
	 	}
