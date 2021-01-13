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
public class Session
{
    /********************************/
    /*           Variables          */
    /********************************/
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HashMap<String, Integer> usersId;

    /********************************/
    /*           Methodes           */
    /********************************/
    public int CheckUserConnection(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        //recherche si user principal
        Principal principal = httpServletRequest.getUserPrincipal();

        if(principal != null)
        {
            System.out.println(principal.getName());

            //on vérifie si l'id correspond au nom
            if(usersId.containsKey(principal.getName()))
            {
                //on recupère les cookies du user
                int id = usersId.get(principal.getName());
                int cookiesId = getUserId(httpServletRequest);
                if(id != cookiesId)
                {
                    httpServletResponse.addCookie(new Cookie("user_id", Integer.toString(id)));
                    //ici permet de rajouter a notre cart se qu'on a ajouter en tant que visiteur
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
                //pour générer une valeur pour le visiteur, pour savoir distinguer les visiteurs
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
