package com.nt.start.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.start.Entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
