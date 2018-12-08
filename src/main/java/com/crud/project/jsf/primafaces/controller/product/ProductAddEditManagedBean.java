package com.crud.project.jsf.primafaces.controller.product;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import com.crud.project.jsf.primafaces.base.BaseBeans;
import com.crud.project.jsf.primafaces.model.ProductEntity;
import com.crud.project.jsf.primafaces.model.repositories.IProductRepository;

@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "productAddEditManagedBean")
public class ProductAddEditManagedBean extends BaseBeans{

	private static final long serialVersionUID = 1605732210689946008L;
	
	@Inject
	private ProductManagedBean managedBeanProduct;
	
	@Inject
	private IProductRepository productRepository;
	
	@Inject
	private FacesContext context;
	
	private ProductEntity product;
	
	private String title;

	public ProductAddEditManagedBean() {
		this.product = new ProductEntity();
	}
	
	public void add() {
		this.title = getResourceProperty("labels", "product_add");
	}
	
	public void update() {
		this.title = getResourceProperty("labels", "product_update");
		this.product = managedBeanProduct.getSelectedProduct();
	}
	
	public void save() {
		if(this.product != null) {
			if(this.product.getId() == null) {
				productRepository.save(this.product);
			}else {
				productRepository.save(this.product);
			}
		}
	}
	
	public void cancel() {
		this.managedBeanProduct.unSelectProduct();
	}
	
	public String getResourceProperty(String resource, String label) {
		Application application = this.context.getApplication();
		ResourceBundle bundle = application.getResourceBundle(this.context, resource);

		return bundle.getString(label);
	}
	
	//Getter and Setter

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
