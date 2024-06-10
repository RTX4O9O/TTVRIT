package me.rtx4090;

public class ProfileInUse {
    public static Profile profileInUse;
    public static String profileNickname;
    public static Profile getProfileInUse(){
        return profileInUse;
    }
    public static void setProfileInUse(Profile profile, String nickname) {
        profileInUse = profile;
        profileNickname = nickname;
    }
}
