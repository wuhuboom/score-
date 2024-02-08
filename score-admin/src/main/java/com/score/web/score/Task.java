package com.score.web.score;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.score.common.exception.ServiceException;
import com.score.common.utils.DateUtils;
import com.score.common.utils.StringUtils;
import com.score.common.utils.http.HttpUtils;
import com.score.system.domain.ScoreSport;
import com.score.system.service.IScoreSportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("scoreTask")
@Transactional
public class Task {

    @Autowired
    private IScoreSportService scoreSportService;

    private static final Logger log = LoggerFactory.getLogger(Task.class);

    /**
     * 已经结束
     */

    public void ended(String date)
    {
        if (StringUtils.isEmpty(date)){
            throw new ServiceException("请输入时间，时间格式为YYYYMMDD");
        }
        getData(date,"ended");
    }

    /**
     * 获取当天结束赛事
     */
    public void endedNoDate(){
        String s = DateUtils.parseDateToStr("yyyyMMdd", new Date());
        getData(s,"ended");
    }

    public String getUrl(String type,String date, Integer page,Integer per_page){
        return "https://api.b365api.com/v3/events/"+type+"?sport_id=1&token=181183-3qfYgaBuFhHFCS&day="+date+"&page="+page+"&per_page="+per_page;
    }


    /**
     * 即将开始
     */

    public void upcoming(String date)
    {
        if (StringUtils.isEmpty(date)){
            throw new ServiceException("请输入时间，时间格式为YYYYMMDD");
        }
        getData(date,"upcoming");
    }

    public void getData(String date,String type) {

        Integer page=1;
        Integer per_page=100;
        List<ScoreVo> all= new ArrayList<ScoreVo>();
        while (true){
            String url = getUrl(type,date, page, per_page);
            String s = HttpUtils.sendGet(url);
            JSONObject jsonObject = JSONObject.parseObject(s);
            String string = jsonObject.getString("results");
            String string1 = jsonObject.getString("pager");
            List<ScoreVo> scoreVos = JSONArray.parseArray(string, ScoreVo.class);
            all.addAll(scoreVos);
            if (scoreVos.size()<per_page){
                break;
            }else{
                page++;
            }
        }
        changScore(all);
    }

    /**
     * 进行中
     */
    public void inPlay(){
        String url ="https://api.b365api.com/v3/events/inplay?sport_id=1&token=181183-3qfYgaBuFhHFCS";
        String s = HttpUtils.sendGet(url);
        JSONObject jsonObject = JSONObject.parseObject(s);
        String string = jsonObject.getString("results");
        List<ScoreVo> scoreVos = JSONArray.parseArray(string, ScoreVo.class);
        scoreSportService.deleteScoreSportByTimeStatus("1");
        changScore(scoreVos);
    }


    public synchronized void changScore(List<ScoreVo> scoreVos){
        for (ScoreVo vo:scoreVos){
            ScoreSport scoreSport = scoreSportService.selectScoreSportBySportId(vo.getId().toString());
            if (StringUtils.isNotNull(scoreSport)){
                if (!scoreSport.getTimeStatus().equals(vo.getTime_status())){
                    scoreSportService.deleteScoreSportBySportId(vo.getId().toString());
                }else{
                  continue;
                }
            }
            ScoreSport sport=new ScoreSport();
            sport.setSportId(vo.getId().toString());
            long time = vo.getTime().getTime();
            sport.setTime(new Date(time*1000));
            sport.setTimeStatus(vo.getTime_status());
            if (StringUtils.isNotNull(vo.getLeague())){
                sport.setLeague(JSON.toJSONString(vo.getLeague()));
            }
            if (StringUtils.isNotNull(vo.getHome())){
                sport.setHome(JSON.toJSONString(vo.getHome()));
            }
            if (StringUtils.isNotNull(vo.getO_home())){
                sport.setoHome(JSON.toJSONString(vo.getO_home()));
            }
            if (StringUtils.isNotNull(vo.getAway())){
                sport.setAway(JSON.toJSONString(vo.getAway()));
            }
            sport.setSs(vo.getSs());
            if (StringUtils.isNotNull(vo.getScores())){
                sport.setScores(JSON.toJSONString(vo.getScores()));
            }
            if (StringUtils.isNotNull(vo.getStats())){
                sport.setStats(JSON.toJSONString(vo.getStats()));
            }
            if (StringUtils.isNotNull(vo.getExtra())){
                sport.setExtra(JSON.toJSONString(vo.getExtra()));
            }
            if (StringUtils.isNotNull(vo.getEvents())){
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
            scoreSportService.insertScoreSport(sport);
        }
    }
}
