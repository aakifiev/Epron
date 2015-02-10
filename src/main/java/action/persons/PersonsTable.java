package main.java.action.persons;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import main.java.model.immutable.VPerson;
import main.java.service.PersonService;
import main.java.ui.Nav;


@SuppressWarnings("serial")
@Named
@RequestScoped
public class PersonsTable implements Serializable{
	
	@Inject
	PersonService personService;
	
	@Inject
	Nav nav;
	
	public List<VPerson> getAllPersons(){
		return personService.getAllVPersons();
	}
	
	public String getPersonUrl(){
		return nav.getEpronPersonInfo().getS();
	}
}
