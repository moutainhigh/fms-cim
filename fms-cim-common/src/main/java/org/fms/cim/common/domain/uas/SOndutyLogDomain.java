/**
 * 值班日志
 * Author :
 * Date :
 * Title : org.fms.cim.common.domain.uas.SOndutyLogDomain.java
 **/
package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;
import org.fms.cim.common.vo.uas.SOndutyLogVO;

import java.util.Date;
import java.math.BigDecimal;

public class SOndutyLogDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long id;    //标识 本实体记录的唯一标识
    private Date ondutyDate;    //值班日期 年月日
    private Long businessPlaceCode;    //供电单位编码
    private Long deptId;    //部门
    private String ondutyType;    //值班类别 0全天1.早上2.下午3.晚上
    private String watcher;    //值班人员
    private String shiftOpr;    //接班人员
    private String wheather;    //天气
    private String thisShiftWork;    //本班主要工作
    private String thisLeftWork;    //本班遗留工作
    private String remainTaskStatus;    //上班遗留工作完成情况
    private String notice;    //注意事项
    private Long creatorId;    //创建者
    private Date createDate;    //创建时间
    private Long lastModifierId;    //最后修改者
    private String lastModifyTime;    //最后修改时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOndutyDate() {
        return ondutyDate;
    }

    public void setOndutyDate(Date ondutyDate) {
        this.ondutyDate = ondutyDate;
    }

    public Long getBusinessPlaceCode() {
        return businessPlaceCode;
    }

    public void setBusinessPlaceCode(Long businessPlaceCode) {
        this.businessPlaceCode = businessPlaceCode;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getOndutyType() {
        return ondutyType;
    }

    public void setOndutyType(String ondutyType) {
        this.ondutyType = ondutyType;
    }

    public String getWatcher() {
        return watcher;
    }

    public void setWatcher(String watcher) {
        this.watcher = watcher;
    }

    public String getShiftOpr() {
        return shiftOpr;
    }

    public void setShiftOpr(String shiftOpr) {
        this.shiftOpr = shiftOpr;
    }

    public String getWheather() {
        return wheather;
    }

    public void setWheather(String wheather) {
        this.wheather = wheather;
    }

    public String getThisShiftWork() {
        return thisShiftWork;
    }

    public void setThisShiftWork(String thisShiftWork) {
        this.thisShiftWork = thisShiftWork;
    }

    public String getThisLeftWork() {
        return thisLeftWork;
    }

    public void setThisLeftWork(String thisLeftWork) {
        this.thisLeftWork = thisLeftWork;
    }

    public String getRemainTaskStatus() {
        return remainTaskStatus;
    }

    public void setRemainTaskStatus(String remainTaskStatus) {
        this.remainTaskStatus = remainTaskStatus;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getLastModifierId() {
        return lastModifierId;
    }

    public void setLastModifierId(Long lastModifierId) {
        this.lastModifierId = lastModifierId;
    }

    public String getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public SOndutyLogVO domain2VO() {
        SOndutyLogVO sOndutyLogVO = ReflectUtil.cast(this, SOndutyLogVO.class);
        return sOndutyLogVO;
    }

}
