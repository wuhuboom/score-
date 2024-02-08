package com.score.system.controller;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.score.common.utils.StringUtils;
import com.score.system.domain.scoreVo.*;
import com.score.web.score.ScoreDto;
import com.score.web.score.ScoreJson;
import com.score.web.score.ScoreVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.score.common.annotation.Log;
import com.score.common.core.controller.BaseController;
import com.score.common.core.domain.AjaxResult;
import com.score.common.enums.BusinessType;
import com.score.system.domain.ScoreSport;
import com.score.system.service.IScoreSportService;
import com.score.common.utils.poi.ExcelUtil;
import com.score.common.core.page.TableDataInfo;

/**
 * 足球列表Controller
 * 
 * @author score
 * @date 2024-02-01
 */
@RestController
@RequestMapping("/system/sport")
public class ScoreSportController extends BaseController
{
    @Autowired
    private IScoreSportService scoreSportService;

    /**
     * 查询足球列表列表
     */
    @PreAuthorize("@ss.hasPermi('system:sport:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScoreSport scoreSport)
    {
        startPage();
        List<ScoreSport> list = scoreSportService.selectScoreSportList(scoreSport);
        return getDataTable(list);
    }

    /**
     * 导出足球列表列表
     */
    @PreAuthorize("@ss.hasPermi('system:sport:export')")
    @Log(title = "足球列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScoreSport scoreSport)
    {
        List<ScoreSport> list = scoreSportService.selectScoreSportList(scoreSport);
        ExcelUtil<ScoreSport> util = new ExcelUtil<ScoreSport>(ScoreSport.class);
        util.exportExcel(response, list, "足球列表数据");
    }

    /**
     * 获取足球列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sport:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        ScoreSport scoreSport = scoreSportService.selectScoreSportById(id);
        ScoreJson scoreJson = changVo(scoreSport);
        return success(scoreJson);
    }

    public ScoreJson changVo(ScoreSport scoreSport){
        ScoreJson scoreJson =new ScoreJson();
        scoreJson.setId(scoreSport.getId());
        scoreJson.setTime_status(scoreSport.getTimeStatus());
        scoreJson.setSport_id(scoreSport.getSportId());
        scoreJson.setConfirmed_at(scoreSport.getConfirmedAt());
        scoreJson.setInplay_created_at(scoreSport.getInplayCreatedAt());
        scoreJson.setInplay_updated_at(scoreSport.getInplayUpdatedAt());
        scoreJson.setHas_lineup(StringUtils.isNotNull(scoreSport.getHasLineup())?scoreSport.getHasLineup().intValue():null);
        scoreJson.setTime(scoreSport.getTime());
        scoreJson.setSs(scoreSport.getSs());
        if (StringUtils.isNotEmpty(scoreSport.getLeague())){
            LeagueVo leagueVo = JSONObject.parseObject(scoreSport.getLeague(), LeagueVo.class);
            scoreJson.setLeague(leagueVo);
        }
        if (StringUtils.isNotEmpty(scoreSport.getHome())){
            HomeVo homeVo = JSONObject.parseObject(scoreSport.getHome(), HomeVo.class);
            scoreJson.setHome(homeVo);
        }
        if (StringUtils.isNotEmpty(scoreSport.getoHome())){
            HomeVo homeVo = JSONObject.parseObject(scoreSport.getoHome(), HomeVo.class);
            scoreJson.setO_home(homeVo);
        }
        if (StringUtils.isNotEmpty(scoreSport.getAway())){
            HomeVo homeVo = JSONObject.parseObject(scoreSport.getAway(), HomeVo.class);
            scoreJson.setAway(homeVo);
        }
        if (StringUtils.isNotEmpty(scoreSport.getScores())){
            ScoresVo scoresVo = JSONObject.parseObject(scoreSport.getScores(), ScoresVo.class);
            scoreJson.setScores(scoresVo);
        }
        if (StringUtils.isNotEmpty(scoreSport.getStats())){
            StatsVo statsVo = JSONObject.parseObject(scoreSport.getStats(), StatsVo.class);
            scoreJson.setStats(statsVo);
        }
        if (StringUtils.isNotEmpty(scoreSport.getExtra())){
            ExtraVo extraVo = JSONObject.parseObject(scoreSport.getExtra(), ExtraVo.class);
            scoreJson.setExtra(extraVo);
        }
        if (StringUtils.isNotEmpty(scoreSport.getEvents())){
            List<EventsVo> eventsVos = JSONArray.parseArray(scoreSport.getEvents(), EventsVo.class);
            scoreJson.setEvents(eventsVos);
        }
        return scoreJson;
    }

    /**
     * 新增足球列表
     */
    @PreAuthorize("@ss.hasPermi('system:sport:add')")
    @Log(title = "足球列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScoreDto scoreSport)
    {
        return toAjax(changScore(scoreSport));
    }

    /**
     * 修改足球列表
     */
    @PreAuthorize("@ss.hasPermi('system:sport:edit')")
    @Log(title = "足球列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScoreDto scoreSport)
    {
        ScoreSport sport=new ScoreSport();
        sport.setTime(scoreSport.getTime());
        sport.setTimeStatus(scoreSport.getTime_status());
        sport.setId(scoreSport.getId());
        setData(sport,scoreSport);
        return toAjax(scoreSportService.updateScoreSport(sport));
    }

    public  int changScore(ScoreDto vo){
            ScoreSport sport=new ScoreSport();
            sport.setDataType("2");
            sport.setTime(vo.getTime());
            sport.setTimeStatus(vo.getTime_status());
            setData(sport,vo);
        return  scoreSportService.insertScoreSport(sport);
    }

    public void setData(ScoreSport sport,ScoreDto vo){
        if (StringUtils.isNotNull(vo.getLeague())&&checkObjAllFieldsIsNull(vo.getLeague())){
            sport.setLeague(JSON.toJSONString(vo.getLeague()));
        }
        if (StringUtils.isNotNull(vo.getHome())&&checkObjAllFieldsIsNull(vo.getHome())){
            sport.setHome(JSON.toJSONString(vo.getHome()));
        }
        if (StringUtils.isNotNull(vo.getO_home())&&checkObjAllFieldsIsNull(vo.getO_home())){
            sport.setoHome(JSON.toJSONString(vo.getO_home()));
        }
        if (StringUtils.isNotNull(vo.getAway())&&checkObjAllFieldsIsNull(vo.getAway())){
            sport.setAway(JSON.toJSONString(vo.getAway()));
        }
        sport.setSs(vo.getSs());
        if (StringUtils.isNotNull(vo.getScores())&&scoreIsNull(vo.getScores())){
            sport.setScores(JSON.toJSONString(vo.getScores()));
        }
        if (StringUtils.isNotNull(vo.getStats())&&checkObjAllFieldsIsNull(vo.getStats())){
            sport.setStats(JSON.toJSONString(vo.getStats()));
        }
        if (StringUtils.isNotNull(vo.getExtra())&&checkObjAllFieldsIsNull(vo.getExtra())){
            sport.setExtra(JSON.toJSONString(vo.getExtra()));
        }
        if (vo.getEvents().size()>0){
            sport.setEvents(JSON.toJSONString(vo.getEvents()));
        }
        if (StringUtils.isNotNull(vo.getHas_lineup())){
            sport.setHasLineup(Long.parseLong(vo.getHas_lineup().toString()));
        }
        if (StringUtils.isNotNull(vo.getInplay_created_at())){
            sport.setInplayCreatedAt(vo.getInplay_created_at());
        }
        if (StringUtils.isNotNull(vo.getInplay_updated_at())){
            sport.setInplayUpdatedAt(vo.getInplay_updated_at());
        }
        if (StringUtils.isNotNull(vo.getConfirmed_at())){
            sport.setConfirmedAt(vo.getConfirmed_at());
        }
        if (StringUtils.isNotNull(vo.getBet365_id())){
            sport.setBet365Id(vo.getBet365_id().toString());
        }
    }

    public Boolean scoreIsNull(ScoresVo sd){
        if (checkObjAllFieldsIsNull(sd.getOne())||checkObjAllFieldsIsNull(sd.getTwo())){
            return true;
        }
        return false;
    }

    public boolean checkObjAllFieldsIsNull(Object object) {
        // 如果对象为null直接返回true
        if (null == object) {
            return false;
        }
        try {
            // 挨个获取对象属性值
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                // 如果有一个属性值不为null，且值不是空字符串，就返回false
                if (f.get(object) != null && StringUtils.isNotBlank(f.get(object).toString())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }




    /**
     * 删除足球列表
     */
    @PreAuthorize("@ss.hasPermi('system:sport:remove')")
    @Log(title = "足球列表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(scoreSportService.deleteScoreSportByIds(ids));
    }
}
