package com.opdapp.service.impl;

import com.opdapp.model.admin.MedSysUser;
import com.opdapp.repository.MedSysUserRepository;
import com.opdapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService
{
    @Autowired
    private MedSysUserRepository medSysUserRepository;

    @Override
    public MedSysUser login(final MedSysUser user)
    {
        List<MedSysUser> byUsername = medSysUserRepository.findByUsername(user.getUsername());

        if (!byUsername.isEmpty() && byUsername.get(0).getPassword().equals(user.getPassword()))
        {
            return byUsername.get(0);
        }
        MedSysUser dbUser = new MedSysUser();
        dbUser.setId(-1);
        return dbUser;
    }
}
