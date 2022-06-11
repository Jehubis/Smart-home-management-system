package com.ruoyi.project.cms.type.service;

import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.mapper.CMSTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 零
 * @version 1.0
 * 公告类型服务管理接口 - 处理分页查询公告类型
 */
@Service
public class CMSTypeServiceImpl implements ICMSTypeService{

    @Autowired
    private CMSTypeMapper typeMapper;

    @Override
    public List<CMSType> selectCMSTypeList(CMSType type) {
        return typeMapper.selectCMSTypeList(type);
    }
}
