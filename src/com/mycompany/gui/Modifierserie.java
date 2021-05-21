/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.serie;
import com.mycompany.services.ServiceSerie;

/**
 *
 * @author khalil
 */
public class Modifierserie extends BaseForm {
    
    Form current;
    public Modifierserie(Resources res,serie s) {
         super("Newsfeed",BoxLayout.y());
        
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajouter Serie");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
        
        TextField title = new TextField(s.getTitle(),"Title",20,TextField.ANY);
        TextField episode = new TextField(s.getEpisode(),"Episode",20,TextField.ANY);
        TextField saison = new TextField(s.getSaison(),"Saison",20,TextField.ANY);
        TextField date = new TextField(s.getDate(),"Date",20,TextField.ANY);
        TextField nomrealisateur = new TextField(s.getNomrealisateur(),"Nom realisateur",20,TextField.ANY);
        TextField categorie = new TextField(s.getCategorie(),"Categorie",20,TextField.ANY);
        TextField image = new TextField(s.getImage(),"Image",20,TextField.ANY);
        TextField video = new TextField(s.getVideo(),"Video",20,TextField.ANY);
        
        
        title.setUIID("NewsTopLine");
        title.setSingleLineTextArea(true);
        episode.setUIID("NewsTopLine");
        episode.setSingleLineTextArea(true);
        saison.setUIID("NewsTopLine");
        saison.setSingleLineTextArea(true);
        date.setUIID("NewsTopLine");
        date.setSingleLineTextArea(true);
        nomrealisateur.setUIID("NewsTopLine");
        nomrealisateur.setSingleLineTextArea(true);
        categorie.setUIID("NewsTopLine");
        categorie.setSingleLineTextArea(true);
        image.setUIID("NewsTopLine");
        image.setSingleLineTextArea(true);
        video.setUIID("NewsTopLine");
        video.setSingleLineTextArea(true);
        
        Button btnModifier = new Button("Modifier");
        btnModifier.setUIID("Button");
        
        btnModifier.addPointerPressedListener(l-> {
            s.setTitle(title.getText());
            s.setEpisode(episode.getText());
            s.setSaison(saison.getText());
            s.setDate(date.getText());
            s.setNomrealisateur(nomrealisateur.getText());
            s.setCategorie(categorie.getText());
            s.setImage(image.getText());
            s.setVideo(video.getText());
        
        
        if(ServiceSerie.getInstance().modifierserie(s)){
            new Listserie(res).show();
        }
        });
        
        Button btnAnnuler = new Button("Annuler");
        btnAnnuler.addActionListener(e->{
            new Listserie(res).show();
        });
        
        Label l1 = new Label("");
        Label l2 = new Label("");
        Label l3 = new Label("");
        Label l4 = new Label("");
        Label l5 = new Label("");
        Label l6 = new Label("");
        Label l7 = new Label("");
        Label l8 = new Label("");
        
        Container content = BoxLayout.encloseY(
                l1,l2,l3,l4,l5,l6,l7,l8,
                new FloatingHint(title),
                createLineSeparator(),
                new FloatingHint(episode),
                createLineSeparator(),
                new FloatingHint(saison),
                createLineSeparator(),
                new FloatingHint(date),
                createLineSeparator(),
                new FloatingHint(nomrealisateur),
                createLineSeparator(),
                new FloatingHint(categorie),
                createLineSeparator(),
                new FloatingHint(image),
                createLineSeparator(),
                new FloatingHint(video),
                createLineSeparator(),
                btnModifier,
                btnAnnuler
                
        );
        add(content);
        show();
        
        
    }
    
}
