package com.entity.model;

import com.entity.ExamrecordEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 答题记录表
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-03-09 18:05:49
 */
public class ExamrecordModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户名
	 */
	
	private String username;
		
	/**
	 * 题库id（外键）
	 */
	
	private Long paperid;
		
	/**
	 * 题库名称
	 */
	
	private String papername;
		
	/**
	 * 题目id（外键）
	 */
	
	private Long questionid;
		
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
	 * 是否批卷
	 */
	
	private Long ismark;
		
	/**
	 * 题目类型，0：单选题 1：多选题 2：判断题 3：填空题（暂不考虑多项填空） 4:主观题
	 */
	
	private Long type;
		
	/**
	 * 题目得分
	 */
	
	private Long myscore;
		
	/**
	 * 考生答案
	 */
	
	private String myanswer;
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
				
	
	/**
	 * 设置：题库id（外键）
	 */
	 
	public void setPaperid(Long paperid) {
		this.paperid = paperid;
	}
	
	/**
	 * 获取：题库id（外键）
	 */
	public Long getPaperid() {
		return paperid;
	}
				
	
	/**
	 * 设置：题库名称
	 */
	 
	public void setPapername(String papername) {
		this.papername = papername;
	}
	
	/**
	 * 获取：题库名称
	 */
	public String getPapername() {
		return papername;
	}
				
	
	/**
	 * 设置：题目id（外键）
	 */
	 
	public void setQuestionid(Long questionid) {
		this.questionid = questionid;
	}
	
	/**
	 * 获取：题目id（外键）
	 */
	public Long getQuestionid() {
		return questionid;
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
	 * 设置：是否批卷
	 */
	 
	public void setIsmark(Long ismark) {
		this.ismark = ismark;
	}
	
	/**
	 * 获取：是否批卷
	 */
	public Long getIsmark() {
		return ismark;
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
	 * 设置：题目得分
	 */
	 
	public void setMyscore(Long myscore) {
		this.myscore = myscore;
	}
	
	/**
	 * 获取：题目得分
	 */
	public Long getMyscore() {
		return myscore;
	}
				
	
	/**
	 * 设置：考生答案
	 */
	 
	public void setMyanswer(String myanswer) {
		this.myanswer = myanswer;
	}
	
	/**
	 * 获取：考生答案
	 */
	public String getMyanswer() {
		return myanswer;
	}
			
}
