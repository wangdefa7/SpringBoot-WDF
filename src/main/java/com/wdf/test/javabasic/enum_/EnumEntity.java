package com.wdf.test.javabasic.enum_;

public enum EnumEntity {

    SUCCESS(true,0,"成功"),
    ERROR(false,1,"失败");

    private Boolean flag;
    private Integer num;
    private String msg;

    /**
     * @Author WDF
     * @Description 构造函数传参
     * @Date 16:42 2020/4/16
     * @Param [flag, num, msg]
     * @return
     **/
    EnumEntity (Boolean flag,int num,String msg){
        this.flag = flag;
        this.msg = msg;
        this.num = num;
    }

    //获取参数的方法
    public static Integer getNum(String msg){
        for (EnumEntity entity : EnumEntity.values()){
            if (entity.name().equals(msg)){
                return entity.num;
            }
        }
        return null;
    }

    public static String getMsg(String msg){
        for (EnumEntity entity : EnumEntity.values()){
            if (entity.name().equals(msg))
                return entity.msg;
        }
        return null;
    }

    /*  set get方法 */

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
