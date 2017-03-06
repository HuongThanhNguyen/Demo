package jettyJava.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.json.simple.JSONObject;

public abstract class Handler extends AbstractHandler {

    public static final String SUCCESS_RESPOND;
    public static final String ERROR_RESPOND;
    
    static{
        JSONObject json = new JSONObject();
        json.put("Message", "Success");
        SUCCESS_RESPOND = json.toJSONString();
        
        json = new JSONObject();
        json.put("Message", "Fail");
        ERROR_RESPOND = json.toJSONString();
        

    }
    
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	System.out.println(request);
        baseRequest.setHandled( true );
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        InputStreamReader isr = new InputStreamReader(request.getInputStream());
        BufferedReader reader = new BufferedReader(isr);
        String inputString = reader.readLine();
        String dataRespond = null;
        target=target.substring(1);
        String[] target1=target.split("/");
        System.out.println(target1[0]+": "+target1[1]);
        String checkUserPass=jettyJava.mongodb.InsertUpdateDB.checkUserPass(target1[0], target1[1]);
       
        if(validateParameter(target)){        	
            if(checkUserPass.equals("true")){
                dataRespond = SUCCESS_RESPOND;
            }else {
				dataRespond=ERROR_RESPOND;
			}
        }else{
            dataRespond = ERROR_RESPOND;
        }
        System.out.println("input string: " + inputString);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(dataRespond);
        writer.flush();
        writer.close();
    }
    
    public static boolean validateParameter(String param) {
        return ((param != null) && (!param.equals("")));
    }
}
