package com.abyeti.RestApi;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("rest")
public class SuperheroResources {
	private static Map<Integer, Superhero> superheroAsMap = new HashMap<>();
	private static Set<String> superheroNameAsList = new HashSet<>();
	static {
		List<String> po = new ArrayList<String>();
		po.add("Chutki");
		po.add("Everything");
		Superhero s = new Superhero("Thanos", po, 4.5);
		superheroAsMap.put(s.getId(), s);
		superheroNameAsList.add(s.getName());
	}

	@Path("/addsuperhero")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Superhero addSuperhero(@FormParam("name") String name, @FormParam("superpowers") String superpowers,
			@FormParam("rating") double rating) {
		if (superheroNameAsList.contains(name))
			return null;
		else {
			String[] arrOfStr = superpowers.split(",");
			List<String> sp = new ArrayList<>(Arrays.asList(arrOfStr));
			Superhero sh=new Superhero(name,sp,rating);
			superheroAsMap.put(sh.getId(),sh);
			superheroNameAsList.add(name);
			return sh;
		}
	}

	@GET
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Superhero getSuperhero(@FormParam("id") int id) {
		System.out.println("find Superhero method called");
		if (superheroAsMap.containsKey(id))
			return superheroAsMap.get(id);
		return null;
	}

	@GET
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteSuperhero(@FormParam("id") int id) {
		System.out.println("delete Superhero method called");
		if (superheroAsMap.containsKey(id)) {
			superheroAsMap.remove(id);
			return "Successfully deleted";
		}
		return "Already deleted";
	}

	@GET
	@Path("/common")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Superhero> getCommonSuperhero(@FormParam("power") String power) {
		System.out.println("Common power Superhero method called");
		List<Superhero> superHeroList = new ArrayList<>();
		for (int id : superheroAsMap.keySet()) {
			if (superheroAsMap.get(id).getSuperpower().contains(power)) {
				superHeroList.add(superheroAsMap.get(id));
			}
		}
		return superHeroList;
	}
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Superhero> getAll() {
		System.out.println("Common power Superhero method called");
		List<Superhero> superHeroList = new ArrayList<>();
		for (int id : superheroAsMap.keySet()) {
				superHeroList.add(superheroAsMap.get(id));
		}
		return superHeroList;
	}

}
