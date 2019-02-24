package com.Luhe.Luhe.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Luhe.Luhe.security.Role;

public interface RoleRepository extends  CrudRepository<Role, Long> {
	Role findByRole(String role);
}
