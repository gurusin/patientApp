package com.opdapp.repository;

import com.opdapp.model.admin.MedSysUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedSysUserRepository extends CrudRepository<MedSysUser, Long> {

    List<MedSysUser> findByUsername(final String username);
}
