package mosi.bloom.earn.bud.services;


import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Harendra Kumar on 08-01-2016.
 */
public class CheckService {

    public static String email= null;
    public static String status="FAILURE";
    public static String checkMKUser(String phone){
        URL url = null;
        String userXML = "";
        try {
            url = new URL("https://walletapi.mobikwik.com/querywallet?checksum="+
                    "486708b2c7e6c0981284f3e3484cc3e6c62a1d9cc206928ceacf0a02e9d63362&cell="+
                    phone +"&msgcode=500&mid=MBK9002&merchantname=TestMerchant&action=existingusercheck");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();

            StringBuffer buffer = new StringBuffer();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            userXML = buffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userXML;
    }

    static public String getStatus(String phone){
        DocumentBuilder db = null;
        Document doc = null;


        try {
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(checkMKUser(phone)));
       doc = db.parse(is);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        NodeList node = doc.getElementsByTagName("status");
        Element element = (Element) node.item(0);
        status = getCharacterDataFromElement(element);
        email = null;
        if(status.equalsIgnoreCase("success")){
            node = doc.getElementsByTagName("emailaddress");
            element = (Element) node.item(0);
            email = getCharacterDataFromElement(element);
        }
        return status;
    }

    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }

    public static void main(String... args){
        System.out.println("Harendra " + getStatus("9623280300"));
        System.out.println("Harendra's Email " + email);
        System.out.println("Manvi " + getStatus("8373901251"));
        System.out.println("Manvi's Email " + email);
        System.out.println("Akshay " + getStatus("9921753733"));
        System.out.println("Akshay's Email " + email);
        System.out.println("Avi " + getStatus("9686935601"));
        System.out.println("Avi's Email " + email);

    }

}
