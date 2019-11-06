package com.zyp.entity;

public class City {
    private Integer id;
    private String code;//城市编号
    private String name;//城市名
    private String provincecode;//省份编号

    public City() {
    }

    public City(Integer id, String code, String name, String provincecode) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.provincecode = provincecode;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", provincecode='" + provincecode + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode;
    }
}
