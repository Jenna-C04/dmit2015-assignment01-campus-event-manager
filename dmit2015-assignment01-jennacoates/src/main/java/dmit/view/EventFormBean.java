package dmit.view;

import com.sun.faces.application.applicationimpl.events.EventInfo;
import dmit.model.CampusEvent;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDate;

@Named
@ViewScoped
public class EventFormBean implements Serializable {

    private int submssionCount;

    public int getSubmssionCount() {
        return submssionCount;
    }

    private CampusEvent campusEvent = new CampusEvent();    ///Getter

    @Inject
    private EventInfoSession eventInfoSession;

    public CampusEvent getCampusEvent() {
        return campusEvent;
    }

    public void submit(){
        submssionCount++;

        eventInfoSession.add(campusEvent);

        String messageDetail = String.format("Event Name:%s, Organizer Name: %s Event Date:%s Capacity:%s EventId:%s",
                campusEvent.getEventName(),
                campusEvent.getOrganizerName(),
                campusEvent.getEventDate(),
                campusEvent.getCapacity(),
                campusEvent.getEventId()
        );

        FacesMessage message = new FacesMessage(
                FacesMessage.SEVERITY_INFO,
                "Form Submitted",
                messageDetail
        );
        FacesContext.getCurrentInstance()
                .addMessage(null,message);
                campusEvent = new CampusEvent();
    }

    public EventInfoSession getEventInfoSession() {
        return eventInfoSession;
    }
}
