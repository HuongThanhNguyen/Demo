package jettyJava.client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;


public class Client {
    public static String sendRequest(String user, String pass){
        String result = " ";
        try{

        StringBuilder postData = new StringBuilder();
        String userPass=user+"/"+pass+"/";
        String urlStr = "http://localhost:8888/" +userPass;
        URL u = new URL( urlStr );
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();

        //post method
        conn.setDoOutput(true);
        conn.setRequestMethod( "POST" );
        //data to send
        postData.append(user+"/"+pass);
        String encodedData = postData.toString();
        System.out.println("send data " + encodedData);
        // send data by byte
        conn.setRequestProperty("Content-Language", "en-US");
        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length",(new Integer(encodedData.length())).toString());
        byte[] postDataByte = postData.toString().getBytes("UTF-8");
        try{
            OutputStream out = conn.getOutputStream();
            out.write(postDataByte);
            out.close();
        }catch(IOException ex){
            ex.printStackTrace();
            result = ex.toString();
        }
        //get data from server
        InputStreamReader isr = new InputStreamReader( conn.getInputStream() );
        BufferedReader buf = new BufferedReader( isr );

        //write
        result = buf.readLine();

        } catch( Exception ex ) {
            System.out.println(ex.toString());
            result = ex.toString();
        }
        return result;
    }
    
    public static String login(String user, String pass){
        String result = "";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", user);
        jsonObject.put("pass", pass);
        result = sendRequest(jsonObject.get("user").toString(), jsonObject.get("pass").toString());
        return result;
    }     
    
    public static void main(String[] args) {
        //expected: Message Success
        System.out.println(Client.login("thanh", "35235"));
    }
}
