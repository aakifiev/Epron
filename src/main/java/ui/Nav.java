package main.java.ui;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewParameter;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewDeclarationLanguage;
import javax.faces.view.ViewMetadata;
import javax.inject.Named;

@Named
@RequestScoped
public class Nav{
    public static class Page {
    	
        private final String viewId;
        private final Map<String, String> params;
 
        private Page(String viewId) {
            this.viewId = viewId;
            this.params = new LinkedHashMap<String, String>();
        }
 
        private Page(String viewId, Map<String, String> params) {
            this.viewId = viewId;
            this.params = params;
        }
 
        public Page redirect() {
            return includeParam("faces-redirect", "true");
        }
 
        public Page includeViewParams() {
            return includeParam("includeViewParams", "true");
        }
 
        public Page includeViewParam(String name) {
            // Getting the metadata facet of the view
            FacesContext ctx = FacesContext.getCurrentInstance();
            ViewDeclarationLanguage vdl = ctx.getApplication().getViewHandler()
                  .getViewDeclarationLanguage(ctx, viewId);
            ViewMetadata viewMetadata = vdl.getViewMetadata(ctx, viewId);
            UIViewRoot viewRoot = viewMetadata.createMetadataView(ctx);
            UIComponent metadataFacet = viewRoot.getFacet(
                  UIViewRoot.METADATA_FACET_NAME);
 
            // Looking for a view parameter with the specified name
            UIViewParameter viewParam = null;
            for (UIComponent child : metadataFacet.getChildren()) {
                if (child instanceof UIViewParameter) {
                    UIViewParameter tempViewParam = (UIViewParameter) child;
                    if (name.equals(tempViewParam.getName())) {
                        viewParam = tempViewParam;
                        break;
                    }
                }
            }
 
            if (viewParam == null) {
                throw new FacesException("Unknown parameter: '" + name +
                     "' for view: " + viewId);
            }
 
            // Getting the value
            String value = viewParam.getStringValue(ctx);
            return includeParam(name, value);
        }
 
        public Page includeParam(String name, String value) {
            Map<String, String> newParams = new LinkedHashMap<String, String>(params);
            if (value == null){
            	return new Page(viewId, params);
            } else {
            	newParams.put(name, value);
                return new Page(viewId, newParams);
            }
        }
 
        private String s() {
            StringBuilder sb = new StringBuilder();
            sb.append(viewId);
 
            String paramSeparator = "?";
            for (Map.Entry<String, String> nameValue : params.entrySet()) {
                sb.append(paramSeparator).append(nameValue.getKey())
                      .append("=").append(nameValue.getValue());
                paramSeparator = "&amp;";
            }
 
            return sb.toString();
        }
        
        private String sc() {
            StringBuilder sb = new StringBuilder(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
            sb.append(viewId);
 
            String paramSeparator = "?";
            for (Map.Entry<String, String> nameValue : params.entrySet()) {
                sb.append(paramSeparator).append(nameValue.getKey())
                      .append("=").append(nameValue.getValue());
                paramSeparator = "&amp;";
            }
 
            return sb.toString();
        }
 
        public String getS() { 
        	return s(); 
        }
        public String getSc() { 
        	return sc(); 
        }
    }
    
    private final Page thisPage = new Page(NAV_PAGES.EPRON_THIS_PAGE.getView());
    
    //amirs menu
    //amirs main page
    private final Page epronMain = new Page(NAV_PAGES.EPRON_MAIN_PAGE.getView());
    
    private final Page epronPersons = new Page(NAV_PAGES.EPRON_PERSONS_PAGE.getView());
    private final Page epronPersonInfo = new Page(NAV_PAGES.EPRON_PERSON_INFO_PAGE.getView());
    
	public Page getThisPage() {
		return thisPage;
	}

	public Page getEpronMain() {
		return epronMain;
	}
	
	public Page getEpronPersons() {
		return epronPersons;
	}
	
	public Page getEpronPersonInfo() {
		return epronPersonInfo;
	}
    	
    // other getters ...
}
