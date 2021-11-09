import Page.login;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class TestRunner extends Setup{
    login objlogin;
    @Test(enabled = false)
    public void dologin() throws Exception {
        driver.get("http://automationpractice.com");
        objlogin=new login(driver);

        JSONParser jsonParser =new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/user.json"));
        JSONArray jsonArray = (JSONArray) obj;


        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        String email =(String) jsonObject.get("email");
        String password =(String) jsonObject.get("password");

        String user= objlogin.dologin(email,password);
        Assert.assertEquals(user,"Test User");

        

    }

    @Test(enabled = false)
    public void dologinforwrongpassword() throws Exception {
        driver.get("http://automationpractice.com");
        objlogin=new login(driver);

        JSONParser jsonParser =new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/user.json"));
        JSONArray jsonArray = (JSONArray) obj;


        JSONObject jsonObject = (JSONObject) jsonArray.get(1);


        String email =(String) jsonObject.get("email");
        String password =(String) jsonObject.get("password");


        String authErrorr= objlogin.dologinForNagetiver (email,password);
        Assert.assertEquals(authErrorr,"Authentication failed.");

}

    @Test(enabled = true)
    public void invalEmail() throws Exception {
        driver.get("http://automationpractice.com");
        objlogin=new login(driver);

        JSONParser jsonParser =new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/user.json"));
        JSONArray jsonArray = (JSONArray) obj;


        JSONObject jsonObject = (JSONObject) jsonArray.get(2);


        String email =(String) jsonObject.get("email");
        String password =(String) jsonObject.get("password");


        String emailErrorr= objlogin.invalEmail (email,password);
        Assert.assertEquals(emailErrorr,"Invalid email address.");

    }
}
