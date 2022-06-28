package com.demo.mapper;

import com.demo.entity.Reply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/3/5 12:49
 */
@Component
public interface ReplyMapper {
    @Select("select * from reply where pid=#{pid}")
    List<Reply> listPReply(@Param("pid") int pid);

    @Select("select * from reply_gomi where pid=#{pid}")
    List<Reply> getReply_GomiByPid(@Param("pid") int pid);

    @Insert("insert into reply (rapartment,rname,pid,id,rcontent,rdate) " +
            "values (#{rapartment},#{rname},#{pid},#{id},#{rcontent},now())")
    void addReply(@Param("rapartment") String rapartment,
                  @Param("rname") String rname,
                  @Param("pid") int pid,
                  @Param("id") String id,
                  @Param("rcontent") String rcontent);

    @Delete("delete from reply where rid=#{rid}")
    void deleteReply(@Param("rid") int rid);

    @Insert("insert into reply_gomi select * from reply where rid=#{rid}")
    void addReply_gomi(@Param("rid") int rid);

    @Delete("delete from reply_gomi where rid=#{rid}")
    void deleteReply_gomi(@Param("rid") int rid);

    @Insert("insert into reply select * from reply_gomi where rid=#{rid}")
    void replyBack(@Param("rid") int rid);

    @Select("select * from reply where rid=#{rid}")
    Reply getReplyById(@Param("rid") int rid);

    @Delete("delete from reply where pid=#{pid}")
    void deleteReplyByPid(@Param("pid") int pid);
}
