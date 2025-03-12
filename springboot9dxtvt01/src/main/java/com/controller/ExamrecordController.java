package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ExamrecordEntity;
import com.entity.view.ExamrecordView;

import com.service.ExamrecordService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 答题记录表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-09 18:05:49
 */
@RestController
@RequestMapping("/examrecord")
public class ExamrecordController {
    @Autowired
    private ExamrecordService examrecordService;




    

   	    /**
     * 考试记录接口
     */
    @RequestMapping("/groupby")
    public R page2(@RequestParam Map<String, Object> params,ExamrecordEntity examrecord, HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            examrecord.setUserid((Long)request.getSession().getAttribute("userId"));
        }
        EntityWrapper<ExamrecordEntity> ew = new EntityWrapper<ExamrecordEntity>();
		PageUtils page = examrecordService.queryPageGroupBy(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, examrecord), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 选项统计接口
     */
    @RequestMapping("/options/num")
    public R optionsNum(@RequestParam Map<String, Object> params,ExamrecordEntity examrecord, HttpServletRequest request){
        EntityWrapper<ExamrecordEntity> ew = new EntityWrapper<ExamrecordEntity>();
        PageUtils page = examrecordService.queryPageOptionsNum(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, examrecord), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ExamrecordEntity examrecord,
		HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            examrecord.setUserid((Long)request.getSession().getAttribute("userId"));
        }
        EntityWrapper<ExamrecordEntity> ew = new EntityWrapper<ExamrecordEntity>();

		PageUtils page = examrecordService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, examrecord), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ExamrecordEntity examrecord, 
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		examrecord.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<ExamrecordEntity> ew = new EntityWrapper<ExamrecordEntity>();

		PageUtils page = examrecordService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, examrecord), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ExamrecordEntity examrecord){
       	EntityWrapper<ExamrecordEntity> ew = new EntityWrapper<ExamrecordEntity>();
      	ew.allEq(MPUtil.allEQMapPre( examrecord, "examrecord")); 
        return R.ok().put("data", examrecordService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ExamrecordEntity examrecord){
        EntityWrapper< ExamrecordEntity> ew = new EntityWrapper< ExamrecordEntity>();
 		ew.allEq(MPUtil.allEQMapPre( examrecord, "examrecord")); 
		ExamrecordView examrecordView =  examrecordService.selectView(ew);
		return R.ok("查询答题记录表成功").put("data", examrecordView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ExamrecordEntity examrecord = examrecordService.selectById(id);
        return R.ok().put("data", examrecord);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ExamrecordEntity examrecord = examrecordService.selectById(id);
        return R.ok().put("data", examrecord);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ExamrecordEntity examrecord, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(examrecord);
    	examrecord.setUserid((Long)request.getSession().getAttribute("userId"));
        examrecordService.insert(examrecord);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ExamrecordEntity examrecord, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(examrecord);
    	examrecord.setUserid((Long)request.getSession().getAttribute("userId"));
        examrecordService.insert(examrecord);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        ExamrecordEntity examrecord = examrecordService.selectOne(new EntityWrapper<ExamrecordEntity>().eq("", username));
        return R.ok().put("data", examrecord);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody ExamrecordEntity examrecord, HttpServletRequest request){
        //ValidatorUtils.validateEntity(examrecord);
        examrecordService.updateById(examrecord);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        examrecordService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ExamrecordEntity examrecord, HttpServletRequest request,String pre){
        EntityWrapper<ExamrecordEntity> ew = new EntityWrapper<ExamrecordEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = examrecordService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, examrecord), params), params));
        return R.ok().put("data", page);
    }



    /**
     * 当重新考试时，删除考生的某个试卷的所有考试记录
     */
    @RequestMapping("/deleteRecords")
    public R deleteRecords(@RequestParam Long userid,@RequestParam Long paperid){
    	examrecordService.delete(new EntityWrapper<ExamrecordEntity>().eq("paperid", paperid).eq("userid", userid));
        return R.ok();
    }







}
