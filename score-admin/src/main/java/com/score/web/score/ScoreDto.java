package com.score.web.score;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.score.system.domain.scoreVo.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class ScoreDto {

    private Long id;

    private String sport_id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    private String time_status;

    private LeagueVo league;

    private HomeVo home;

    private HomeVo o_home;

    private HomeVo away;

    private String ss;

    private ScoresVo scores;

    private StatsVo stats;

    private ExtraVo extra;

    private List<EventsVo> events;

    private Integer has_lineup;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inplay_created_at;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inplay_updated_at;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date confirmed_at;

    private Long bet365_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSport_id() {
        return sport_id;
    }

    public void setSport_id(String sport_id) {
        this.sport_id = sport_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTime_status() {
        return time_status;
    }

    public void setTime_status(String time_status) {
        this.time_status = time_status;
    }

    public LeagueVo getLeague() {
        return league;
    }

    public void setLeague(LeagueVo league) {
        this.league = league;
    }

    public HomeVo getHome() {
        return home;
    }

    public void setHome(HomeVo home) {
        this.home = home;
    }

    public HomeVo getO_home() {
        return o_home;
    }

    public void setO_home(HomeVo o_home) {
        this.o_home = o_home;
    }

    public HomeVo getAway() {
        return away;
    }

    public void setAway(HomeVo away) {
        this.away = away;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public ScoresVo getScores() {
        return scores;
    }

    public void setScores(ScoresVo scores) {
        this.scores = scores;
    }

    public StatsVo getStats() {
        return stats;
    }

    public void setStats(StatsVo stats) {
        this.stats = stats;
    }

    public ExtraVo getExtra() {
        return extra;
    }

    public void setExtra(ExtraVo extra) {
        this.extra = extra;
    }

    public List<EventsVo> getEvents() {
        return events;
    }

    public void setEvents(List<EventsVo> events) {
        this.events = events;
    }

    public Integer getHas_lineup() {
        return has_lineup;
    }

    public void setHas_lineup(Integer has_lineup) {
        this.has_lineup = has_lineup;
    }

    public Date getInplay_created_at() {
        return inplay_created_at;
    }

    public void setInplay_created_at(Date inplay_created_at) {
        this.inplay_created_at = inplay_created_at;
    }

    public Date getInplay_updated_at() {
        return inplay_updated_at;
    }

    public void setInplay_updated_at(Date inplay_updated_at) {
        this.inplay_updated_at = inplay_updated_at;
    }

    public Date getConfirmed_at() {
        return confirmed_at;
    }

    public void setConfirmed_at(Date confirmed_at) {
        this.confirmed_at = confirmed_at;
    }

    public Long getBet365_id() {
        return bet365_id;
    }

    public void setBet365_id(Long bet365_id) {
        this.bet365_id = bet365_id;
    }
}
