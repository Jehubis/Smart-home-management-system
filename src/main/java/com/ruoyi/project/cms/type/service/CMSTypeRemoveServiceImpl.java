package com.ruoyi.project.cms.type.service;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.cms.type.controller.CMSTypeRemoveController;
import com.ruoyi.project.cms.type.mapper.CMSTypeRemoveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 老陈
 * @version 1.0
 * 删除公告类型服务实现
 */
@Service
public class CMSTypeRemoveServiceImpl implements ICMSTypeRemoveService{
    @Autowired
    private CMSTypeRemoveMapper removeMapper;

    /**
     * 删除公告类型
     * @param ids 要删除的公告类型主键。如果是批量删除，多个主键之间使用都好分隔。
     * @return
     */
    @Override
    public int removeCMSTypeByIds(String ids) {
        Long[] typeIds = Convert.toLongArray(ids);
        return removeMapper.deleteCMSTypeByIds(typeIds);
    }
}
