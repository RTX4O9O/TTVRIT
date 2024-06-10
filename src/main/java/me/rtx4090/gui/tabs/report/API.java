package me.rtx4090.gui.tabs.report;

import okhttp3.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class API {
    public static void fetch(String name, String id, String number, String email, String address, String report_date, String hour, String minute, String carcode, String district, String road_id,  String legislation2, String[] data, String checknum) {
        System.setProperty("file.encoding", "UTF-8");

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.MINUTES)
                .readTimeout(3, TimeUnit.MINUTES)
                .build();

        MultipartBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("name", name)
                .addFormDataPart("idcard", id)
                .addFormDataPart("tel", number)
                .addFormDataPart("email", email)
                .addFormDataPart("address2", address)
                .addFormDataPart("report_date", "2024-06-06")
                .addFormDataPart("hour", "02")
                .addFormDataPart("minute", "00")
                .addFormDataPart("carcode", "1243rvw")
                .addFormDataPart("district", "305")
                .addFormDataPart("road_id", "564")
                .addFormDataPart("address", "ewfwe")
                .addFormDataPart("legislation2", "8")
                .addFormDataPart("data[]", "hi.txt", RequestBody.create(MediaType.parse("text/plain"), "hi"))
                .addFormDataPart("data[]", "omg", RequestBody.create(MediaType.parse("image/png"), new File("D:\\Libraries\\Pictures\\emojis\\0.png")))
                .addFormDataPart("data[]", "")
                .addFormDataPart("data[]", "")
                .addFormDataPart("checknum", "32457")
                .build();

        System.out.println("sending request");
        Request request = new Request.Builder()
                .url("https://traffic.hchpb.gov.tw/index.php?catid=11&action=add")
                .post(requestBody)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:127.0) Gecko/20100101 Firefox/127.0")
                .build();

        try (ResponseBody body = client.newCall(request).execute().body()) {
            System.out.println(body.string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
