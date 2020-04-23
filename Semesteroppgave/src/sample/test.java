package sample;

import java.io.Serializable;

public class test implements Serializable {

    String delNavn;

    public test(String delNavn) {
        this.delNavn = delNavn;
    }

    public String getDelNavn() {
        return delNavn;
    }

    public void setDelNavn(String delNavn) {
        this.delNavn = delNavn;
    }
}
