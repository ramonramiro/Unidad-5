package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;


import mx.utng.practice.model.Supplier;
import mx.utng.practice.repository.SupplierRepository;

@Named
@ViewScoped
public class SupplierController {
	@Autowired
	private SupplierRepository supplierRepository;
	private Supplier supplier = new Supplier();
	private List<Supplier> suppliers;
	private boolean editMode = false; 
	
	
	@PostConstruct
	public void init(){
		setSuppliers(supplierRepository.findAll());
	}
	
	public void save(){
		supplierRepository.save(supplier);
		if(!editMode){
			getSuppliers().add(supplier);
		}
		supplier = new Supplier();
		setEditMode(false);
	}
	
	public void delete(Supplier supplier){
		supplierRepository.delete(supplier);
		suppliers.remove(supplier);
	}
	
	public void update(Supplier supplier){
		setSupplier(supplier);
		setEditMode(true);
	}
	
	public void cancel(){
		supplier = new Supplier();
		setEditMode(false);
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	
	public boolean isEditMode(){
		return editMode;
	}
	
	public void setEditMode(boolean editMode){
		this.editMode = editMode;
	}
	
	
	
}
