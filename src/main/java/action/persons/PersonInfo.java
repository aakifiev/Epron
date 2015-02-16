package main.java.action.persons;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import main.java.model.immutable.VPerson;
import main.java.service.PersonService;
import main.java.service.params.PersonParams;
import main.java.ui.Nav;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class PersonInfo implements Serializable{
	
	@Inject
	PersonService personService;
	
	@Inject
	PersonParams personParams;
	
	@Inject
	Nav nav;
	
	private VPerson model;
	
	public VPerson getModel(){
		if (model == null){
			Map<String, String> params = 
					FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String personId = params.get("pid");
			if (personId == null || "".equals(personId)){
				personId = "1";
			}
			model = personService.getVPersonById(personId);
		}
		return model;
	}

}
