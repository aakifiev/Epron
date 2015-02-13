package main.java.service.params;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PersonParams {
	
	private boolean edit;

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	@PostConstruct
	public void init(){
		this.edit = false;
	}
	
	

}
