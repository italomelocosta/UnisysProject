/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novo.unisys.controller;

import com.novo.unisys.model.Parentjob;
import com.novo.unisys.service.ParentJobService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Italo
 */
@RestController
@RequestMapping("parentjob")
public class ParentJobController {

    @Autowired
    private ParentJobService parentjobService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getParentJobById(@PathVariable Long id) {
        Parentjob parentJob = parentjobService.findOne(id);
        return new ResponseEntity(parentJob, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Parentjob>> getParentJob() {
        return new ResponseEntity(parentjobService.findAll(), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity save(Parentjob parentjob) {
        parentjobService.save(parentjob);
        return new ResponseEntity(parentjob, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        parentjobService.delete(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }
}
