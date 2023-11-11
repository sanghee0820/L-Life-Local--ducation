package Lducation.demo.domain;

public enum Day {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");
    private String desc;

    Day(String desc) {
        this.desc = desc;
    }
}
