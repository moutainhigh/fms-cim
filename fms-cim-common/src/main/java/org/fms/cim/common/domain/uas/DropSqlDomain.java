/**
 * Author :
 * Date :
 * Title : org.fms.eis.webapp.domain.DropSqlDomain.java
 **/
package org.fms.cim.common.domain.uas;

import com.riozenc.titanTool.annotation.TablePrimaryKey;
import com.riozenc.titanTool.common.reflect.ReflectUtil;
import com.riozenc.titanTool.mybatis.MybatisEntity;
import com.riozenc.titanTool.mybatis.pagination.Page;
import org.fms.cim.common.vo.uas.DropSqlVO;

public class DropSqlDomain extends Page implements MybatisEntity {
    @TablePrimaryKey
    private Integer id;    //
    private String dropCode;    //
    private String dropName;    //
    private String dropSql;    //
    private String dropType;    //
    private String remark;    //
    private String status;    //

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDropCode() {
        return dropCode;
    }

    public void setDropCode(String dropCode) {
        this.dropCode = dropCode;
    }

    public String getDropName() {
        return dropName;
    }

    public void setDropName(String dropName) {
        this.dropName = dropName;
    }

    public String getDropSql() {
        return dropSql;
    }

    public void setDropSql(String dropSql) {
        this.dropSql = dropSql;
    }

    public String getDropType() {
        return dropType;
    }

    public void setDropType(String dropType) {
        this.dropType = dropType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DropSqlVO domain2VO() {
        DropSqlVO dropSqlVO = ReflectUtil.cast(this, DropSqlVO.class);
        return dropSqlVO;
    }

}
