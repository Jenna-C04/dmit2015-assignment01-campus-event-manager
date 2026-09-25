package dmit.view;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class EventView {

    public String submit(){
        return "view-events?faces-redirect=true";
    }
}
