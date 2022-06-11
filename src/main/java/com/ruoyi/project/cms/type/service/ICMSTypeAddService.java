package com.ruoyi.project.cms.type.service;

import com.ruoyi.project.cms.type.domain.CMSType;

/**
 * @author 老陈
 *
 * @version 1.0
 *
 * 公告类型服务接口 - 处理新增相关业务
 */
public interface ICMSTypeAddService {
    /**
     * 判断公告类型名称是否唯一
     * @param type 查询参数
     * @return 0 - 唯一可用。 1 - 不唯一不可用。
     */
    String checkTypeNameUnique(CMSType type);

    /**
     * 新增数据到数据库
     * @param type
     * @return
     */
    int addCMSType(CMSType type);
}
