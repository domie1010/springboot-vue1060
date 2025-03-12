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


import com.dao.LianxijiluDao;
import com.entity.LianxijiluEntity;
import com.service.LianxijiluService;
import com.entity.vo.LianxijiluVO;
import com.entity.view.LianxijiluView;

@Service("lianxijiluService")
public class LianxijiluServiceImpl extends ServiceImpl<LianxijiluDao, LianxijiluEntity> implements LianxijiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LianxijiluEntity> page = this.selectPage(
                new Query<LianxijiluEntity>(params).getPage(),
                new EntityWrapper<LianxijiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LianxijiluEntity> wrapper) {
		  Page<LianxijiluView> page =new Query<LianxijiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<LianxijiluVO> selectListVO(Wrapper<LianxijiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LianxijiluVO selectVO(Wrapper<LianxijiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LianxijiluView> selectListView(Wrapper<LianxijiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LianxijiluView selectView(Wrapper<LianxijiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<LianxijiluEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<LianxijiluEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<LianxijiluEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
