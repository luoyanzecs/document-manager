package cn.luoyanze.common.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 4:25 PM
 */

public class Menu {

    /**
     * 条目id
     */
    @JsonProperty("id")
    private String id;

    /**
     * 标题
     */
    @JsonProperty("title")
    private String title;

    private boolean isDir;

    /**
     * 子文件
     */
    @JsonProperty("children")
    private List<Menu> subs;

    public Menu() {
    }

    public Menu(String id, String title, boolean isDir, List<Menu> subs) {
        this.id = id;
        this.title = title;
        this.subs = subs;
        this.isDir = isDir;
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean dir) {
        isDir = dir;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Menu> getSubs() {
        return subs;
    }

    public void setSubs(List<Menu> subs) {
        this.subs = subs;
    }
}
