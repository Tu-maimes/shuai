package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.Statistics;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoAll;
import com.zhiyou100.video.model.VideoExample;
import com.zhiyou100.video.model.VideoFind;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

	List<VideoAll> selectVideo(VideoFind vf);

	Integer selectVideoCount(VideoFind vf);

	List<Statistics> selectStaistics();

	List<VideoAll> selectContents(@Param("courseId") Integer courseId);

	void addVideoStateCount(@Param("videoId")int videoId);


//	List<VideoAll> selectVideoCourse(@Param("subjectId")int subjectId);
}