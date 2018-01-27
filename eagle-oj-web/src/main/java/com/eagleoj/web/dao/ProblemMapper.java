package com.eagleoj.web.dao;

import com.eagleoj.web.entity.ProblemEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Smith
 **/
@Repository
public interface ProblemMapper {
    int save(ProblemEntity problemEntity);

    ProblemEntity getByPid(int pid);

    List<Map<String, Object>> listProblemTagsByPid(int pid);

    List<ProblemEntity> listAll();

    List<Map<String, Object>> listShared(@Param("difficult") int difficult, @Param("tag") String tag);

    List<ProblemEntity> listAuditing();

    List<Map<String, Object>> listSharedWithUserStatus(@Param("difficult") int difficult,
                                                       @Param("tag") String tag, @Param("uid") int uid);

    List<ProblemEntity> listByUid(int uid);

    int updateDescriptionByPid(@Param("pid") int pid, @Param("data") ProblemEntity data);

    int updateSettingByPid(@Param("pid") int pid, @Param("data") ProblemEntity data);

    int updateTimesByPid(@Param("pid") int pid, @Param("data") ProblemEntity data);

    int refuseByPid(int pid);

    int acceptByPid(int pid);

}