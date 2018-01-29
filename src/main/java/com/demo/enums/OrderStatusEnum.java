package com.demo.enums;

public enum OrderStatusEnum {

        SUCCESS("S","SUCCESS"),
        OUT_OF_STOCK("F","OUT OF STOCK");

        private String code, name;

        OrderStatusEnum(String code, String name){
            this.code = code;
            this.name = name;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderStatusEnum{");
        sb.append("code='").append(code).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
