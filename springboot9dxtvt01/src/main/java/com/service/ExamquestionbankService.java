package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ExamquestionbankEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ExamquestionbankVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ExamquestionbankView;


/**
 * 题目
 *
 * @author 
 * @email 
 * @date 2024-03-09 18:05:49
 */
public interface ExamquestionbankService extends IService<ExamquestionbankEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ExamquestionbankVO> selectListVO(Wrapper<ExamquestionbankEntity> wrapper);
   	
   	ExamquestionbankVO selectVO(@Param("ew") Wrapper<ExamquestionbankEntity> wrapper);
   	
   	List<ExamquestionbankView> selectListView(Wrapper<ExamquestionbankEntity> wrapper);
   	
   	ExamquestionbankView selectView(@Param("ew") Wrapper<ExamquestionbankEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ExamquestionbankEntity> wrapper);

   	

}

