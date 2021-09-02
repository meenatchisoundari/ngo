package ngoactivityportal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;


public class SendOTP {
    public static void sendOTP(String message,String number,String apiKey){
        try{
            String sendId="TXTIND";
            String language = "english";
            String route = "v3";

            message = URLEncoder.encode(message,"UTF-8");

            String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
            URL url = new URL(myUrl);  
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent","Mozilla/5.0");
            con.setRequestProperty("cache-control", "no-cache");

            int responseCode = con.getResponseCode();
            StringBuffer response = new StringBuffer();
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            while(true){
                String line = br.readLine();
                if(line==null){
                    break;
                }
                response.append(line);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public SendOTP(String otp,String number){
        String apiKey="07pGXvh9MBrHxWsLlwyIzDk6oNEVgQfJaATUjm4SKYPO351ZcdMZiopDHR2edTtQBYCnUNWrhjcmyAsu";
        sendOTP(otp, number, apiKey);
    }
//    public static void main(String[] args) {
//        new SendOTP("896333","6374296506");
//    }
}
