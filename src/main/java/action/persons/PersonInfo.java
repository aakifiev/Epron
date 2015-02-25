package main.java.action.persons;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
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
	Nav nav;
	
	private VPerson model;
	
	private String mode;
	
	private String personId;
	
	private String modeButtonValue;
	
	
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
	
	public void Save(){
		
	}
	
	public String redirectForEdit(){
		Map<String, String> params = 
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		/*return nav.getEpronPersonInfo().includeParam("pid", params.get("pid"))
				.includeParam("mode", params.get("mode")).getSc();*/
		return nav.getEpronPersonInfo().getSc();
	}
	
	public String getMode(){
		if ("".equals(mode) || mode == null){
			Map<String, String> params = 
					FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			if ("edit".equals(params.get("mode"))){
				mode = "edit";
				modeButtonValue = "Save";
			}
			mode = "read";
			modeButtonValue = "Edit";
		}
		return mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
		if ("edit".equals(mode)){
			this.modeButtonValue = "Save";
		} else {
			this.modeButtonValue = "Edit";
		}
		
	}

	public String getModeButtonValue() {
		return modeButtonValue;
	}

	public void setModeButtonValue(String modeButtonValue) {
		this.modeButtonValue = modeButtonValue;
	}

	public String getPersonId() {
		if ("".equals(personId) || personId == null){
			Map<String, String> params = 
					FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			personId = params.get("pid");
		}
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

}
