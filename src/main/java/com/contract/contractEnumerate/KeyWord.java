package com.contract.contractEnumerate;

public enum KeyWord {
    NUM("[num]"),
    CREATE_TIME("[createtime]"),
    PartyB("[name]"),
    ID_NUM("[idnum]"),
    PHONE_NUM("[phone]"),
    BANK_ID("[banknum]"),
    BANK_NAME("[nban]"),
    ITEM_NAM("[item]"),
    PRICE("[price]"),
    END_TIME("[endtime]"),
    PartyB_NAMEPAGE("[picture]"),
    COMPANY("[company]"),
    PLACE("[place]");



    private String value;

    KeyWord(String value) {
        this.value = value;
    }

    /**
     * 根据类型的名称，返回类型的枚举实例。
     * @param typeName 类型名称
     */
    public static KeyWord fromTypeName(String typeName) {
        for (KeyWord keyWord : KeyWord.values()) {
            if (keyWord.getValue().equals(typeName)) {
                return keyWord;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }
}
