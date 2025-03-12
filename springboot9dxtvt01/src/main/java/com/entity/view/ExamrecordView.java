package com.entity.view;

import com.entity.ExamrecordEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 答题记录表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-09 18:05:49
 */
@TableName("examrecord")
public class ExamrecordView  extends ExamrecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ExamrecordView(){
	}
 
 	public ExamrecordView(ExamrecordEntity examrecordEntity){
 	try {
			BeanUtils.copyProperties(this, examrecordEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

    private BigDecimal accuracy;

    private Integer anum;

    private Integer bnum;

    private Integer cnum;

    private Integer dnum;

    public BigDecimal getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(BigDecimal accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getAnum() {
        return anum;
    }

    public void setAnum(Integer anum) {
        this.anum = anum;
    }

    public Integer getBnum() {
        return bnum;
    }

    public void setBnum(Integer bnum) {
        this.bnum = bnum;
    }

    public Integer getCnum() {
        return cnum;
    }

    public void setCnum(Integer cnum) {
        this.cnum = cnum;
    }

    public Integer getDnum() {
        return dnum;
    }

    public void setDnum(Integer dnum) {
        this.dnum = dnum;
    }

}
