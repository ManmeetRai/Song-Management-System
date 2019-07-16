package ca.sheridancollege.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Contacts;
import ca.sheridancollege.dao.Dao;


@Controller
public class test {
	Dao dao = new Dao();

	@RequestMapping("/")
	public String showHome(Model model) {
	return "home";
	}
	
	
	@RequestMapping("/register")
	public String showRegistration(Model model) {
		Contacts d = new Contacts();
		model.addAttribute("Contacts", d);
		return "register";
	}
	
//	
	@RequestMapping("savecontacts")
	public String saveGame(Model model, @ModelAttribute Contacts contact){
		dao.addSong(contact);
		model.addAttribute("Contacts", new Contacts());
		return "register";
	}
	@RequestMapping("/viewContacts")
	public String showSongs(Model model) {
		List<Contacts> songs = dao.querySongs();
		model.addAttribute("songlist", songs);
		return "viewContacts";
	}
	@RequestMapping(value="editsong/{id}")
	public String editGame(Model model, @PathVariable int id) {
			Contacts song = dao.queryByID(id);
		if (song.getId() != 0) {
			dao.deleteSong(id);
		}
		model.addAttribute("Contacts", song);
		return "register";
	}
	
	@RequestMapping(value="deletesong/{id}")
	public String deleteGame(Model model, @PathVariable int id) {
			Contacts song = dao.queryByID(id);
		if (song.getId() != 0) {
			dao.deleteSong(id);
		}
		return "viewContacts";
	}
	@RequestMapping("/search")
	public String showSearch(Model model) {
		return "search";
	}
	@RequestMapping("/contactSearch")
	public String dogSearch(Model model, @RequestParam String searchBy, @RequestParam String inputText) {
		System.out.println(searchBy);
		System.out.println(inputText);
		List<Contacts> contactlist  = dao.querySearchByValueCriteria(searchBy, inputText);
		System.out.println(contactlist);
		model.addAttribute("contactlist", contactlist);
		return "search";
	}
}
