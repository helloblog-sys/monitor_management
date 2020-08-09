package com.microthings.monitor_management.controller;

import com.microthings.monitor_management.pojo.Description;
import com.microthings.monitor_management.service.DescriptionService;
import com.microthings.monitor_management.util.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author tyd
 * @date 2020/8/9
 */
@Controller
@RequestMapping("description")
public class DescriptionController {

    @Resource
    DescriptionService descriptionService;

    private static Logger logger = LoggerFactory.getLogger(DescriptionController.class);

    @GetMapping("front")
    public String getFrontManual(ModelMap model){
        Description description = descriptionService.getDescription(1);
        model.put("content", description.getDescriptionContent());
        return "/manualOfFront";
    }

    @GetMapping("back")
    public String getBackManual(ModelMap model){
        Description description = descriptionService.getDescription(2);
        model.put("content", description.getDescriptionContent());
        return "/manualOfBack";
    }

    @RequestMapping(value="/data", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse updateDescription(@RequestBody Description description) {
        try {
            return descriptionService.updateDescription(description);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResponse.FAILED("添加失败！请重试！");
        }
    }
}
