package com.zz.web310.controller;

import com.zz.web310.entity.Moment;
import com.zz.web310.repo.IMomentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/moment")
public class MomentController {

    @Autowired
    private IMomentRepo momentRepo;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Moment saveMoment(@RequestBody Moment moment){
        moment = momentRepo.save(moment);
        //momentRepo.saveAndFlush(moment);  directly commit
        return moment;
    }

//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public Moment updateMoment(@RequestBody Moment moment){
//        return momentRepo.save(moment);
//    }

    //delete do not have body content, so we can use
    // value = /delete/1  POST   we can add body content in this way
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean deleteMoment(@PathVariable Integer id){
        momentRepo.delete(id);
        return true;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Moment getMoment(@PathVariable Integer id){
        System.out.println("!!!!!");
        if(id==null)
            return null;
        return momentRepo.getOne(id);
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<Moment> getMoment(String title){
        List<Moment> result = momentRepo.findByTitle(title);
        return result;
    }

    @RequestMapping(value="/list2", method = RequestMethod.GET)
    public List<Moment> getMoment2(String content){
        List<Moment> result = momentRepo.findByContent(content);
        return result;
    }
}
