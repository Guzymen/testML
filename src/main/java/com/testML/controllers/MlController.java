package com.testML.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.testML.model.Dna;
import com.testML.services.IMutantService;

@Controller
public class MlController {
    
    @Autowired
    IMutantService mutant;
    
    @RequestMapping(value="/mutant/", method = RequestMethod.POST)
    public ResponseEntity<Void> isMutant(@RequestBody Dna dna) {
        if(dna == null)
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
        if(dna.getDna().length == 0 || dna.getDna().length < 4)
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
        boolean isMutant = mutant.isMutant(dna.getDna());
        if(isMutant)
            return new ResponseEntity<Void>(HttpStatus.OK);
        return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
    }
}
