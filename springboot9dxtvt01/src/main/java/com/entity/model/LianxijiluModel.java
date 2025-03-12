package com.entity.model;

import com.entity.LianxijiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 练习记录
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-03-09 18:05:49
 */
public class LianxijiluModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
