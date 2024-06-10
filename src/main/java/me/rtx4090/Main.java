package me.rtx4090;

import me.rtx4090.gui.MainWindow;
import me.rtx4090.gui.tabs.report.Driver;

public class Main {
    public static void main(String[] args) {
        MainWindow appwindow = new MainWindow();
        //Notify.error();
    }
    public static Profile profileInUse;
    public static void setProfileInUse(Profile profile) {
        profileInUse = profile;
    }
}
