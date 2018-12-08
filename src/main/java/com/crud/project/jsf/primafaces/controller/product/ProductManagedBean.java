package com.crud.project.jsf.primafaces.controller.product;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import com.crud.project.jsf.primafaces.base.BaseBeans;
import com.crud.project.jsf.primafaces.model.ProductEntity;
import com.crud.project.jsf.primafaces.model.repositories.IProductRepository;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "productManagedBean")
public class ProductManagedBean  extends BaseBeans{

	private static final long serialVersionUID = 1035526122627326306L;
	
	private static final Logger LOGGER = Logger.getLogger(ProductManagedBean.class);
	
	@Inject
	private IProductRepository productRepository;
	
	private List<ProductEntity> products;
	
	private ProductEntity selectedProduct;
	
	private Long id;

	public ProductManagedBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void onLoad() {
		this.products = this.productRepository.findAll();
	}
	
	public void selectProduct(SelectEvent event) {
		try {
			if(event.getObject() != null) {
				this.selectedProduct = (ProductEntity) event.getObject();
			}
		}catch (Exception e) {
			this.selectedProduct = null;
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	public void unSelectProduct() {
		this.selectedProduct = null;
	}
	
	public void delete() {
		if(this.selectedProduct != null) {
			this.productRepository.delete(this.selectedProduct.getId());
		}
	}

	//Getter and Setter
	
	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public ProductEntity getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(ProductEntity selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}