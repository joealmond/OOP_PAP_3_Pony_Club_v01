package com.codecool.model.ability;

public enum MagicType {

    FIREBAL("#"),
    ICEBALL("*"),
    TEQBALL("&");

    private final String sign;
    MagicType(String sign) {
        this.sign = sign;
    }

    public static MagicType[] getValues() {
        return MagicType.values();
    }

    public String getSign(){
        return this.sign;
    }
}
