package main.java.service.params;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PersonParams implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean edit = true;

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("created");
	}
	
	@PreDestroy
	public void fin(){
		System.out.println("destriyed");
	}

}
