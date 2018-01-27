package com.eagleoj.web.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import com.eagleoj.web.controller.exception.WebErrorException;
import com.eagleoj.web.controller.format.admin.AddAnnouncementFormat;
import com.eagleoj.web.entity.ResponseEntity;
import com.eagleoj.web.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Smith
 **/
@RestController
@Validated
@RequestMapping(value = "/announcement", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @RequiresAuthentication
    @RequiresRoles("9")
    @PostMapping
    public ResponseEntity add(@RequestBody @Valid AddAnnouncementFormat format) {
        if(! announcementService.save(format.getTitle(), format.getContent())) {
            throw new WebErrorException("公告添加失败");
        }
        return new ResponseEntity("公告添加成功");
    }

    @RequiresAuthentication
    @RequiresRoles("9")
    @PutMapping("/{aid}")
    public ResponseEntity update(@PathVariable int aid,
                                 @RequestBody @Valid AddAnnouncementFormat format) {
        if (! announcementService.updateByAid(aid, format.getTitle(), format.getContent())) {
            throw new WebErrorException("公告更新失败");
        }
        return new ResponseEntity("公告更新成功");
    }

    @RequiresAuthentication
    @RequiresRoles("9")
    @DeleteMapping("/{aid}")
    public ResponseEntity delete(@PathVariable int aid) {
        if (! announcementService.deleteByAid(aid)) {
            throw new WebErrorException("公告删除失败");
        }
        return new ResponseEntity("公告删除成功");
    }
}