package personal.buildbroad.model;

import java.io.Serializable;

/**
 * Created by root on 19-9-10.
 */

public class OrderResult implements Serializable {


    private int  id;
    private int status;
    private String name;
    private String lineNumber;
    private String building;
    private String config;
    private String createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "OrderResult{" +
                "id=" + id +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", lineNumber='" + lineNumber + '\'' +
                ", building='" + building + '\'' +
                ", config='" + config + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
