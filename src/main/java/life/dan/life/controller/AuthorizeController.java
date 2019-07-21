package life.dan.life.controller;

import life.dan.life.dto.AccessTokenDTO;
import life.dan.life.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id("e74bc886eec3602db39d");
        accessTokenDTO.setClient_secret("0a7f5ae0e144c59b1f254bd8a7ecf38540ad6d3f");
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
