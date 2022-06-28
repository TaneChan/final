package com.demo.mapper;

import com.demo.entity.Post;
import com.demo.entity.Reply;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/2/23 22:14
 */
@Component
public interface PostMapper {
    /**
     * 添加主题
     *
     * @param id
     * @param pname
     * @param papartment
     * @param ptitle
     * @param pcontent
     * @param psession
     * @return
     */
    @Insert("insert into post (id,pname,papartment,ptitle,pcontent,psession,pdate) " +
            "values (#{id},#{pname},#{papartment},#{ptitle},#{pcontent},#{psession},now())")
    void addpost(@Param("id") String id,
                 @Param("pname") String pname,
                 @Param("papartment") String papartment,
                 @Param("ptitle") String ptitle,
                 @Param("pcontent") String pcontent,
                 @Param("psession") int psession);

    @Insert("insert into user_post (id,pid) " +
            "values(#{id},#{pid})")
    void adduserpost(@Param("id") String id,
                     @Param("pid") int pid);

    /**
     * 查询所有主题
     *
     * @return List <Post>
     */
    @Select("select * from post where psession=2")
    List<Post> list2();

    @Select("select * from post where psession=1")
    List<Post> list1();

    @Select("select * from post")
    List<Post> list();

    /**
     * 更新信息
     *
     * @param ptitle
     * @param pcontent
     * @param psession
     * @param pid
     * @return
     */
    @Update("update post set ptitle=#{ptitle},pcontent=#{pcontent},psession=#{psession} where pid=#{pid}")
    void updatePost(@Param("ptitle") String ptitle,
                    @Param("pcontent") String pcontent,
                    @Param("psession") int psession,
                    @Param("pid") int pid);

    /**
     * 删除post
     *
     * @param pid
     */
    @Delete("delete post,reply from post left join reply on post.pid=reply.pid where post.pid=#{pid}")
    void deletePost(@Param("pid") int pid);

    @Insert("insert into post_gomi select * from post where pid=#{pid}")
    void Post_gomi(@Param("pid") int pid);

    @Delete("delete from post_gomi where pid=#{pid}")
    void deletePost_gomi(@Param("pid") int pid);

    @Insert("insert into post select * from post_gomi where pid=#{pid}")
    void postBack(@Param("pid") int pid);

    @Select("select * from post where  CONCAT(ptitle,pcontent) LIKE CONCAT('%',#{ps},'%')")
    List<Post> postSearch(@Param("ps") String ps);

    @Select("select * from post where pid=#{pid}")
    Post getPostById(@Param("pid") int pid);

    @Select("select * from reply where pid=#{pid} order by rdate desc")
    List<Reply> getPostRepliesByPid(@Param("pid") int pid);

    @Select("select * from reply where id=#{id}")
    List<Reply> getPostRepliesByid(@Param("id") String id);

    @Select("select * from post where id=#{id}")
    List<Post> getPostsById(@Param("id") String id);

    @Select("select * from post where concat(ptitle,papartment,pname) like concat('%',#{search},'%')")
    List<Post> search(@Param("search")String search);

}
