package fi.jyu.mit.fxgui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;

/**
 * ModalController replacement for fxgui compatibility
 */
public class ModalController {
    
    /**
     * Show modal dialog and return result
     */
    public static <T> T showModal(java.net.URL fxmlUrl, String title, Object owner, T defaultResult) {
        try {
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            
            // Try to get controller and set default
            Object controller = loader.getController();
            if (controller instanceof ModalControllerInterface) {
                @SuppressWarnings("unchecked")
                ModalControllerInterface<T> typedController = (ModalControllerInterface<T>) controller;
                typedController.setDefault(defaultResult);
            }
            
            stage.showAndWait();
            
            // Try to get result from controller
            if (controller instanceof ModalControllerInterface) {
                @SuppressWarnings("unchecked")
                ModalControllerInterface<T> typedController = (ModalControllerInterface<T>) controller;
                return typedController.getResult();
            }
            
            return defaultResult;
        } catch (Exception e) {
            e.printStackTrace();
            return defaultResult;
        }
    }
    
    /**
     * Close stage from any node
     */
    public static void closeStage(Node node) {
        if (node != null && node.getScene() != null && node.getScene().getWindow() instanceof Stage) {
            ((Stage) node.getScene().getWindow()).close();
        }
    }
}
