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
 * 题目
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-09 18:05:49
 */
@TableName("examquestionbank")
public class ExamquestionbankEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ExamquestionbankEntity() {
		
	}
	
	public ExamquestionbankEntity(T t) {
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
	 * 题目名称
	 */
					
	private String questionname;
	
	/**
	 * 选项，json字符串
	 */
					
	private String options;
	
	/**
	 * 分值
	 */
					
	private Long score;
	
	/**
	 * 正确答案
	 */
					
	private String answer;
	
	/**
	 * 答案解析
	 */
					
	private String analysis;
	
	/**
	 * 题目类型，0：单选题 1：多选题 2：判断题 3：填空题（暂不考虑多项填空） 4:主观题
	 */
					
	private Long type;
	
	/**
	 * 题目排序，值越大排越前面
	 */
					
	private Long sequence;
	
	
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
	 * 设置：题目名称
	 */
	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}
	/**
	 * 获取：题目名称
	 */
	public String getQuestionname() {
		return questionname;
	}
	/**
	 * 设置：选项，json字符串
	 */
	public void setOptions(String options) {
		this.options = options;
	}
	/**
	 * 获取：选项，json字符串
	 */
	public String getOptions() {
		return options;
	}
	/**
	 * 设置：分值
	 */
	public void setScore(Long score) {
		this.score = score;
	}
	/**
	 * 获取：分值
	 */
	public Long getScore() {
		return score;
	}
	/**
	 * 设置：正确答案
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * 获取：正确答案
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * 设置：答案解析
	 */
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	/**
	 * 获取：答案解析
	 */
	public String getAnalysis() {
		return analysis;
	}
	/**
	 * 设置：题目类型，0：单选题 1：多选题 2：判断题 3：填空题（暂不考虑多项填空） 4:主观题
	 */
	public void setType(Long type) {
		this.type = type;
	}
	/**
	 * 获取：题目类型，0：单选题 1：多选题 2：判断题 3：填空题（暂不考虑多项填空） 4:主观题
	 */
	public Long getType() {
		return type;
	}
	/**
	 * 设置：题目排序，值越大排越前面
	 */
	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}
	/**
	 * 获取：题目排序，值越大排越前面
	 */
	public Long getSequence() {
		return sequence;
	}

}
