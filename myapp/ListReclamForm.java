/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ReclamationService;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Abirn
 */
public class ListReclamForm extends BaseForm {

    Form current;

    public ListReclamForm(Resources res) {

        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Lister réclamations");
        getContentPane().setScrollVisible(false);

        tb.addSearchCommand(e -> {
        });

        Tabs swipe = new Tabs();

        Label s1 = new Label();
        Label s2 = new Label();

        addTab(swipe, s1, res.getImage("back-logo.jpeg"), "", "", res);

        swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();

        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });

        Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
        RadioButton mesListes = RadioButton.createToggle("Mes Reclamations", barGroup);
        mesListes.setUIID("SelectBar");
        RadioButton vide = RadioButton.createToggle("", barGroup);
        vide.setUIID("SelectBar");
        RadioButton partage = RadioButton.createToggle("Reclamer", barGroup);
        partage.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("profile-background.jpg"), "Container");

        mesListes.addActionListener((e) -> {
            InfiniteProgress ip = new InfiniteProgress();
            final Dialog ipDlg = ip.showInifiniteBlocking();

              ListReclamForm a = new ListReclamForm(res);
              a.show();
            refreshTheme();
        });

        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(3, mesListes,vide, partage),
                FlowLayout.encloseBottom(arrow)
        ));

        partage.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(partage, arrow);
        });
        bindButtonSelection(mesListes, arrow);
        bindButtonSelection(vide, arrow);
        bindButtonSelection(partage, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });

        //Méthde d'affichage
        ArrayList<Reclamation> list = ReclamationService.getInstance().ListReclamation();

        for (Reclamation rec : list) {

            String urlImage = "reclam.png";

            Image placeHolder = Image.createImage(120, 90);
            EncodedImage enc = EncodedImage.createFromImage(placeHolder, false);
            URLImage urlim = URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);

            addButton(urlim, rec, res);

            ScaleImageLabel image = new ScaleImageLabel(urlim);
            Container containerImg = new Container();

            image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        }
    }

    private void addTab(Tabs swipe, Label spacer, Image image, String string, String text, Resources res) {

        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());

        if (image.getHeight() < size) {
            image = image.scaledHeight(size);
        }
        if (image.getHeight() > Display.getInstance().getDisplayHeight() / 2) {
            image = image.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
        }
        ScaleImageLabel imageScale = new ScaleImageLabel(image);
        imageScale.setUIID("Container");
        imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label overLay = new Label("", "ImageOverLay");

        Container page1
                = LayeredLayout.encloseIn(
                        imageScale,
                        overLay,
                        BorderLayout.south(
                                BoxLayout.encloseY(
                                        new SpanLabel(text, "LargeWhiteText"),
                                        spacer
                                )
                        )
                );

        swipe.addTab("", res.getImage("back-logo.jpeg"), page1);
    }

    private void bindButtonSelection(Button btn, Label l) {
        btn.addActionListener(e -> {
            if (btn.isSelected()) {
                updateArrowPosition(btn, l);
            }
        });
    }

    private void updateArrowPosition(Button btn, Label l) {
        l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth() / 2 - l.getWidth() / 2);
        l.getParent().repaint();
    }

    private void addButton(Image img, Reclamation rec, Resources res) {

        int height = Display.getInstance().convertToPixels(11.5f);
        int width = Display.getInstance().convertToPixels(14f);

        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");
        Container cnt = BorderLayout.west(image);

        Label sujetTxt = new Label("Sujet : " + rec.getSujet(), "NewsTopLine2");
        Label dateTxt = new Label("Date : " + rec.getDate(), "NewsTopLine2");
        Label descriptionTxt = new Label("Description : " + rec.getDescription(), "NewsTopLine2");

        createLineSeparator();

        //   cnt.add(BorderLayout.CENTER, BoxLayout.encloseY(BoxLayout.encloseX(sujetTxt),BoxLayout.encloseX(dateTxt),BoxLayout.encloseX(descriptionTxt)));
        //Delete
        Button lSupp = new Button("Supprimer");
        lSupp.setUIID("NewsTopLine");
        Style supprimerStyle = new Style(lSupp.getUnselectedStyle());
        supprimerStyle.setFgColor(0xf21f1f);

        FontImage suppImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
        lSupp.setIcon(suppImage);

        lSupp.setTextPosition(RIGHT);

        lSupp.addPointerPressedListener((l) -> {

            Dialog dig = new Dialog("DELETE");

            if (dig.show("Delete", "Vous voulez supprimer cette réclamation ?", "Annuler", "Oui")) {

                dig.dispose();

            } else {

                dig.dispose();
                //Appel
                if (ReclamationService.getInstance().deleteReclamation(rec.getId())) {

                    new ListReclamForm(res).show();
                }
            }
        });

        //Update
        Button lmod = new Button("Modifier");
        lmod.setUIID("NewsTopLine");
        Style modifierStyle = new Style(lmod.getUnselectedStyle());
        modifierStyle.setFgColor(0xf7ad02);

        FontImage modImage = FontImage.createMaterial(FontImage.MATERIAL_EDIT, modifierStyle);
        lmod.setIcon(modImage);

        lmod.setTextPosition(LEFT);
        lmod.addPointerPressedListener((l) -> {
            
           // System.out.println("Update");
           new UpdateReclamForm(res,rec).show();
            
        });

        cnt.add(BorderLayout.CENTER, BoxLayout.encloseY(
                BoxLayout.encloseX(sujetTxt),
                BoxLayout.encloseX(dateTxt),
                BoxLayout.encloseX(descriptionTxt),
                BoxLayout.encloseX(lmod,lSupp)));
        add(cnt);

//        Container cnt = new Container();
//        
//        TextArea ta = new TextArea(sujet);
//        ta.setUIID("NewsTopLine");
//        ta.setEditable(false);
//        
//        add(cnt);
    }
}
