///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.myapp;
//import com.codename1.components.ScaleImageLabel;
//import com.codename1.ui.Button;
//import com.codename1.ui.Command;
//import static com.codename1.ui.Component.BOTTOM;
//import com.codename1.ui.Dialog;
//import com.codename1.ui.FontImage;
//import com.codename1.ui.Form;
//import com.codename1.ui.Image;
//import com.codename1.ui.Label;
//import com.codename1.ui.TextField;
//import com.codename1.ui.Toolbar;
//import com.codename1.ui.events.ActionEvent;
//import com.codename1.ui.events.ActionListener;
//import com.codename1.ui.layouts.BorderLayout;
//import com.codename1.ui.layouts.BoxLayout;
//import com.codename1.ui.layouts.GridLayout;
//import com.codename1.ui.layouts.LayeredLayout;
//import com.codename1.ui.plaf.Style;
//import com.codename1.ui.spinner.Picker;
//import com.codename1.ui.util.Resources;
//import com.mycompany.entities.Voyage;
//import com.mycompany.myapp.MyApplication;
//import com.mycompany.services.VoyageService;
///**
// *
// * @author House_Info
// */
//public class AjoutVoyage {
//
//public class addHotelForm extends Form {
//
//    addHotelForm instance;
//
//    public addHotelForm(Resources res) {
//        super(new BorderLayout());
//        Toolbar tb = new Toolbar(true);
//        setToolbar(tb);
//        getTitleArea().setUIID("Container");
//        setTitle("Add");
//        getContentPane().setScrollVisible(false);
//  TextField prix = new TextField("", "Prix", 20, TextField.DECIMAL);
//        TextField destination = new TextField("", "destination");
//        TextField categorie = new TextField("", "categorie");
//        TextField description = new TextField("", "description");
//        TextField programme = new TextField("", "programme");
//        TextField inclut = new TextField("", "inclut");
//          TextField lat = new TextField("", "lat", 20, TextField.DECIMAL);
//            TextField lng = new TextField("", "lng", 20, TextField.DECIMAL);
//      
//        TextField ninclut = new TextField("", "ninclut");
//        Picker datedebut = new Picker();
//        Picker datefin = new Picker();
//      
//
//        
//
//        Image img = res.getImage("profile-background.jpg");
//
//        ScaleImageLabel sl = new ScaleImageLabel(img);
//        sl.setUIID("BottomPad");
//        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
//
//        Label facebook = new Label();
//        Label twitter = new Label();
//        facebook.setTextPosition(BOTTOM);
//        twitter.setTextPosition(BOTTOM);
//
//        add(LayeredLayout.encloseIn(
//                sl
//                
//        ));
//
//        addAll(prix, destination, categorie, description,programme,inclut,lat,lng,ninclut);
//        Button btnValider = new Button("Valider");
//
//        btnValider.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                if ((prix.getText().length() == 0) || (destination.getText().length() == 0) || (categorie.getText().length() == 0) 
//                        || (description.getText().length() == 0)|| (programme.getText().length() == 0)|| (inclut.getText().length() == 0)
//                        || (lat.getText().length() == 0)|| (lng.getText().length() == 0)|| (ninclut.getText().length() == 0)|| (datedebut.getText().length() == 0)|| (datefin.getText().length() == 0)) {
//                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
//                } else {
//                    try {
//                        Voyage v = new Voyage( Integer.parseInt(prix.getText()), destination.getText(),categorie.getText(), description.getText(),programme.getText(),inclut.getText(),Integer.parseInt(lat.getText()),Integer.parseInt(lng.getText()),ninclut.getText(), datedebut.getDate(), datefin.getDate());
//                        if (VoyageService.getInstance().addVoyage(v)) {
//                            Dialog.show("Success", "Connection accepted", new Command("OK"));
//                        } else {
//                            Dialog.show("ERROR", "Server error", new Command("OK"));
//                        }
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                        System.out.println(e.getStackTrace());
//                    }
//
//                }
//
//            }
//        });
//
//        add(btnValider);
//
//        getToolbar()
//                .addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent evt
//                    ) {
//                        new showVoyage(MyApplication.theme).show();
//                    }
//                }
//                );
//
//    }
//
//}
//
//}
