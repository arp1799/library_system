 package librarysystem;

import java.net.*;


public class SendEmailUsingGMailSMTP {
public static void main(String[] args) {
try {
String recipient = "404-09873188447";
String message = " Greetings from Library!New Account Has been Created! Have a nice day!";
String username = "admin";
String password = "12345";
String originator = "404-07875534059";
String requestUrl  = "http://127.0.0.1:9501/api?action=sendmessage&" +
 "username=" + URLEncoder.encode(username, "UTF-8") +
 "&password=" + URLEncoder.encode(password, "UTF-8") +
 "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
 "&messagetype=SMS:TEXT" +
 "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
 "&originator=" + URLEncoder.encode(originator, "UTF-8") +
 "&serviceprovider=GSMModem1" +
 "&responseformat=html";
URL url = new URL(requestUrl);
HttpURLConnection uc = (HttpURLConnection)url.openConnection();
System.out.println(uc.getResponseMessage());
uc.disconnect();
} catch(Exception ex) {
System.out.println(ex.getMessage());
}
}
}