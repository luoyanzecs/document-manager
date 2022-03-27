package cn.luoyanze.documentmanager.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    /**
     * 子文件
     */
    @JsonProperty("children")
    private Menu subs;

    public Menu(String id, String title, Menu subs) {
        this.id = id;
        this.title = title;
        this.subs = subs;
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

    public Menu getSubs() {
        return subs;
    }

    public void setSubs(Menu subs) {
        this.subs = subs;
    }
}
