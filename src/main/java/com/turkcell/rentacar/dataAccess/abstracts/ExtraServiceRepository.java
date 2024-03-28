package com.turkcell.rentacar.dataAccess.abstracts;

import com.turkcell.rentacar.entities.concretes.ExtraService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtraServiceRepository extends JpaRepository<ExtraService,Integer> {
}
