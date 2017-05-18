package dom;

/**
 * Created by stijnergeerts on 18/05/17.
 */
public class Event {
    public String eventName;
    public EventText eventText;

    public Event(String eventName, EventText eventText) {
        this.eventName = eventName;
        this.eventText = eventText;
    }

    public Event() {
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventText getEventText() {
        return eventText;
    }

    public void setEventText(EventText eventText) {
        this.eventText = eventText;
    }
}
