package com.dao;

import com.entity.ExamquestionbankEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ExamquestionbankVO;
import com.entity.view.ExamquestionbankView;


/**
 * 题目
 * 
 * @author 
 * @email 
 * @date 2024-03-09 18:05:49
 */
public interface ExamquestionbankDao extends BaseMapper<ExamquestionbankEntity> {
	
	List<ExamquestionbankVO> selectListVO(@Param("ew") Wrapper<ExamquestionbankEntity> wrapper);
	
	ExamquestionbankVO selectVO(@Param("ew") Wrapper<ExamquestionbankEntity> wrapper);
	
	List<ExamquestionbankView> selectListView(@Param("ew") Wrapper<ExamquestionbankEntity> wrapper);

	List<ExamquestionbankView> selectListView(Pagination page,@Param("ew") Wrapper<ExamquestionbankEntity> wrapper);

	
	ExamquestionbankView selectView(@Param("ew") Wrapper<ExamquestionbankEntity> wrapper);
	

}
