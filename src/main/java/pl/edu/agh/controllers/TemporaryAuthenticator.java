package pl.edu.agh.controllers;

import org.jinstagram.Instagram;
import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.model.Token;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;
import org.jinstagram.entity.tags.TagInfoData;
import org.jinstagram.exceptions.InstagramException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by lmarek on 14.03.16.
 */
@RestController
public class TemporaryAuthenticator {
    protected final InstagramService service = new InstagramAuthService()
            .apiKey("d83c1b987cb847de8a705c53c64e87d3")
            .apiSecret("0036a646526e453bb36bf75aa59423f9")
            .callback("http://localhost:8080/authorized")
            .scope("public_content")
            .build();

    protected Token accessToken;

    @RequestMapping("/authorize")
    public ModelAndView getAuthUrl(){
        return new ModelAndView("redirect:"+service.getAuthorizationUrl());
    }

    @RequestMapping("/authorized")
    public boolean receiveCode(@RequestParam Map<String,String> params){
        if(params.containsKey("code")) {
            Verifier verifier = new Verifier(params.get("code"));
            accessToken = service.getAccessToken(verifier);
            return true;
        }
        else
            return false;
    }

    @RequestMapping("/isauthorized")
    public boolean checkAuthorization(){
        return accessToken == null;
    }

    @RequestMapping("/searchbytag")
    public List<String> searchByTag(@RequestParam(name = "tag") String tag){
        Instagram instagram = new Instagram(accessToken);
        try {
            return instagram.searchTags(tag).getTagList().stream().map(x -> x.getTagName()).collect(Collectors.toList());
        } catch (InstagramException e) {
            e.printStackTrace();
        }
        return null;
    }
}
