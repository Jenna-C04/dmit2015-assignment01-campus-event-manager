package dmit.view;

import com.sun.faces.application.applicationimpl.events.EventInfo;
import dmit.model.CampusEvent;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDate;

@Named
@SessionScoped
public class EventFormBean implements Serializable {

    private int idCount = 2600;
    private int submssions;

    public int getSubmssions() {
        return submssions;
    }

    public int getSubmssionCount() {
        return idCount;
    }

    private CampusEvent campusEvent = new CampusEvent();    ///Getter

    @Inject
    private EventInfoSession eventInfoSession;
    public CampusEvent getCampusEvent() {
        return campusEvent;
    }

    public String getEventSummary(){
        return String.format("%s - %s", campusEvent.getEventName(), campusEvent.getEventDate());
    }

    public void submit(){
        idCount++;
        submssions++;

        eventInfoSession.add(campusEvent);


        String messageDetail = String.format("Event Name:%s, Organizer Name: %s Event Date:%s Capacity:%s EventId:%s",
                campusEvent.getEventName(),
                campusEvent.getOrganizerName(),
                campusEvent.getEventDate(),
                campusEvent.getCapacity(),
                campusEvent.getEventId() + idCount
        );

        FacesMessage message = new FacesMessage(
                FacesMessage.SEVERITY_INFO,
                "Form Submitted",
                messageDetail
        );
        FacesContext.getCurrentInstance()
                .addMessage(null,message);
//                campusEvent = new CampusEvent();
    }

    public EventInfoSession getEventInfoSession() {
        return eventInfoSession;
    }
}
