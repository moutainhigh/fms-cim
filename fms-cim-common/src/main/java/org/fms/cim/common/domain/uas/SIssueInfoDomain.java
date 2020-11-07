/**
 * 系统公告
 * Author :
 * Date :
 * Title : org.fms.cim.common.domain.uas.SIssueInfoDomain.java
 **/
package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;
import org.fms.cim.common.vo.uas.SIssueInfoVO;

import java.util.Date;
import java.math.BigDecimal;

public class SIssueInfoDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Long id;    //标识 本实体记录的唯一标识
    private Date noticeDate;    //公告日期 年月日
    private Long businessPlaceCode;    //供电单位编码
    private Long deptId;    //发布部门
    private String empNo;    //发布人
    private String infoTitle;    //标题
    private String content;    //内容
    private String validFlag;    //有效标识 不允许删除，只能设置无效
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

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
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

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
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

    public SIssueInfoVO domain2VO() {
        SIssueInfoVO sIssueInfoVO = ReflectUtil.cast(this, SIssueInfoVO.class);
        return sIssueInfoVO;
    }

}
