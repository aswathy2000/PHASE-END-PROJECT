package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.pojo.Vaccinationcenter;

@Repository
public interface VaccinationcenterRepository extends JpaRepository<Vaccinationcenter, Integer>{


}
