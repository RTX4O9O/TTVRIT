package me.rtx4090;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.rtx4090.GUI.Notify;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Profiles {
    public File jsonProfiles = new File(System.getProperty("user.home") + "/TTVRIT/profiles.json");;

    public Map<String, Profile> savedProfiles() {
        Map<String, Profile> profiles;
        Gson gson = new Gson();

        if (jsonProfiles.exists()) {
            try {
                Type type = new TypeToken<Map<String, Profile>>() {}.getType();
                profiles = gson.fromJson(new FileReader(jsonProfiles), type);
                if (profiles == null) {
                    profiles = new HashMap<>();
                }

                // 現在，profiles 是一個 Map，其中包含了所有的個人資料
                // 您可以使用 profiles.get("範例") 來獲取名為 "範例" 的個人資料

            } catch (IOException e) {
                e.printStackTrace();
                Notify.error(e.getMessage());
                profiles = new HashMap<>();
            }
        } else if (jsonProfiles.getParentFile().exists()) {
            try {
                jsonProfiles.createNewFile();
            } catch (IOException e) {
                Notify.error(e.getMessage());
                throw new RuntimeException(e);

            }
            profiles = new HashMap<>();
        } else {
            jsonProfiles.getParentFile().mkdir();
            try {
                jsonProfiles.createNewFile();
            } catch (IOException e) {
                Notify.error(e.getMessage());
                throw new RuntimeException(e);
            }
            profiles = new HashMap<>();
        }

        return profiles;
    }

}