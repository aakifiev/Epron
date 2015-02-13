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

@SuppressWarnings("serial")
@Named
@RequestScoped
public class PersonInfo implements Serializable{
	
	@Inject
	PersonService personService;
	
	@Inject
	PersonParams personParams;
	
	private VPerson model;
	
	public VPerson getModel(){
		Map<String, String> params = 
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String personId = params.get("pid");
		if (model == null)
			model = personService.getVPersonById(personId);
		return model;
	}
	
	public String switchEdit(){
		personParams.setEdit(!personParams.isEdit());
		return null;
	}

}
