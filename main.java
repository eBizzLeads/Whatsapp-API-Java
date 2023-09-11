import okhttp3.*;

import java.io.IOException;

public class WapifyService {

    private static final String API_URL = "https://app.wapify.net/api/";
    private static final String API_KEY = "Your API Key";
    private static final String INSTANCE = "Your Instance Key";
    private static final OkHttpClient client = new OkHttpClient();

    public static String sendMessage(String number, String msg) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("number", number)
                .add("msg", msg)
                .add("instance", INSTANCE)
                .add("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(API_URL + "text-message.php")
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String sendMediaMessage(String number, String msg, String media) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("number", number)
                .add("msg", msg)
                .add("media", media)
                .add("instance", INSTANCE)
                .add("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(API_URL + "media-message.php")
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String createGroup(String member, String groupName) throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("member", member)
                .add("group_name", groupName)
                .add("instance", INSTANCE)
                .add("apikey", API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(API_URL + "create-group.php")
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException {
        // Test sendMessage
        System.out.println(sendMessage("91xxxxxxxx", "Your Message Here"));

        // Test sendMediaMessage
        System.out.println(sendMediaMessage("91xxxxxxxx", "Your Caption Here", "Media URL With HTTPS"));

        // Test createGroup
        System.out.println(createGroup("91xxxxxxxx,91xxxxxxx,91xxxxxxx", "My Group"));
    }
}
