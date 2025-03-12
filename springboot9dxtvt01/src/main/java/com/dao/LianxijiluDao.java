package com.dao;

import com.entity.LianxijiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LianxijiluVO;
import com.entity.view.LianxijiluView;


/**
 * 练习记录
 * 
 * @author 
 * @email 
 * @date 2024-03-09 18:05:49
 */
public interface LianxijiluDao extends BaseMapper<LianxijiluEntity> {
	
	List<LianxijiluVO> selectListVO(@Param("ew") Wrapper<LianxijiluEntity> wrapper);
	
	LianxijiluVO selectVO(@Param("ew") Wrapper<LianxijiluEntity> wrapper);
	
	List<LianxijiluView> selectListView(@Param("ew") Wrapper<LianxijiluEntity> wrapper);

	List<LianxijiluView> selectListView(Pagination page,@Param("ew") Wrapper<LianxijiluEntity> wrapper);

	
	LianxijiluView selectView(@Param("ew") Wrapper<LianxijiluEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LianxijiluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LianxijiluEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LianxijiluEntity> wrapper);



}
