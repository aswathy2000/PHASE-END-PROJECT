package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.pojo.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>
{
	Admin findByUsernameAndPassword(String username, String password);
}
