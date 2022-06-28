package com.demo.mapper;

import com.demo.entity.Event;
import com.demo.entity.Event_Reply;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/2/22 0:10
 */
@Component
public interface EventMapper {
    /**
     * 查询全部活动
     *
     * @return
     */
    @Select("select * from event")
    List<Event> listAllEvent();

    @Insert("insert into event (etitle,econtent,ecount,epoint1,epoint2,startime,endtime) " +
            "values (#{etitle},#{econtent},0,#{epoint1},#{epoint2},#{startime},#{endtime})")
    void addEvent(@Param("etitle") String etitle,
                  @Param("econtent") String econtent,
                  @Param("epoint1") int epoint1,
                  @Param("epoint2") int epoint2,
                  @Param("startime") Date startime,
                  @Param("endtime") Date endtime);

    @Update("update event set etitle=#{etitle},econtent=#{econtent},epoint1=#{epoint1},epoint2=#{epoint2},startime=#{startime},endtime=#{endtime} where eid=#{eid}")
    void updateEvent(@Param("etitle") String etitle,
                     @Param("eid") int eid,
                     @Param("econtent") String econtent,
                     @Param("epoint1") int epoint1,
                     @Param("epoint2") int epoint2,
                     @Param("startime") Date startime,
                     @Param("endtime") Date endtime);

    @Select("select * from event where eid=#{eid}")
    Event getEventById(@Param("eid") int eid);

    @Delete("delete event,event_reply from event left join event_reply on event.eid=event_reply.eid where event.eid=#{eid};")
    void deleteEById(@Param("eid") int eid);

    @Insert("insert into user_event (uid,eid,etitle) values (#{uid},#{eid},#{etitle})")
    void enterEvent(@Param("uid") String uid,
                    @Param("eid") int ueid,
                    @Param("etitle") String uetitle);

    @Update("update event set ecount=ecount+1 where eid=#{eid}")
    void eventCountPlus(@Param("eid") int eid);

    /**
     * 查询活动所有回复
     *
     * @param eid
     * @return
     */
    @Select("select *  from event_reply where eid=#{eid} order by date desc")
    List<Event_Reply> erbyEid(@Param("eid") int eid);

    /**
     * 查询某用户的活动回复
     *
     * @param uid
     * @return
     */
    @Select("select *  from event_reply where uid=#{uid}")
    List<Event_Reply> erbyUid(@Param("uid") int uid);

    @Update("update user_event set etitle=#{etitle} where eid=#{eid}")
    void updateUser_event(@Param("etitle") String etitle, @Param("eid") int eid);

    @Select("select * from event_reply where uid like CONCAT('%',#{uid},'%')")
    List<Event_Reply> searchERByUid(@Param("uid") String uid);

    @Select("select * from event_reply where uid=#{uid}")
    List<Event_Reply> getEventReplyByUid(@Param("uid") String uid);

    @Select("select * from event where etitle like CONCAT('%',#{etitle},'%')")
    List<Event> searchEvent(@Param("etitle") String etitle);

    @Delete("delete from event_reply where erid=#{erid}")
    void deleteer(@Param("erid") int erid);

    @Select("select * from eventshow where eid=#{eid} order by date desc")
    List<Event_Reply> evshow(@Param("eid") int eid);

    @Insert("insert into eventshow(erid,eid,etitle,uid,content,date,uname) select erid,eid,etitle,uid,content,date,uname from event_reply where erid=#{erid}")
    void goodevr(@Param("erid") int erid);

    @Update("update user set point1=point1+#{epoint1},point2=point2+#{epoint2} where id=#{uid}")
    void goodEvrPoi(@Param("epoint1") int epoint1,
                    @Param("epoint2") int epoint2,
                    @Param("uid") String uid);

    @Delete("delete from eventshow where id=#{id}")
    void deleteGood(@Param("id") int id);

    @Update("update user set point1=point1-#{epoint1},point2=point2-#{epoint2} where id=#{uid}")
    void goodEvrPoiOut(@Param("epoint1") int epoint1,
                       @Param("epoint2") int epoint2,
                       @Param("uid") String uid);

    @Select("select * from event where endtime>=now()")
    List<Event> indexEvent();

    @Select("select * from eventshow order by date desc limit 10")
    List<Event_Reply> indexEventReplyList();

    @Insert("insert into event_reply(etitle,eid,uid,uname,content,date) values (#{etitle},#{eid},#{uid},#{uname},#{content},now())")
    void replyEvent(@Param("etitle") String etitle,
                    @Param("eid") int eid,
                    @Param("uid") String uid,
                    @Param("uname") String uname,
                    @Param("content") String content);


}
