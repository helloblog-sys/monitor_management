package com.microthings.monitor_management.service;

import com.microthings.monitor_management.mapper.DescriptionMapper;
import com.microthings.monitor_management.pojo.Description;
import com.microthings.monitor_management.util.AjaxResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tyd
 * @date 2020/8/9
 */
@Service
public class DescriptionService {

    @Resource
    DescriptionMapper descriptionMapper;

    /**
     * @Description: 获取使用说明信息
     * @Param: [user]
     * @return: void
     * @Author: tyd
     * @Date: 2020/8/9
     */
    public Description getDescription(Integer id){
        return descriptionMapper.selectByPrimaryKey(id);
    }

    /**
     * @Description: 更新使用说明信息
     * @Param: [description]
     * @return: void
     * @Author: tyd
     * @Date: 2020/8/9
     */
    public AjaxResponse updateDescription(Description description){
        descriptionMapper.updateByPrimaryKeySelective(description);
        return AjaxResponse.OK;
    }
}
