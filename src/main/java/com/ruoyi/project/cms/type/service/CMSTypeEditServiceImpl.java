package com.ruoyi.project.cms.type.service;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.mapper.CMSTypeEditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 老陈
 * @version 1.0
 * 修改公告类型服务实现
 */
@Service
public class CMSTypeEditServiceImpl implements ICMSTypeEditService{

    @Autowired
    private CMSTypeEditMapper editMapper;

    @Override
    public CMSType selectCMSTypeByPK(Long id) {
        return editMapper.selectByPK(id);
    }

    @Override
    public int editCMSType(CMSType type) {
        //设置更新者的名称
        type.setUpdateBy(ShiroUtils.getLoginName());
        return editMapper.updateCMSType(type);
    }
}
