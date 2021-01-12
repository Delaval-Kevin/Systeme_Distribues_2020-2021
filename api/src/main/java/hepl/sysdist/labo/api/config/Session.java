//Auteur : HENDRICK Samuel                                                                                              
//Projet : api                               
//Date de la création : 12/01/2021

package hepl.sysdist.labo.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.HashMap;
import java.util.Random;

@Component
public class Session {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HashMap<String, Integer> usersId;

    public int CheckUserConnection(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        Principal principal = httpServletRequest.getUserPrincipal();

        if(principal != null)
        {
            System.out.println(principal.getName());

            if(usersId.containsKey(principal.getName()))
            {
                int id = usersId.get(principal.getName());
                int cookiesId = getUserId(httpServletRequest);
                if(id != cookiesId)
                {
                    httpServletResponse.addCookie(new Cookie("user_id", Integer.toString(id)));
                    restTemplate.getForObject("http://cart/swap/"+cookiesId+"/"+id, Object.class);
                }
                return id;
            }
            return -1;

        }
        else
        {
            System.out.println("visiteur");
            if(getUserId(httpServletRequest) == -1)
            {
                int min = 4;
                int max = 100;
                Random rand = new Random();
                int randomNum = rand.nextInt((max - min) + 1) + min;
                httpServletResponse.addCookie(new Cookie("user_id", Integer.toString(randomNum)));
                return randomNum;
            }
            else
            {
                return getUserId(httpServletRequest);
            }
        }
    }

    public int getUserId(HttpServletRequest httpServletRequest)
    {
        Cookie cookie = WebUtils.getCookie(httpServletRequest, "user_id");
        return cookie == null ? -1 : Integer.parseInt(cookie.getValue());
    }

}
