package com.bupt.pojo;

public class DayMenu {
    private Integer id;
    private int Breakfast;
    private  int Lunch;
    private int Dinner;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBreakfast() {
        return Breakfast;
    }

    public void setBreakfast(int breakfast) {
        Breakfast = breakfast;
    }

    public int getLunch() {
        return Lunch;
    }

    public void setLunch(int lunch) {
        Lunch = lunch;
    }

    public int getDinner() {
        return Dinner;
    }

    public void setDinner(int dinner) {
        Dinner = dinner;
    }

    public void set(String time,int menuid){
        if(time.equals("breakfast")){
            this.setBreakfast(menuid);
        }else
        if(time.equals("lunch")){
            this.setLunch(menuid);
        }else
        if(time.equals("dinner")) {
            this.setDinner(menuid);
        }
    }

    @Override
    public String toString() {
        return "DayMenu{" +
                "id=" + id +
                ", Breakfast=" + Breakfast +
                ", Lunch=" + Lunch +
                ", Dinner=" + Dinner +
                '}';
    }
}
