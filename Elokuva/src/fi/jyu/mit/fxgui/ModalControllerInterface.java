package fi.jyu.mit.fxgui;

/**
 * ModalControllerInterface replacement for fxgui compatibility
 */
public interface ModalControllerInterface<T> {
    
    /**
     * Set default values for the dialog
     */
    void setDefault(T defaultValues);
    
    /**
     * Get result from the dialog
     */
    T getResult();
    
    /**
     * Handle when dialog is shown
     */
    default void handleShown() {
        // Default empty implementation
    }
}
