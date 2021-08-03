package com.luer.springsecurity;

/*

import com.luer.operator.bean.Operator;
import com.luer.operator.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserService implements UserDetailsService {

    @Autowired
    OperatorService operatorService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Operator operator = operatorService.selectOperatorByUsername(username);
        if (operator == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("username:"+username);
        System.out.println("username:"+operator.getUsername()+";password:"+operator.getPassword());
        return operator;
    }
}
*/
