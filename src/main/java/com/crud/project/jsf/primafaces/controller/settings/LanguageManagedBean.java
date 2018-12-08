package com.crud.project.jsf.primafaces.controller.settings;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "languageManagedBean")
public class LanguageManagedBean implements Serializable{

	private static final long serialVersionUID = -8896731027608352495L;

	private static Map<String, Locale> countries;
	
	private String localeCode;
	
	static {
		countries = new LinkedHashMap<String, Locale>();
		countries.put("English", new Locale("en"));
		countries.put("Português", new Locale("pt"));
	}
	
	public LanguageManagedBean() {

	}
	
	public Map<String, Locale> getCountries() {
		return countries;
	}
	
	public void localeCodeChanged(AjaxBehaviorEvent e) {
		String newLocaleValue = ((SelectOneMenu) e.getSource()).getValue() + "";
		
		for(Entry<String, Locale> entry : countries.entrySet()) {
			if(entry.getValue().toString().equals(newLocaleValue)) {
				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
			}
		}
	}

	public String getLocaleCode() {
		if((this.localeCode == null) && (FacesContext.getCurrentInstance().getViewRoot() != null) && 
				(FacesContext.getCurrentInstance().getViewRoot().getLocale() != null)) {
			this.localeCode = FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
		}
		return this.localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}
}
