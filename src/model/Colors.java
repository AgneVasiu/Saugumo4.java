package model;


public class Colors {
    public static final String MAIN_RED = "#c90817";
    public static final String LIGHT_RED = "#f76571";
    public static final String MAIN_PURPLE = "#7d0a59";
    public static final String WHITE = "#ffffff";
    public static final String BLACK = "#000000";
    public static final String LIGHT_GREY = "#eaeaea";

    public static String setBackgroundColor(String color) { return "-fx-background-color: " + color + ";"; }
    public static String setTextColor(String color) {return "";}
}
