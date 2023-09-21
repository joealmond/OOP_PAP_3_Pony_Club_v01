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
    // van alapból az enumban
    // plusz munka ez az osztály

    public String getSign(){
        return this.sign;
    }
}
