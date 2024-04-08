package fxElokuva;

import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import fi.jyu.mit.fxgui.*;

public class GenrelisaaController implements ModalControllerInterface<Genre>{

    @FXML private TextField genrekuvaus;
    @FXML private TextField genrenimi;



    @Override
    public Genre getResult() {
        return new Genre(genrenimi.getText(), genrekuvaus.getText());
    }

    @Override
    public void setDefault(Genre genre) {

    }

    @Override
    public void handleShown() {

    }
    public void luoGenre(){
        ModalController.closeStage(genrekuvaus);
    }
}
