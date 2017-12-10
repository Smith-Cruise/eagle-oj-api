package org.inlighting.oj.web.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.SqlSession;
import org.inlighting.oj.judge.LanguageEnum;
import org.inlighting.oj.judge.ResultEnum;
import org.inlighting.oj.judge.config.CodeLanguageEnum;
import org.inlighting.oj.judge.config.ProblemStatusEnum;
import org.inlighting.oj.web.dao.ContestProblemDao;
import org.inlighting.oj.web.dao.SubmissionDao;
import org.inlighting.oj.web.dao.UserDao;
import org.inlighting.oj.web.entity.SubmissionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Smith
 **/
@Service
public class SubmissionService {

    private final SqlSession sqlSession;

    private SubmissionDao submissionDao;

    private ContestProblemDao problemInfoDao;

    private UserDao userDao;

    public SubmissionService(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Autowired
    public void setSubmissionDao(SubmissionDao submissionDao) {
        this.submissionDao = submissionDao;
    }

    @Autowired
    public void setProblemInfoDao(ContestProblemDao problemInfoDao) {
        this.problemInfoDao = problemInfoDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public int add(int owner, int pid, int cid, int sourceCode, LanguageEnum lang, double time, int memory,
                   ResultEnum status) {
        SubmissionEntity submissionEntity = new SubmissionEntity();
        submissionEntity.setOwner(owner);
        submissionEntity.setPid(pid);
        submissionEntity.setCid(cid);
        submissionEntity.setSourceCode(sourceCode);
        submissionEntity.setLang(lang);
        submissionEntity.setTime(time);
        submissionEntity.setMemory(memory);
        submissionEntity.setStatus(status);
        submissionEntity.setSubmitTime(System.currentTimeMillis());
        return submissionDao.insert(sqlSession, submissionEntity) ? submissionEntity.getSid(): 0;
    }
}
