package org.inlighting.oj.judge.bean;

public class StdRequestBean {

    @Deprecated
    private JudgeServerEnum judgeServer;

    private int testCaseNumber;

    private LanguageEnum language;

    private String sourceCode;

    private String[] stdin = null;

    private String[] expectResult = null;

    private int timeLimit = 2;

    private int memoryLimit = 128000;

    @Deprecated
    public JudgeServerEnum getJudgeServer() {
        return judgeServer;
    }

    @Deprecated
    public void setJudgeServer(JudgeServerEnum judgeServer) {
        this.judgeServer = judgeServer;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEnum language) {
        this.language = language;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String[] getStdin() {
        return stdin;
    }

    public void setStdin(String[] stdin) {
        this.stdin = stdin;
    }

    public String[] getExpectResult() {
        return expectResult;
    }

    public void setExpectResult(String[] expectResult) {
        this.expectResult = expectResult;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public int getTestCaseNumber() {
        return testCaseNumber;
    }

    public void setTestCaseNumber(int testCaseNumber) {
        this.testCaseNumber = testCaseNumber;
    }
}
