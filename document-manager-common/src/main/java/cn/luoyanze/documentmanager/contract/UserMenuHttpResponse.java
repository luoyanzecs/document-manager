package cn.luoyanze.documentmanager.contract;

import cn.luoyanze.documentmanager.contract.entity.Head;
import cn.luoyanze.documentmanager.contract.entity.Menu;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:48 PM
 */


public class UserMenuHttpResponse {

    /**
     * 头信息
     */
    @JsonProperty("head")
    private Head head;

    /**
     * 目录列表
     */
    @JsonProperty("items")
    private List<Menu> menus;

    public UserMenuHttpResponse(Head head, List<Menu> menus) {
        this.head = head;
        this.menus = menus;
    }


    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
