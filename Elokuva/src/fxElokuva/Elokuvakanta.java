package fxElokuva;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import java.awt.*;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;

//alertit yms
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javax.swing.*;
import javax.xml.namespace.QName;

//lista
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;

//ohjelmat
import fxElokuva.Elokuvat;
import fxElokuva.Elokuva;
import fxElokuva.ElokuvaMain;

public class Elokuvakanta {

    private Elokuvat elokuvalista = new Elokuvat();
    private Genret genret = new Genret();
}
