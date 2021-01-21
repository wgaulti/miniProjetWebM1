package progWeb.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Character;
import model.Universe;

@Controller
public class MyController {
	
	private static int nbHello = 0;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public void hello(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		
		String s = "Hello "+ nbHello;
		nbHello ++;
		System.out.println("ici");
		response.getOutputStream().write(
				s.getBytes("UTF-8"));
	}
	
	
	
	@RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
	public void myFirstEndPoint(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		System.out.println("Hello Console");
		response.getOutputStream().write("hello".getBytes("UTF-8"));
	}

	@RequestMapping(value = "/helloWorld", method = RequestMethod.POST)
	public void myPostEndPoint(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		System.out.println("Bonjour Console");
		response.getOutputStream().write("bonjour".getBytes("UTF-8"));
	}
	
	@RequestMapping(value = "/helloWorldRedirect", method = RequestMethod.POST)
	public void redirectToHello(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		response.sendRedirect("/helloWorld");
	}

	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public void showParamFromGet(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		Map<String, String[]> param = request.getParameterMap();
		for (Object key : param.keySet()) {
			System.out.println("" + key + " : " + param.get(key)[0]);
		}
	}
	
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public void showParamFromPost(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		Map<String, String[]> param = request.getParameterMap();
		for (Object key : param.keySet()) {
			System.out.println("" + key + " : " + param.get(key)[0]);
		}
	}
	
	// Fonction qui récupère le personnage choisi et stocke ses infos dans des cookies
	@RequestMapping(value = "/character", method = RequestMethod.POST)
	public void choiceCharacter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String charName = request.getParameter("char-select");
		Character chosen = null;
		for (Character c : Universe.getJedis()) {
			if (c.getName().equals(charName)) {
				chosen = c;
			}
		}
		if (chosen != null) {
			response.setHeader("HP", "" + chosen.getHpMax());
			response.setHeader("attack", "" + chosen.getAttack());
			Cookie cookieName = new Cookie("name", charName);
			response.addCookie(cookieName);
			response.addCookie(new Cookie("maxHP", "" + chosen.getHpMax()));
			response.addCookie(new Cookie("HP", "" + chosen.getHpMax()));
			response.addCookie(new Cookie("attack", "" + chosen.getAttack()));
			response.addCookie(new Cookie("dodge", "" + chosen.getDodgePercent()));
			response.addCookie(new Cookie("img", chosen.getImg()));
		}
		response.sendRedirect("/nextFoe");
	}
	
	// Fonction qui envoie les infos du personnage dans le select de chooseCharacter.html (appelée avec l'ajax)
	@RequestMapping(value = "/showCharInfo", method = RequestMethod.POST)
	public @ResponseBody Character showCharInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String charName = request.getParameter("name");
		Character chosen = null;
		for (Character c : Universe.getJedis()) {
			if (c.getName().equals(charName)) {
				chosen = c;
			}
		}
		return chosen;
	}
	
	// Fonction qui effectue l'attaque de l'ennemi sur le personnage non appelée en cas d'esquive
	@RequestMapping(value = "/takeDammage", method = RequestMethod.GET)
	public void takeDammage(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		
		int damStr = 0;
		for (Cookie c : request.getCookies()) {
			
			if (c.getName().equals("foeAttack")) {
				damStr = Integer.parseInt(c.getValue());
			}
		}

		System.out.println(damStr);
		if (damStr != 0) {
			int dammage = damStr;
			int hp = 0;
			for (Cookie c : request.getCookies()) {

				if (c.getName().equals("HP")) {
					hp = Integer.parseInt(c.getValue());
				}
			}
			hp = (hp - dammage > 0) ? hp - dammage : 0;
			response.addCookie(new Cookie("HP", "" + hp));
		}
		response.sendRedirect("/takeDammageFoe");

	}
	
	// Fonction qui effectue l'attaque du personnage sur l'ennemi
	@RequestMapping(value = "/takeDammageFoe", method = RequestMethod.GET)
	public void takeDammageFoe(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {

		int damStrFoe = 0;
		for (Cookie c : request.getCookies()) {
			
			if (c.getName().equals("attack")) {
				damStrFoe = Integer.parseInt(c.getValue());
			}
		}
		System.out.println(damStrFoe);
		if (damStrFoe != 0) {
			int dammage = damStrFoe;
			int hp = 0;
			for (Cookie c : request.getCookies()) {

				if (c.getName().equals("foeHP")) {
					hp = Integer.parseInt(c.getValue());
				}
			}
			hp = (hp - dammage > 0) ? hp - dammage : 0;
			response.addCookie(new Cookie("foeHP", "" + hp));
		}
		response.sendRedirect("/showCharacter.html");

	}

	// Fonction qui stocke les information de l'ennemi suivant dans les cookies ennemis
	@RequestMapping(value = "/nextFoe", method = RequestMethod.GET)
	public void nextFoe(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
	
		System.out.println("nextFoe");
		int previousFoe = -1;
		for (Cookie c : request.getCookies()) {
			if (c.getName().equals("foeNumber")) {
				previousFoe = Integer.parseInt(c.getValue());
				response.getOutputStream().write("Nouvel ennemi".getBytes("UTF-8"));
			}
		}
		try {
			Character foe = Universe.getSiths().get(previousFoe + 1);
			response.addCookie(new Cookie("foeNumber", "" + (previousFoe + 1)));
			response.addCookie(new Cookie("foeName", foe.getName()));
			response.addCookie(new Cookie("foeMaxHP", "" + foe.getHpMax()));
			response.addCookie(new Cookie("foeHP", "" + foe.getHpMax()));
			response.addCookie(new Cookie("foeAttack", "" + foe.getAttack()));
			response.addCookie(new Cookie("foeImg", "" + foe.getImg()));
			
			response.sendRedirect("/showCharacter.html");
			
		} catch (IndexOutOfBoundsException e) {		
			response.sendRedirect("/gameFinished.html");
		}

	}
	
	// Fonction qui efface tous les cookies du site et permet de lancer une nouvelle partie
	@RequestMapping(value = "/newGame", method = RequestMethod.GET)
	public void newGame(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
	
		for (Cookie c : request.getCookies()) {
			c.setMaxAge(0);
			response.addCookie(c);
		}

		response.sendRedirect("/chooseCharacter.html");
	}
	
	

}
