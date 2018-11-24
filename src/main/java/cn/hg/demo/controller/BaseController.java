package cn.hg.demo.controller;

import cn.hg.demo.dao.TokenMapper;
import cn.hg.demo.exception.TokenException;
import org.springframework.beans.factory.annotation.Autowired;

class BaseController {

    @Autowired
    private TokenMapper tokenMapper;

    void checkToken(String token) throws TokenException{
        if (tokenMapper.checkToken(token) != 1){
            throw  new TokenException();
        }
    }

}
