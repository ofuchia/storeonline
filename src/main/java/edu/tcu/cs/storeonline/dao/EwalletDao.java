package edu.tcu.cs.storeonline.dao;

import edu.tcu.cs.storeonline.domain.Ewallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EwalletDao extends JpaRepository<Ewallet, String> {
}
