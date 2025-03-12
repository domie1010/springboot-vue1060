package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ExamquestionbankDao;
import com.entity.ExamquestionbankEntity;
import com.service.ExamquestionbankService;
import com.entity.vo.ExamquestionbankVO;
import com.entity.view.ExamquestionbankView;

@Service("examquestionbankService")
public class ExamquestionbankServiceImpl extends ServiceImpl<ExamquestionbankDao, ExamquestionbankEntity> implements ExamquestionbankService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ExamquestionbankEntity> page = this.selectPage(
                new Query<ExamquestionbankEntity>(params).getPage(),
                new EntityWrapper<ExamquestionbankEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ExamquestionbankEntity> wrapper) {
		  Page<ExamquestionbankView> page =new Query<ExamquestionbankView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ExamquestionbankVO> selectListVO(Wrapper<ExamquestionbankEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ExamquestionbankVO selectVO(Wrapper<ExamquestionbankEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ExamquestionbankView> selectListView(Wrapper<ExamquestionbankEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ExamquestionbankView selectView(Wrapper<ExamquestionbankEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
