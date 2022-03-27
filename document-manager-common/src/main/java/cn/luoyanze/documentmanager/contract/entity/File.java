package cn.luoyanze.documentmanager.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 5:13 PM
 */


public class File {

    @JsonProperty("editor")
    private String editor;

    @JsonProperty("lastEditorTime")
    private String lastTime;

    @JsonProperty("fileContent")
    private String ctx;

    public File(String editor, String lastTime, String ctx) {
        this.editor = editor;
        this.lastTime = lastTime;
        this.ctx = ctx;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getCtx() {
        return ctx;
    }

    public void setCtx(String ctx) {
        this.ctx = ctx;
    }
}
