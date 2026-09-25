package dmit.view;

import com.sun.faces.application.applicationimpl.events.EventInfo;
import dmit.model.CampusEvent;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class EventInfoSession implements Serializable {
    private List<CampusEvent> events = new ArrayList<>();

    public void add(CampusEvent newCapusEvent){
        events.add(newCapusEvent);
    }

    public void remove(CampusEvent existingCampusEvent) {
        events.remove(existingCampusEvent);
    }

    public List<CampusEvent> getEvents(){
        return events;
    }
}
