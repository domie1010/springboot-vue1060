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

import com.entity.ExampaperEntity;
import com.entity.view.ExampaperView;

import com.service.ExampaperService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.ExamquestionService;
import com.service.ExamquestionbankService;
import com.service.ExamrecordService;
import com.entity.ExamquestionEntity;
import com.entity.ExamquestionbankEntity;
import com.entity.ExamrecordEntity;

/**
 * 题库表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-09 18:05:49
 */
@RestController
@RequestMapping("/exampaper")
public class ExampaperController {
    @Autowired
    private ExampaperService exampaperService;




    @Autowired
    private ExamquestionService examquestionService;

    @Autowired
    private ExamquestionbankService examquestionbankService;

    @Autowired
    private ExamrecordService examrecordService;
    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ExampaperEntity exampaper,
		HttpServletRequest request){
        EntityWrapper<ExampaperEntity> ew = new EntityWrapper<ExampaperEntity>();

		PageUtils page = exampaperService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, exampaper), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ExampaperEntity exampaper, 
		HttpServletRequest request){
        EntityWrapper<ExampaperEntity> ew = new EntityWrapper<ExampaperEntity>();

		PageUtils page = exampaperService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, exampaper), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ExampaperEntity exampaper){
       	EntityWrapper<ExampaperEntity> ew = new EntityWrapper<ExampaperEntity>();
      	ew.allEq(MPUtil.allEQMapPre( exampaper, "exampaper")); 
        return R.ok().put("data", exampaperService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ExampaperEntity exampaper){
        EntityWrapper< ExampaperEntity> ew = new EntityWrapper< ExampaperEntity>();
 		ew.allEq(MPUtil.allEQMapPre( exampaper, "exampaper")); 
		ExampaperView exampaperView =  exampaperService.selectView(ew);
		return R.ok("查询题库表成功").put("data", exampaperView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ExampaperEntity exampaper = exampaperService.selectById(id);
        return R.ok().put("data", exampaper);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ExampaperEntity exampaper = exampaperService.selectById(id);
        return R.ok().put("data", exampaper);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ExampaperEntity exampaper, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(exampaper);
        exampaperService.insert(exampaper);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ExampaperEntity exampaper, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(exampaper);
        exampaperService.insert(exampaper);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        ExampaperEntity exampaper = exampaperService.selectOne(new EntityWrapper<ExampaperEntity>().eq("", username));
        return R.ok().put("data", exampaper);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody ExampaperEntity exampaper, HttpServletRequest request){
        //ValidatorUtils.validateEntity(exampaper);
        exampaperService.updateById(exampaper);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        exampaperService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ExampaperEntity exampaper, HttpServletRequest request,String pre){
        EntityWrapper<ExampaperEntity> ew = new EntityWrapper<ExampaperEntity>();
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
		PageUtils page = exampaperService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, exampaper), params), params));
        return R.ok().put("data", page);
    }









    /**
     * 组卷
     */
    @RequestMapping("/compose")
    public R compose(HttpServletRequest request,@RequestParam Long paperid, @RequestParam String papername, @RequestParam Integer radioNum,
        @RequestParam Integer multipleChoiceNum, @RequestParam Integer determineNum, @RequestParam Integer fillNum, @RequestParam Integer subjectivityNum){
        //如果已存在考试记录，不能进行重新组卷
        if(examrecordService.selectCount(new EntityWrapper<ExamrecordEntity>().eq("paperid", paperid))>0) {
            return R.error("已存在考试记录，无法重新组卷");
        }
        //组卷之前删除该试卷之前的所有题目
        examquestionService.deleteByMap(new MapUtils().put("paperid", paperid));
        List<ExamquestionbankEntity> questionList = new ArrayList<ExamquestionbankEntity>();
        //单选题
        if(radioNum>0) {
            Integer radioSize = examquestionbankService.selectCount(new EntityWrapper<ExamquestionbankEntity>().eq("type", 0));
            if(radioSize<radioNum) {
                return R.error("单选题库不足");
            } else {
                Wrapper<ExamquestionbankEntity> ew = new EntityWrapper<ExamquestionbankEntity>();
                ew.eq("type", 0).orderBy("RAND()").last("limit "+radioNum);
                List<ExamquestionbankEntity> radioList = examquestionbankService.selectList(ew);
                questionList.addAll(radioList);
            }
        }
        //多选题
        if(multipleChoiceNum>0) {
            Integer multipleChoiceSize = examquestionbankService.selectCount(new EntityWrapper<ExamquestionbankEntity>().eq("type", 1));
            if(multipleChoiceSize<multipleChoiceNum) {
                return R.error("多选题库不足");
            } else {
                Wrapper<ExamquestionbankEntity> ew = new EntityWrapper<ExamquestionbankEntity>();
                ew.eq("type", 1).orderBy("RAND()").last("limit "+multipleChoiceNum);
                List<ExamquestionbankEntity> multipleChoiceList = examquestionbankService.selectList(ew);
                questionList.addAll(multipleChoiceList);
            }
        }
        //判断题
        if(determineNum>0) {
            Integer determineSize = examquestionbankService.selectCount(new EntityWrapper<ExamquestionbankEntity>().eq("type", 2));
            if(determineSize<determineNum) {
                return R.error("判断题库不足");
            } else {
                Wrapper<ExamquestionbankEntity> ew = new EntityWrapper<ExamquestionbankEntity>();
                ew.eq("type", 2).orderBy("RAND()").last("limit "+determineNum);
                List<ExamquestionbankEntity> determineList = examquestionbankService.selectList(ew);
                questionList.addAll(determineList);
            }
        }
        //填空题
        if(fillNum>0) {
            Integer fillSize = examquestionbankService.selectCount(new EntityWrapper<ExamquestionbankEntity>().eq("type", 3));
            if(fillSize<fillNum) {
                return R.error("填空题库不足");
            } else {
                Wrapper<ExamquestionbankEntity> ew = new EntityWrapper<ExamquestionbankEntity>();
                ew.eq("type", 3).orderBy("RAND()").last("limit "+fillNum);
                List<ExamquestionbankEntity> fillList = examquestionbankService.selectList(ew);
                questionList.addAll(fillList);
            }
        }
        //主观题
        if(subjectivityNum>0) {
            Integer subjectivitySize = examquestionbankService.selectCount(new EntityWrapper<ExamquestionbankEntity>().eq("type", 4));
            if(subjectivitySize<subjectivityNum) {
                return R.error("主观题库不足");
            } else {
                Wrapper<ExamquestionbankEntity> ew = new EntityWrapper<ExamquestionbankEntity>();
                ew.eq("type", 4).orderBy("RAND()").last("limit "+subjectivityNum);
                List<ExamquestionbankEntity> subjectivityList = examquestionbankService.selectList(ew);
                questionList.addAll(subjectivityList);
            }
        }
        if(questionList!=null && questionList.size()>0) {
            long seq = 0;
            for(ExamquestionbankEntity q : questionList) {
                ExamquestionEntity examquestion = new ExamquestionEntity();
                examquestion.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
                examquestion.setPaperid(paperid);
                examquestion.setPapername(papername);
                examquestion.setQuestionname(q.getQuestionname());
                examquestion.setOptions(q.getOptions());
                examquestion.setScore(q.getScore());
                examquestion.setAnswer(q.getAnswer());
                examquestion.setAnalysis(q.getAnalysis());
                examquestion.setType(q.getType());
                examquestion.setSequence(++seq);
                examquestionService.insert(examquestion);
            }
        }
        return R.ok();
    }

}
