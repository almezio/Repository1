package controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entities.*;
import model.*;

@Controller
@RequestMapping(value="categoria")
public class CategoriaController {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");	
		CategoriaDao beanCategoriaDao=(CategoriaDao) context.getBean("categoriaDaoImpl");
		ArticoloDao  beanArticoloDao=(ArticoloDao) context.getBean("articoloDaoImpl");
		
		@RequestMapping("/template")
		@GET
		public String template(){			
			return "index";
		}
		
		@RequestMapping("/main")
		@GET
		public String main(@RequestParam(value="op", required=true) String operation,ModelMap modelMap){
			String tipo="";
			String viewReturn="";						
			//Controllo il tipo di operazione da eseguire ed in base
			//al parametro op di input della richiesta imposto il formAction opportuno
			//e poi lo passo al form(tramite il model)
			switch (operation){
				case "creaCategoria":
				System.out.println("Operazione scelta: creazione categoria");
				operation="createCategoria.html";
				tipo="CATEGORIA";
				break;
				
			case "creaArticolo":
				System.out.println("Operazione scelta: creazione articolo");
				operation="createArticolo.html";
				tipo="ARTICOLO";
				break;	
						
			case "delCategoria":
				System.out.println("Operazione scelta: cancellazione");
				operation="deleteCategoria.html";		
				tipo="CATEGORIA";
				break;	
						
			case "updCategoria":
				System.out.println("Operazione scelta: aggiornamento");
				operation="updateCategoria.html";		
				tipo="CATEGORIA";
				break;	
						
			case "selCategoriaId":
				System.out.println("Operazione scelta: ricerca per id");
				operation="getCategoriaFromId.html";			
				tipo="CATEGORIA";
				break;
				
			case "creaCatConArt":
				System.out.println("Operazione scelta: Crea Categoria con Articoli");
				operation="creaCatConArt.html";			
				tipo="CATEGORIA";
				break;
				
			case "selArtFromCat":
				System.out.println("Operazione scelta: Cerca articoli da categoria");
				operation="getArticoliFromCategoria.html";			
				tipo="RICERCA_ARTICOLO";
				break;
				
			case "selCategorie":
				System.out.println("Operazione scelta: Cerca tutte le categorie");
				operation="getCategorie.html";			
				tipo="CATEGORIA";
				break;	
			}	
			
			modelMap.put("operation",operation);
			System.out.println("Operation:"+operation);
			if (tipo.equals("CATEGORIA")){
				modelMap.put("categoria", new Categoria());
				viewReturn="main_categoria";
			}else{
				if (tipo.equals("ARTICOLO")){
					List<Categoria> categorie=beanCategoriaDao.getCategorie();
					modelMap.put("categorie", categorie);
					modelMap.put("articolo", new Articolo());
					viewReturn="main_articolo";
				}else if (tipo.equals("RICERCA_ARTICOLO")){					
					modelMap.put("articolo", new Articolo());
					viewReturn="main_ricercaArticolo";
				}
			}
			return viewReturn;
		}
				
		@RequestMapping("/createCategoria")
		@POST
		public String createCategoria(@ModelAttribute("categoria") Categoria categoria,BindingResult errors,ModelMap modelMap,HttpSession session){
			//Creo la categoria con i valori passati dal form
			Categoria categoriaDao=beanCategoriaDao.createCategoria(categoria);
			
			if (categoriaDao!=null){
				//categoria creata
				modelMap.put("message","Categoria creata");
				modelMap.put("categoria",categoriaDao);				
			}else{
				modelMap.put("message","Nessuna categoria creata");
			}
			return "message";
		}
		
		@RequestMapping("/createArticolo")
		@POST
		public String createArticolo(@ModelAttribute("articolo") Articolo articolo,@RequestParam("categoria") Long idCategoria,ModelMap modelMap,HttpSession session){
			//Creo l'articolo con i valori passati dal form e la categoria letta a partire dal
			//parametro di input idCategoria preso dal form
			Categoria categoria= beanCategoriaDao.getCategoriaFromId(idCategoria).get(0);
			articolo.setCategoria(categoria);
			Articolo articoloDao=beanArticoloDao.createArticolo(articolo);
			
			if (articoloDao!=null){
				//articolo creato
				modelMap.put("message","Articolo creato");
				modelMap.put("articolo",articoloDao);				
			}else{
				modelMap.put("message","Nessun articolo creato");
			}
			return "message";
		}
		
		@RequestMapping("/updateCategoria")
		@POST
		public String updateCategoria(@ModelAttribute(value="categoria")Categoria categoria,ModelMap modelMap,HttpSession session){
			int rowUpdated=beanCategoriaDao.updateCategoria(categoria);
			if (rowUpdated>0){
				//categoria aggiornata
				modelMap.put("message","Categoria aggiornata");
			}else{
				modelMap.put("message","Nessuna categoria aggiornata");
			}
			return "message";
		}
		
		@RequestMapping("/deleteCategoria")
		@POST
		public String deleteCategoria(@RequestParam(value="idCategoria", required=true) int idCategoria,ModelMap modelMap,HttpSession session){	
			int rowDeleted=beanCategoriaDao.deleteCategoria(idCategoria);
			if (rowDeleted>0){
				//categoria eliminata
				modelMap.put("message","Categoria eliminata");
			}else{
				modelMap.put("message","Nessuna categoria eliminata");
			}
			
			return "message";
		}
		
		
		/*
		 *  Questo metodo è un esempio di come viene creata un oggetto Categoria
		 *  (con relativo inserimento sul db della riga) e contestualmente vengono inseriti
		 *  una serie di articoli relazionati alla categoria(quindi anche inserimenti di righe di articoli nella tabella TAB_ARTICOLO)
		 * 
		 */
		@RequestMapping("/creaCatConArt")
		@POST
		public String creaCatConArt(@ModelAttribute(value="categoria")Categoria categoria,ModelMap modelMap,HttpSession session){
			//Creazione di tre articoli
			Articolo articolo1=new Articolo("ARTICOLO2","12");
			Articolo articolo2=new Articolo("ARTICOLO3","32");
			Articolo articolo3=new Articolo("ARTICOLO4","55");
			
			//Aggiunti i 3 articoli all'array di articoli
			Set<Articolo> articoli= new HashSet<Articolo>();
			articoli.add(articolo1);
			articoli.add(articolo2);
			articoli.add(articolo3);
			
			//Chiamo il metodo del bean che provvede a inserire la riga della categoria e dei relativi articoli
			Categoria categoriaDao=beanCategoriaDao.createCategConArticoli(categoria,articoli);
			
			if (categoriaDao!=null){
				//categoria creata
				modelMap.put("message","Categoria creata");
				modelMap.put("categoria",categoriaDao);				
			}else{
				modelMap.put("message","Nessuna categoria creata");
			}
			return "message";
		}	
		
		@RequestMapping("/getArticoliFromCategoria")
		@POST
		public String getArticoliFromCategoria(@RequestParam(value="idCategoria", required=true) Long idCategoria,ModelMap modelMap){
			//Cerco se esistono	articoli per la categoria di input
			List<Articolo> articoliDao=beanArticoloDao.getArticoliFromCategoria(idCategoria);
			if (!articoliDao.isEmpty()){	
				modelMap.put("message","Articoli trovati");
				modelMap.put("articoli",articoliDao);
				return "show_articoli";
			}else{
				modelMap.put("message","Nessun articolo trovato");
				return "message";
			}
		}
		
		@RequestMapping("/getCategorie")
		@POST
		public String getCategorie(@ModelAttribute(value="categoria")Categoria categoria,ModelMap modelMap){
			//Cerco se esistono	articoli per la categoria di input
			List<Categoria> categorieDao=beanCategoriaDao.getCategorie();
			if (!categorieDao.isEmpty()){	
				modelMap.put("message","Categorie trovate");
				modelMap.put("categorie",categorieDao);
				return "show";
			}else{
				modelMap.put("message","Nessun articolo trovato");
				return "message";
			}
		}
}
