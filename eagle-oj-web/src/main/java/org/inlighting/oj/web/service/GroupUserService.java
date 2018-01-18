package org.inlighting.oj.web.service;

import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.session.SqlSession;
import org.inlighting.oj.web.dao.GroupUserDao;
import org.inlighting.oj.web.entity.GroupUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Smith
 **/
@Service
public class GroupUserService {

    @Autowired
    private GroupUserDao groupUserDao;

    @Autowired
    private SqlSession sqlSession;

    public boolean add(int gid, int uid) {
        GroupUserEntity entity = new GroupUserEntity();
        entity.setGid(gid);
        entity.setUid(uid);
        entity.setJoinTime(System.currentTimeMillis());
        return groupUserDao.add(sqlSession, entity);
    }

    public List<Map<String, Object>> getUserGroups(int uid, PageRowBounds pager) {
        return groupUserDao.getUserGroups(sqlSession, uid, pager);
    }

    public GroupUserEntity getMember(int gid, int uid) {
        // 根据Uid和Gid获取group
        GroupUserEntity entity = new GroupUserEntity();
        entity.setGid(gid);
        entity.setUid(uid);
        return groupUserDao.getMember(sqlSession, entity);
    }

    public boolean updateRealName(int gid, int uid, String realName) {
        GroupUserEntity entity = new GroupUserEntity();
        entity.setGid(gid);
        entity.setUid(uid);
        entity.setRealName(realName);
        return groupUserDao.update(sqlSession, entity);
    }

    public boolean isIn(int gid, int uid) {
        return getMember(gid, uid) != null;
    }

    public List<Map<String, Object>> getMembers(int gid, PageRowBounds pager) {
        return groupUserDao.getMembers(sqlSession, gid, pager);
    }

    public boolean deleteMember(int gid, int uid) {
        //删除
        GroupUserEntity entity = new GroupUserEntity();
        entity.setGid(gid);
        entity.setUid(uid);
        return groupUserDao.deleteMember(sqlSession, entity);
    }
}
