/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.serie;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khalil
 */
public class ServiceSerie {
    
    public static ServiceSerie instance=null;
    
    public static boolean resultOK = true;
    
    
    private ConnectionRequest req;
    
    public static ServiceSerie getInstance(){
        if (instance == null)
            instance = new ServiceSerie();
        return instance;
    }
    
    public ServiceSerie() {
        req = new ConnectionRequest();
    
    }
    
    
    
    //ajout
    public void ajoutserie(serie serie){
    
        String url = Statics.BASE_URL+"/addserie/x?title="+serie.getTitle()+"&episode="+serie.getEpisode()+"&saison="+serie.getSaison()+"&date="+serie.getDate()+"&nomrealisateur="+serie.getNomrealisateur()+"&categorie="+serie.getCategorie()+"&image="+serie.getImage()+"&video="+serie.getVideo();
        
        req.setUrl(url);
        req.addResponseListener((e)-> {
        String str = new String (req.getResponseData());
        System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    
    
    
  //affichage
    public ArrayList<serie>afficherserie(){
    ArrayList<serie> result = new ArrayList<>();
    String url= Statics.BASE_URL+"/displayserie/x";
    req.setUrl(url);
    
    req.addResponseListener(new ActionListener<NetworkEvent>(){
    @Override
    public void actionPerformed(NetworkEvent evt) {
        JSONParser jsonp;
        jsonp = new JSONParser();
        try{
            Map<String,Object>mapserie = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
            
            List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapserie.get("root");
            
            for(Map<String,Object> obj : listOfMaps) {
                serie se = new serie();
                float id = Float.parseFloat(obj.get("id").toString());
                
                String title = obj.get("title").toString();
                String episode = obj.get("episode").toString();
                String saison = obj.get("saison").toString();
                String date = obj.get("date").toString();
                String nomrealisateur = obj.get("nomrealisateur").toString();
                String categorie = obj.get("categorie").toString();
                String image = obj.get("image").toString();
                String video = obj.get("video").toString();
                
                se.setId((int)id);
                se.setTitle(title);
                se.setEpisode(episode);
                se.setSaison(saison);
                se.setDate(date);
                se.setNomrealisateur(nomrealisateur);
                se.setCategorie(categorie);
                se.setImage(image);
                se.setVideo(video);
                
                result.add(se);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    });
    
    NetworkManager.getInstance().addToQueueAndWait(req);
            
    return result;
    
    }
    
    
    
    //detail
    public serie detailserie(int id ,serie serie){
    String url= Statics.BASE_URL+"/detailserie/x"+id;
    req.setUrl(url);
    
    String str = new String (req.getResponseData());
    req.addResponseListener(((evt) -> {
        JSONParser jsonp = new JSONParser();
        try{
            Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
            
            serie.setTitle(obj.get("title").toString());
            serie.setEpisode(obj.get("episode").toString());
            serie.setSaison(obj.get("saison").toString());
            serie.setDate(obj.get("date").toString());
            serie.setNomrealisateur(obj.get("nomrealisateur").toString());
            serie.setCategorie(obj.get("categorie").toString());
            serie.setImage(obj.get("image").toString());
            serie.setVideo(obj.get("video").toString());
            
            
            
        }catch(IOException ex){
            System.out.println("error related to sql :( "+ex.getMessage());
        }
        
        
        System.out.println("data === "+str);
    
    }));
    NetworkManager.getInstance().addToQueueAndWait(req);
    return serie;
    
    }
    
    
    public boolean deleteserie(int id) {
        String url= Statics.BASE_URL+"/deleteserie/x?id="+id;
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String url= Statics.BASE_URL+"/deleteserie/x?id="+id;
        req.setUrl(url);
                req.removeResponseCodeListener(this);
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
    
    //update
    public boolean modifierserie(serie serie){
        String url= Statics.BASE_URL+"/updateserie/x?id="+serie.getId()+"&title="+serie.getTitle()+"&episode="+serie.getEpisode()+"&saison="+serie.getSaison()+"&date="+serie.getDate()+"&nomrealisateur="+serie.getNomrealisateur()+"&categorie="+serie.getCategorie()+"&image="+serie.getImage()+"&video="+serie.getVideo();
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
        
    }
    
}
