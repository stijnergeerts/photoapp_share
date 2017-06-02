package service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dom.Event;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by stijnergeerts on 1/06/17.
 */
public class EventServiceTest {

    private EventService eventService = new EventService();

    private Event event = new Event();

    private Cloudinary cloudinary;

    private String array[] = {"0","1"};

    private String eventId = "5930d5f57a30470004d9916a";

    @Before
    public void setup() {
        /**
         * Setup Cloudinary
         */
         cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "globe-shanghai",
                "api_key", "487671746465751",
                "api_secret", "8jgQTrfU97rWk5Quqm1hP2I11hM"
        ));
        /**
         * Make a backend-call to retrieve the right event in JSON format
         */
        String jsonString = null;
        jsonString = eventService.getJSON("https://photoapp-backend.herokuapp.com/api/event/getEventShareById/"+eventId);


        /**
         * Parse the JSON string into an Event object
         */
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        event = gson.fromJson(jsonString, Event.class);

        /**
         * Get test photo's from Cloudinary
         */
        for(int i = 0; i<array.length; i++){
            array[i]=
                    cloudinary.url().format("jpg")
                            .transformation(new Transformation())
                            .imageTag(event.getEventName()+"/event-photos/"+array[i], Cloudinary.asMap("alt","Sample Image"));
        }
    }

    @Test
    public void aCheckSharePageComponents() {
        assertEquals("Test Tab Title", event.eventText.tabTitle,"TabTitle must be Test Tab Title");
        assertEquals("Test Event", event.eventName,"EventName must be Test Event");
        assertEquals("https://res.cloudinary.com/globe-shanghai/image/upload/v1496372099/Test%20Event/share-page-layout/logo.jpg", event.eventText.logo, "Logo must be https://res.cloudinary.com/globe-shanghai/image/upload/v1496372099/Test%20Event/share-page-layout/logo.jpg");
        assertEquals("Test Page Title", event.eventText.textUpper,"TextUpper must be Test Page Title");
        assertEquals("Test Text above pictures", event.eventText.textAbovePhoto,"TextAbovePhoto must be Test Text above pictures");
        assertEquals("<img src='http://res.cloudinary.com/globe-shanghai/image/upload/v1/Test%20Event/event-photos/0.jpg' alt='Sample Image'/>", array[0],"First photo must be http://res.cloudinary.com/globe-shanghai/image/upload/v1/Test%20Event/event-photos/0.jpg' alt='Sample Image'/>");
        assertEquals("<img src='http://res.cloudinary.com/globe-shanghai/image/upload/v1/Test%20Event/event-photos/1.jpg' alt='Sample Image'/>", array[1],"Second photo must be <img src='http://res.cloudinary.com/globe-shanghai/image/upload/v1/Test%20Event/event-photos/1.jpg' alt='Sample Image'/>/>");
        assertEquals("Test Text under pictures", event.eventText.textUnderPhoto, "TextUnderPhoto must be Test Text under pictures");
        assertEquals("https://res.cloudinary.com/globe-shanghai/image/upload/v1496372020/Test%20Event/share-page-layout/qr.png", event.eventText.qrCodeImage, "QrCodeImage must be https://res.cloudinary.com/globe-shanghai/image/upload/v1496372020/Test%20Event/share-page-layout/qr.png");
        assertEquals("Test Text Bottom", event.eventText.textBottom, "TextBottom must be Test Text Bottom");
        assertEquals(true, event.eventText.backgroundImageToggle, "BackgroundImageToggle must be true");
        assertEquals("https://res.cloudinary.com/globe-shanghai/image/upload/v1496377797/Test%20Event/share-page-layout/background.jpg", event.eventText.backgroundImage,"BackgroundImage must be https://res.cloudinary.com/globe-shanghai/image/upload/v1496377797/Test%20Event/share-page-layout/background.jpg");
        assertEquals("#73fa79", event.eventText.backgroundColor,"BackgroundColor must be #73fa79");
    }
}
