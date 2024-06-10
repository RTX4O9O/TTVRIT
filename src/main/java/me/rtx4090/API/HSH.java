package me.rtx4090.API;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class HSH extends Catalog {
    private static final byte[][] BITMAP = {
        new byte[] {0b00011000, 0b00100100, 0b01000010, 0b01000010, 0b01000010, 0b01000010, 0b01000010, 0b01000010, 0b00100100, 0b00011000},
        new byte[] {0b00001000, 0b00011000, 0b00101000, 0b00001000, 0b00001000, 0b00001000, 0b00001000, 0b00001000, 0b00001000, 0b00111110},
        new byte[] {0b00111100, 0b01000010, 0b01000010, 0b00000010, 0b00001100, 0b00010000, 0b00100000, 0b01000000, 0b01000000, 0b01111110},
        new byte[] {0b00111100, 0b01000010, 0b01000010, 0b00000010, 0b00011100, 0b00000010, 0b00000010, 0b01000010, 0b01000010, 0b00111100},
        new byte[] {0b00000100, 0b00001100, 0b00010100, 0b00100100, 0b01000100, 0b01000100, 0b01111110, 0b00000100, 0b00000100, 0b00000100},
        new byte[] {0b01111110, 0b01000000, 0b01000000, 0b01000000, 0b01111100, 0b00000010, 0b00000010, 0b00000010, 0b01000010, 0b00111100},
        new byte[] {0b00011100, 0b00100000, 0b01000000, 0b01000000, 0b01111100, 0b01000010, 0b01000010, 0b01000010, 0b01000010, 0b00111100},
        new byte[] {0b01111110, 0b00000010, 0b00000010, 0b00000100, 0b00000100, 0b00000100, 0b00001000, 0b00001000, 0b00001000, 0b00001000},
        new byte[] {0b00111100, 0b01000010, 0b01000010, 0b01000010, 0b00111100, 0b01000010, 0b01000010, 0b01000010, 0b01000010, 0b00111100},
        new byte[] {0b00111100, 0b01000010, 0b01000010, 0b01000010, 0b00111110, 0b00000010, 0b00000010, 0b00000010, 0b00000100, 0b00111000}
    };

    private static final OkHttpClient client = new OkHttpClient.Builder()
        .connectTimeout(3, TimeUnit.MINUTES)
        .readTimeout(3, TimeUnit.MINUTES)
        .build();

    private static String getCode(BufferedImage bufferedImage) {
        StringBuilder code = new StringBuilder();
        for (int n = 0; n < 5; n++) {
            code.append(getDigit(bufferedImage, n));
        }
        return code.toString();
    }

    private static int getDigit(BufferedImage bufferedImage, int n) {
        int[] colors = bufferedImage.getData().getPixels(3 + n * 15, 0, 8, 25, (int[]) null);
        byte[] chart = new byte[25];
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 8; j++) {
                int bit = colors[i * 8 + j] == 1 ? 1 : 0;
                int shiftBy = 7 - j;
                chart[i] |= bit << shiftBy;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (isNumber(i, chart)) return i;
        }

        return -1;
    }

    private static boolean isNumber(int number, byte[] chart) {
        byte[] numberMap = BITMAP[number];
        int i = 0;

        for (byte line : chart) {
            if (line == 0) continue;
            if (line != numberMap[i]) return false;
            i++;
        }

        return true;
    }

    @Override
    public void send(
        String name,
        String idcard,
        String tel,
        String email,
        String address2,
        String report_date,
        String hour,
        String minute,
        String carcode,
        String district,
        String road_id,
        String address,
        String legislation2,
        String data1,
        String data2,
        String data3,
        String data4) {

        String code;
        Request getImage = new Request.Builder().url("https://traffic.hchpb.gov.tw/makecheck.php").header("Cookie", "PHPSESSID=abcdefg").get().build();

        try (
            ResponseBody body = client.newCall(getImage).execute().body();
            InputStream stream = body.byteStream()
        ) {
            BufferedImage bufferedImage = ImageIO.read(stream);
            code = getCode(bufferedImage);
            System.out.println(code);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            MultipartBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("name", name)
                .addFormDataPart("idcard", idcard)
                .addFormDataPart("tel", tel)
                .addFormDataPart("email", email)
                .addFormDataPart("address2", address2)
                .addFormDataPart("report_date", report_date)
                .addFormDataPart("hour", hour)
                .addFormDataPart("minute", minute)
                .addFormDataPart("carcode", carcode)
                .addFormDataPart("district", district)
                .addFormDataPart("road_id", road_id)
                .addFormDataPart("address", address)
                .addFormDataPart("legislation2", legislation2)
                .addFormDataPart("data[]", getName(data1), getFile(data1))
                .addFormDataPart("data[]", getName(data2), getFile(data2))
                .addFormDataPart("data[]", getName(data3), getFile(data3))
                .addFormDataPart("data[]", getName(data4), getFile(data4))
                .addFormDataPart("checknum", code)
                .build();

            Request request = new Request.Builder()
                .url("https://traffic.hchpb.gov.tw/index.php?catid=11&action=add")
                .post(requestBody)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:127.0) Gecko/20100101 Firefox/127.0")
                .header("Cookie", "PHPSESSID=abcdefg")
                .build();

            client.newCall(request).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String getName(String path) {
        return new File(path).getName();
    }

    private static RequestBody getFile(String path) throws IOException {
        String mimeType = Files.probeContentType(Path.of(path));
        return RequestBody.create(MediaType.parse(mimeType), new File(path));
    }
}
