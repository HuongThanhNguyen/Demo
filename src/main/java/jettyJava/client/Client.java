package jettyJava.client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jettyJava.server.Respond;
public class Client {
	

	public static String sendRequestLogin(String user, String pass, String api, String token) {
		String result = " ";
		try {

			StringBuilder postData = new StringBuilder();
			String userPass = user + "/" + pass + "/" + api + "/"+ token + "/";
			String urlStr = "http://localhost:8888/" + userPass;
			URL u = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();

			// post method
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			// data to send
			postData.append(user + "/" + pass + "/" + api + "/" + token);
			String encodedData = postData.toString();
			System.out.println("send data " + encodedData);
			// send data by byte
			conn.setRequestProperty("Content-Language", "en-US");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", (new Integer(encodedData.length())).toString());
			byte[] postDataByte = postData.toString().getBytes("UTF-8");
			try {
				OutputStream out = conn.getOutputStream();
				out.write(postDataByte);
				out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				result = ex.toString();
			}
			// get data from server
			InputStreamReader isr = new InputStreamReader(conn.getInputStream());
			BufferedReader buf = new BufferedReader(isr);

			// write
			result = buf.readLine();
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			Respond respond = gson.fromJson(result, Respond.class);
			if (respond.getToken() != null) {
				writeFile(respond.getToken());
			}

		} catch (Exception ex) {
			System.out.println(ex.toString());
			result = ex.toString();
		}
		return result;
	}
	

	public static String login(String user, String pass, String api,String token) {
		String result = sendRequestLogin(user,pass,api,token);
		return result;
	}

	public static void main(String[] args) {
		// expected: Message Success
		System.out.println(Client.login("thanh", "12346", "edit", readFile()));
	}
	
	private static void writeFile(String token){
		try {
			OutputStream output = new FileOutputStream("token.txt", false);
			PrintWriter prw=new PrintWriter(output);
			prw.println(token);
			prw.flush();
			prw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static String readFile(){
		String token1="";
		try {
			File fileInput = new File("token.txt");
			FileReader fr = new FileReader(fileInput);
			BufferedReader bfr = new BufferedReader(fr);
			token1 =bfr.readLine();			
			bfr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return token1;
	}
}
