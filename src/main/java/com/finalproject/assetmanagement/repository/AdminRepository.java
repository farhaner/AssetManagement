package com.finalproject.assetmanagement.repository;

import com.finalproject.assetmanagement.entity.Admin;
import com.finalproject.assetmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

}
