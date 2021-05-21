/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Reservation {
     private int Id ; 
    private Voyage Voyage ;
    private Date Datedebut ; 
    private float prix ; 
    private Date Datefin ; 
    private String Methodedepaiement ; 
    private Hotel Hotel ; 
    private User User ; 

    public Reservation() {
    }

    public Reservation(Voyage Voyage, Date Datedebut, float prix, Date Datefin, String Methodedepaiement, Hotel Hotel, User User) {
        this.Voyage = Voyage;
        this.Datedebut = Datedebut;
        this.prix = prix;
        this.Datefin = Datefin;
        this.Methodedepaiement = Methodedepaiement;
        this.Hotel = Hotel;
        this.User = User;
    }

    public Reservation(int Id, Voyage Voyage, Date Datedebut, float prix, Date Datefin, String Methodedepaiement, Hotel Hotel) {
        this.Id = Id;
        this.Voyage = Voyage;
        this.Datedebut = Datedebut;
        this.prix = prix;
        this.Datefin = Datefin;
        this.Methodedepaiement = Methodedepaiement;
        this.Hotel = Hotel;
    }

    
    public Reservation(int Id, Voyage Voyage, Date Datedebut, Date Datefin, String Methodedepaiement, Hotel Hotel, User User) {
        this.Id = Id;
        this.Voyage = Voyage;
        this.Datedebut = Datedebut;
        this.Datefin = Datefin;
        this.Methodedepaiement = Methodedepaiement;
        this.Hotel = Hotel;
        this.User = User;
    }

    public Reservation(Voyage Voyage, Date Datedebut, Date Datefin, String Methodedepaiement, Hotel Hotel, User User) {
        this.Voyage = Voyage;
        this.Datedebut = Datedebut;
        this.Datefin = Datefin;
        this.Methodedepaiement = Methodedepaiement;
        this.Hotel = Hotel;
        this.User = User;
    }

    public int getId() {
        return Id;
    }

    public Voyage getVoyage() {
        return Voyage;
    }

    public Date getDatedebut() {
        return Datedebut;
    }

    public Date getDatefin() {
        return Datefin;
    }

    public String getMethodedepaiement() {
        return Methodedepaiement;
    }

    public Hotel getHotel() {
        return Hotel;
    }

    public User getUser() {
        return User;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setVoyage(Voyage Voyage) {
        this.Voyage = Voyage;
    }

    public void setDatedebut(Date Datedebut) {
        this.Datedebut = Datedebut;
    }

    public void setDatefin(Date Datefin) {
        this.Datefin = Datefin;
    }

    public void setMethodedepaiement(String Methodedepaiement) {
        this.Methodedepaiement = Methodedepaiement;
    }

    public void setHotel(Hotel Hotel) {
        this.Hotel = Hotel;
    }

    public void setUser(User User) {
        this.User = User;
    }

  
}
