package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Account;


@Repository
public interface DAO_Account extends JpaRepository<Account, String>{
	
	@Query("Select Distinct ar.account From Authority ar where ar.role.id IN ('DIRE','STAF')")
	List<Account> getAdministrators();

    @Query("select a from Account a where a.email like ?1")
    public Optional<Account> findByEmail(String email);
	@Query(value="Select a.Username, a.Fullname, a.email, a.photo, "
			+ "sum(odt.price * odt.quantity) as totalPayment "
			+ "From accounts a inner join cart o on a.Username = o.Username "
			+ "inner join Odersdetails odt on o.Id = odt.order_id "
			+ "Group by a.Username, a.Fullname, a.email, a.photo "
			+ "order by totalPayment desc",nativeQuery = true)
	List<Object[]> top10Customer();
}
