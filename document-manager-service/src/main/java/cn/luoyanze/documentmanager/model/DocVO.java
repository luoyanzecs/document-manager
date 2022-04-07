package cn.luoyanze.documentmanager.model;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/6 10:32 PM
 */


public class DocVO {

    private String uuid;

    private String parentId;

    private String title;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
