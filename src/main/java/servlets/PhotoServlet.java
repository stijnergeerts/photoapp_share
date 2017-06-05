package servlets;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dom.Event;
import service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/photo")
public class PhotoServlet extends HttpServlet {

    /**
     * Cloudinary configuration
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "globe-shanghai",
                "api_key", "487671746465751",
                "api_secret", "8jgQTrfU97rWk5Quqm1hP2I11hM"
        ));

        /**
         * Filter the eventId and photo parameters out of the URL
         */
        final String eventId = req.getParameter("eventId");

        final String[] photos = req.getParameterValues("photo");

        final EventService eventService = new EventService();

        Event event;

        /**
         * Make a backend-call to retrieve the right event in JSON format
         */
        String jsonString = eventService.getJSON("https://photoapp-backend.herokuapp.com/api/event/getEventShareById/" + eventId);

        /**
         * Parse the JSON string into an Event object
         */
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        event = gson.fromJson(jsonString, Event.class);

        /**
         * Get the selected pictures out of the Cloudinary library
         */
        for (int i = 0; i < photos.length; i++) {
            photos[i] =
                    cloudinary.url().format("jpg")
                            .transformation(new Transformation())
                            .imageTag(event.getEventName() + "/event-photos/" + photos[i], Cloudinary.asMap("alt", "event-image-"+i));
        }

        /**
         * Set the attributes for the request
         */
        req.setAttribute("photos", photos);
        req.setAttribute("event", event);

        /**
         * Call the JSP page
         */
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
    }
}
