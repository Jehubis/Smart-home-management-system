package com.ruoyi.project.cms.type.service;
/**
 * @author 老陈
 *
 * @version 1.0
 *
 * 删除公告类型服务接口
 */
public interface ICMSTypeRemoveService {
    /**
     * 根据主键删除公告类型
     * @param ids 要删除的公告类型主键。如果是批量删除，多个主键之间使用都好分隔。
     * @return
     */
    int removeCMSTypeByIds(String ids);
}
