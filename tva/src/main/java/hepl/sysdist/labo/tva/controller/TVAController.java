package hepl.sysdist.labo.tva.controller;

import hepl.sysdist.labo.tva.model.TVAResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TVAController {

    @Autowired
    private HashMap<String, Float> tvaList;

    @GetMapping("/tva")
    public TVAResponse getTva(@RequestParam(defaultValue = "default") String category)
    {
        if(tvaList.containsKey(category))
        {
            return new TVAResponse(category, tvaList.get(category));
        }
        else
        {
            return new TVAResponse("default", tvaList.get("other"));
        }
    }

}
