package com.ruoyi.project.cms.type.service;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.cms.type.commons.CMSTypeConst;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.mapper.CMSTypeAddMapper;
import com.ruoyi.project.system.post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 老陈
 *
 * @version 1.0
 * 新增公告类型服务实现
 */
@Service
public class CMSTypeAddServiceImpl implements ICMSTypeAddService{


    @Autowired
    private CMSTypeAddMapper typeAddMapper;

    @Override
    public String checkTypeNameUnique(CMSType type) {
        //当前可能是修改公告类型，也可能是在新增公告类型。如果是修改，则需要判断主键
        Long typeId = StringUtils.isNull(type.getTypeId()) ? -1L : type.getTypeId();
        CMSType info = typeAddMapper.checkTypeNameUnique(type.getTypeName());
        if (StringUtils.isNotNull(info) && info.getTypeId().longValue() != typeId.longValue())
        {
            return CMSTypeConst.TYPE_NAME_NOT_UNIQUE;
        }
        return CMSTypeConst.TYPE_NAME_UNIQUE;
    }

    @Override
    public int addCMSType(CMSType type) {
        //将当前登录用户的登录名，赋值到createBy属性中。
        type.setCreateBy(ShiroUtils.getLoginName());
        return typeAddMapper.insertCMSType(type);
    }
}
