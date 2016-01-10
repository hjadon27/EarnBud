package mosi.bloom.earn.bud.pojo;

//import org.simpleframework.xml.Element;
//import org.simpleframework.xml.Root;

/**
 * Created by Harendra Kumar on 08-01-2016.
 */
//@Root(name = "response")
public class MobiKwikUser {
    //@Element(name = "messagecode")
    private String messagecode;

    //@Element(name = "status")
    private String status;

    //@Element(name = "statuscode")
    private String statuscode;

    //@Element(name = "statusdescription")
    private String statusdescription;

    //@Element(name = "emailaddress")
    private String emailaddress;

    //@Element(name = "nonzeroflag")
    private String nonzeroflag;

    //@Element(name = "messagecode")
    private String checksum;

    public String getMessagecode() {
        return messagecode;
    }

    public void setMessagecode(String messagecode) {
        this.messagecode = messagecode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    public String getStatusdescription() {
        return statusdescription;
    }

    public void setStatusdescription(String statusdescription) {
        this.statusdescription = statusdescription;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getNonzeroflag() {
        return nonzeroflag;
    }

    public void setNonzeroflag(String nonzeroflag) {
        this.nonzeroflag = nonzeroflag;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}


