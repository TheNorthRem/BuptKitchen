package com.bupt.pojo;

import java.util.Map;

public class WeekMenu {
    private Integer id;
    private Integer Monday;
    private Integer Tuesday;
    private Integer Wednesday;
    private Integer Thursday;
    private Integer Friday;
    private Integer Saturday;
    private Integer Sunday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonday() {
        return Monday;
    }

    public void setMonday(Integer monday) {
        Monday = monday;
    }

    public Integer getTuesday() {
        return Tuesday;
    }

    public void setTuesday(Integer tuesday) {
        Tuesday = tuesday;
    }

    public Integer getWednesday() {
        return Wednesday;
    }

    public void setWednesday(Integer wednesday) {
        Wednesday = wednesday;
    }

    public Integer getThursday() {
        return Thursday;
    }

    public void setThursday(Integer thursday) {
        Thursday = thursday;
    }

    public Integer getFriday() {
        return Friday;
    }

    public void setFriday(Integer friday) {
        Friday = friday;
    }

    public Integer getSaturday() {
        return Saturday;
    }

    public void setSaturday(Integer saturday) {
        Saturday = saturday;
    }

    public Integer getSunday() {
        return Sunday;
    }

    public void setSunday(Integer sunday) {
        Sunday = sunday;
    }

    public void set(String day,int idd){
        switch (day){
            case "Monday":
                this.setMonday(idd);
                break;
            case "Tuesday":
                this.setTuesday(idd);
                break;
            case "Wednesday":
                this.setWednesday(idd);
                break;
            case "Thursday":
                this.setThursday(idd);
                break;
            case "Friday":
                this.setFriday(idd);
                break;
            case "Saturday":
                this.setSaturday(idd);
                break;

            case "Sunday":
                this.setSunday(idd);
                break;
            default:
                break;
        }
    }

    public Integer get(String day){

        switch (day){
            case "Monday":
                return Monday;

            case "Tuesday":

                return Tuesday;
            case "Wednesday":

                return Wednesday;
            case "Thursday":

                return Thursday;
            case "Friday":

                return Friday;
            case "Saturday":

                return Saturday;

            case "Sunday":

                return Sunday;
        }
        return null;
    }


    @Override
    public String toString() {
        return "weekmenu{" +
                "id=" + id +
                ", Monday=" + Monday +
                ", Tuesday=" + Tuesday +
                ", Wednesday=" + Wednesday +
                ", Thursday=" + Thursday +
                ", Friday=" + Friday +
                ", Saturday=" + Saturday +
                ", Sunday=" + Sunday +
                '}';
    }
}
