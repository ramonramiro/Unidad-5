package mx.utng.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.utng.practice.model.Supplier;

public interface SupplierRepository 
	extends JpaRepository<Supplier, Long>{

	@Query("Select supplier from Supplier supplier where supplier.name=:name")
	Supplier findByName(@Param("name") String name);
	
}
