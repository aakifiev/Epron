package main.java.ui;


public enum NAV_PAGES {
	EPRON_THIS_PAGE(""),
	/******************************************************
	 
	 *************************************************** */
	//main page
	EPRON_MAIN_PAGE("/index.xhtml"),
	
	
	EPRON_PERSONS_PAGE("/persons/persons.xhtml"),
	EPRON_PERSON_INFO_PAGE("/persons/personInfo.xhtml")
	;
	private final String view;
	NAV_PAGES(String view){
		this.view = view;
	}
	
	public String getView(){
		return view;
	}
}