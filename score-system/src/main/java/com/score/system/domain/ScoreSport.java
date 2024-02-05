package com.score.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.score.common.annotation.Excel;
import com.score.common.core.domain.BaseEntity;

/**
 * 足球列表对象 score_sport
 *
 * @author score
 * @date 2024-02-01
 */
public class ScoreSport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 数据类型 */
    @Excel(name = "数据类型")
    private String dataType;

    /** 运动Id */
    @Excel(name = "运动Id")
    private String sportId;

    /** time */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "time", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    /** 状态 */
    @Excel(name = "状态")
    private String timeStatus;

    /** 联赛 */
    @Excel(name = "联赛")
    private String league;

    /** 主场 */
    @Excel(name = "主场")
    private String home;

    /** o_home */
    @Excel(name = "o_home")
    private String oHome;

    /** 客场 */
    @Excel(name = "客场")
    private String away;

    /** 比分 */
    @Excel(name = "比分")
    private String ss;

    /** 详细比分 */
    @Excel(name = "详细比分")
    private String scores;

    /** stats */
    @Excel(name = "stats")
    private String stats;

    /** extra */
    @Excel(name = "extra")
    private String extra;

    /** has_lineup */
    @Excel(name = "has_lineup")
    private Long hasLineup;

    /** inplay_created_at */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "inplay_created_at", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date inplayCreatedAt;

    /** inplay_updated_at */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "inplay_updated_at", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date inplayUpdatedAt;

    /** confirmed_at */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "confirmed_at", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date confirmedAt;

    /** bet365_id */
    @Excel(name = "bet365_id")
    private String bet365Id;

    /** 事件 */
    @Excel(name = "事件")
    private String events;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDataType(String dataType)
    {
        this.dataType = dataType;
    }

    public String getDataType()
    {
        return dataType;
    }
    public void setSportId(String sportId)
    {
        this.sportId = sportId;
    }

    public String getSportId()
    {
        return sportId;
    }
    public void setTime(Date time)
    {
        this.time = time;
    }

    public Date getTime()
    {
        return time;
    }
    public void setTimeStatus(String timeStatus)
    {
        this.timeStatus = timeStatus;
    }

    public String getTimeStatus()
    {
        return timeStatus;
    }
    public void setLeague(String league)
    {
        this.league = league;
    }

    public String getLeague()
    {
        return league;
    }
    public void setHome(String home)
    {
        this.home = home;
    }

    public String getHome()
    {
        return home;
    }
    public void setoHome(String oHome)
    {
        this.oHome = oHome;
    }

    public String getoHome()
    {
        return oHome;
    }
    public void setAway(String away)
    {
        this.away = away;
    }

    public String getAway()
    {
        return away;
    }
    public void setSs(String ss)
    {
        this.ss = ss;
    }

    public String getSs()
    {
        return ss;
    }
    public void setScores(String scores)
    {
        this.scores = scores;
    }

    public String getScores()
    {
        return scores;
    }
    public void setStats(String stats)
    {
        this.stats = stats;
    }

    public String getStats()
    {
        return stats;
    }
    public void setExtra(String extra)
    {
        this.extra = extra;
    }

    public String getExtra()
    {
        return extra;
    }
    public void setHasLineup(Long hasLineup)
    {
        this.hasLineup = hasLineup;
    }

    public Long getHasLineup()
    {
        return hasLineup;
    }
    public void setInplayCreatedAt(Date inplayCreatedAt)
    {
        this.inplayCreatedAt = inplayCreatedAt;
    }

    public Date getInplayCreatedAt()
    {
        return inplayCreatedAt;
    }
    public void setInplayUpdatedAt(Date inplayUpdatedAt)
    {
        this.inplayUpdatedAt = inplayUpdatedAt;
    }

    public Date getInplayUpdatedAt()
    {
        return inplayUpdatedAt;
    }
    public void setConfirmedAt(Date confirmedAt)
    {
        this.confirmedAt = confirmedAt;
    }

    public Date getConfirmedAt()
    {
        return confirmedAt;
    }
    public void setBet365Id(String bet365Id)
    {
        this.bet365Id = bet365Id;
    }

    public String getBet365Id()
    {
        return bet365Id;
    }
    public void setEvents(String events)
    {
        this.events = events;
    }

    public String getEvents()
    {
        return events;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("dataType", getDataType())
                .append("sportId", getSportId())
                .append("time", getTime())
                .append("timeStatus", getTimeStatus())
                .append("league", getLeague())
                .append("home", getHome())
                .append("oHome", getoHome())
                .append("away", getAway())
                .append("ss", getSs())
                .append("scores", getScores())
                .append("stats", getStats())
                .append("extra", getExtra())
                .append("hasLineup", getHasLineup())
                .append("inplayCreatedAt", getInplayCreatedAt())
                .append("inplayUpdatedAt", getInplayUpdatedAt())
                .append("confirmedAt", getConfirmedAt())
                .append("bet365Id", getBet365Id())
                .append("events", getEvents())
                .toString();
    }
}
