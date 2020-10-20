package com.yadanoa.dayadan.Enum;

public enum OpTypeENUM {
    RK("RK","入库"),CH("CK","出库"),RKCK("RKCK","入库加出库");

    private String code;
    private String name;
    private OpTypeENUM(String code, String name) {
        this.code = code;
        this.name = name();
    }

    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setName(String name) {
        this.name = name;
    }


}
