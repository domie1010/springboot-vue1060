package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 练习记录
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-09 18:05:49
 */
@TableName("lianxijilu")
public class LianxijiluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LianxijiluEntity() {
		
	}
	
	public LianxijiluEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 记录编号
	 */
					
	private String jilubianhao;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 答题时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date datishijian;
	
	/**
	 * 答题次数
	 */
					
	private Integer daticishu;
	
	/**
	 * 错题次数
	 */
					
	private Integer cuoticishu;
	
	/**
	 * 错题报告
	 */
					
	private String cuotibaogao;
	
	/**
	 * 建议
	 */
					
	private String jianyi;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：记录编号
	 */
	public void setJilubianhao(String jilubianhao) {
		this.jilubianhao = jilubianhao;
	}
	/**
	 * 获取：记录编号
	 */
	public String getJilubianhao() {
		return jilubianhao;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：答题时间
	 */
	public void setDatishijian(Date datishijian) {
		this.datishijian = datishijian;
	}
	/**
	 * 获取：答题时间
	 */
	public Date getDatishijian() {
		return datishijian;
	}
	/**
	 * 设置：答题次数
	 */
	public void setDaticishu(Integer daticishu) {
		this.daticishu = daticishu;
	}
	/**
	 * 获取：答题次数
	 */
	public Integer getDaticishu() {
		return daticishu;
	}
	/**
	 * 设置：错题次数
	 */
	public void setCuoticishu(Integer cuoticishu) {
		this.cuoticishu = cuoticishu;
	}
	/**
	 * 获取：错题次数
	 */
	public Integer getCuoticishu() {
		return cuoticishu;
	}
	/**
	 * 设置：错题报告
	 */
	public void setCuotibaogao(String cuotibaogao) {
		this.cuotibaogao = cuotibaogao;
	}
	/**
	 * 获取：错题报告
	 */
	public String getCuotibaogao() {
		return cuotibaogao;
	}
	/**
	 * 设置：建议
	 */
	public void setJianyi(String jianyi) {
		this.jianyi = jianyi;
	}
	/**
	 * 获取：建议
	 */
	public String getJianyi() {
		return jianyi;
	}

}
