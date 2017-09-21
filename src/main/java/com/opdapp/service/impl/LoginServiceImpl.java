package com.opdapp.service.impl;

import com.opdapp.model.admin.MedSysUser;
import com.opdapp.repository.MedSysUserRepository;
import com.opdapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService
{
    @Autowired
    private MedSysUserRepository medSysUserRepository;

    @Override
    public MedSysUser login(final MedSysUser user)
    {
        MedSysUser dbUser = medSysUserRepository.findByUsername(user.getUsername()).get(0);
        if (dbUser.getPassword().equals(user.getPassword()))
        {
            return dbUser;
        }
        dbUser = new MedSysUser();
        dbUser.setId(-1);
        return dbUser;
    }
}
