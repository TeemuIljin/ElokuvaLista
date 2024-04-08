package fxElokuva;

import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import fi.jyu.mit.fxgui.*;

public class ElokuvalisaaController implements ModalControllerInterface<Elokuva> {

    @FXML private TextField nimi;
    @FXML private TextField imdb;
    @FXML private TextField pituus;
    @FXML private ChoiceBox genre;


    public void setDefault(Elokuva oletus) {

    }
    public void handleShown() {
    }
    public Elokuva getResult() {
        int guid = ElokuvaMain.kanta.getElokuvalista().getElokuvat().size()+1;
        return new Elokuva(nimi.getText(), imdb.getText(), pituus.getText(), "", Integer.toString(guid));
    }
    public void luoElokuva(){
        ModalController.closeStage(nimi);
    }
}