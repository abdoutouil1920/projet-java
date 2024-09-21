package tn.esprit.projet_java.utils;

import javafx.scene.Parent;

import java.util.function.Consumer;

public class SharedContext {
    private static SharedContext instance;
    private int currentUserId = -1; // Default to -1, indicating no user

    private SharedContext() {}

    public static synchronized SharedContext getInstance() {
        if (instance == null) {
            instance = new SharedContext();
        }
        return instance;
    }


    public int getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(int currentUserId) {
        this.currentUserId = currentUserId;
    }

    public void clearCurrentUserId() {
        this.currentUserId = -1; // Reset to default state
    }

    private Consumer<Parent> changeCenterCallback;

    public void setChangeCenterCallback(Consumer<Parent> callback) {
        this.changeCenterCallback = callback;
    }

    public void changeCenterContent(Parent content) {
        if (changeCenterCallback != null) {
            changeCenterCallback.accept(content);
        }
}


}
