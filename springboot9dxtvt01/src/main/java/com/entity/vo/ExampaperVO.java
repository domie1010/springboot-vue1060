package com.entity.vo;

import com.entity.ExampaperEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 题库表
 * @author 
 * @email 
 * @date 2024-03-09 18:05:49
 */
public class ExampaperVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 答题时长(分钟)
	 */
	
	private Integer time;
		
	/**
	 * 题库状态
	 */
	
	private Integer status;
				
	
	/**
	 * 设置：答题时长(分钟)
	 */
	 
	public void setTime(Integer time) {
		this.time = time;
	}
	
	/**
	 * 获取：答题时长(分钟)
	 */
	public Integer getTime() {
		return time;
	}
				
	
	/**
	 * 设置：题库状态
	 */
	 
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 获取：题库状态
	 */
	public Integer getStatus() {
		return status;
	}
			
}
