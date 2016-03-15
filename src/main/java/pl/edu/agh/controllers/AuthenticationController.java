package pl.edu.agh.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lmarek on 14.03.16.
 */
@RestController
public class AuthenticationController {

    protected String token;

    @RequestMapping("/token")
    public String receiveToken(@RequestParam(name = "token") String token){
        this.token = token;
        return "Token set";
    }


}
