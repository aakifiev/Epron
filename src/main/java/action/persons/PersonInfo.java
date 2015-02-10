package main.java.action.persons;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import main.java.model.immutable.VPerson;
import main.java.service.PersonService;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class PersonInfo implements Serializable{
	
	@Inject
	PersonService personService;
	
/*	@Inject
	@RequestParam ("pid")
	Instance<String> personId;*/
	
	private VPerson model;
	
	public VPerson getModel(){
		Map<String, String> params = 
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String personId = params.get("pid");
		if (model == null)
			model = personService.getVPersonById(personId);
		return model;
	}

}
