package CRM.Service.repository;

import CRM.Service.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("SELECT c FROM Customer c WHERE (:deleted IS NULL OR c.deleted = :deleted)")
    Page<Customer> findByActive(Boolean deleted, Pageable pageable);


}
