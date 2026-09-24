package dmit.view;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

@Named
@ViewScoped
public class CampusEvent implements Serializable {

    private int submssionCount = 2601;

    public int getSubmssionCount() {
        return submssionCount;
    }

    private int eventId;

    @NotBlank(message = "Please give a name for the event!")
    private String eventName;

    @NotBlank(message = "Please provide a name to the form!")
    private String organizerName;

    @NotBlank(message = "Please set a date for the event!")
    private LocalDate eventDate;

    @NotNull(message = "Please specify your events capacity!")
    private int capacity;

    public void submit(){
        submssionCount++;
        String messageDetail = String.format("Event Name:%s, Organizer Name: %s Event Date:%s Capacity:%s EventId:%s",
                eventName,
                organizerName,
                eventDate,
                capacity,
                eventId
        );

        FacesMessage message = new FacesMessage(
                FacesMessage.SEVERITY_INFO,
                "Form Submitted",
                messageDetail
        );
        FacesContext.getCurrentInstance()
                .addMessage(null,message);
        eventName=null;
        organizerName=null;
        eventName=null;
        capacity=0;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
