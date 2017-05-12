package servlets;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dom.EventText;
import service.EventTextService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by stijnergeerts on 5/05/17.
 */
@WebServlet("/photo")
public class PhotoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "globe-shanghai",
                "api_key", "487671746465751",
                "api_secret", "8jgQTrfU97rWk5Quqm1hP2I11hM"
        ));

        final String title = req.getParameter("title");

        final String eventId = req.getParameter("eventId");

        final String[] array = req.getParameterValues("photo");

        final EventTextService eventTextService = new EventTextService();

        EventText eventText = new EventText();

        String jsonString = null;
        try {
            jsonString = eventTextService.getEventText("https://photoapp-backend.herokuapp.com/api/event/getEventTextById/"+eventId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        eventText = gson.fromJson(jsonString, EventText.class);

        String favicon = cloudinary.url().format("jpg")
                .transformation(new Transformation())
                .generate(eventText.getCloudinaryDirectory()+"/logo");
        String linkIcon = cloudinary.url().format("jpg")
                .transformation(new Transformation().height(300).width(300))
                .generate(eventText.getCloudinaryDirectory()+"/logo");
        String logo = cloudinary.url().format("jpg")
                .transformation(new Transformation())
                .imageTag(eventText.getCloudinaryDirectory()+"/logo", Cloudinary.asMap("alt","Logo_"+title));
        String qrImage = cloudinary.url().format("jpg")
                .transformation(new Transformation())
                .imageTag(eventText.getCloudinaryDirectory()+"/qr", Cloudinary.asMap("alt","Qr_"+title));
        for(int i = 0; i<array.length; i++){
            array[i]=
                    cloudinary.url().format("jpg")
                            .transformation(new Transformation())
                            .imageTag(eventText.getCloudinaryDirectory()+"/"+array[i], Cloudinary.asMap("alt","Sample Image"));
        }
        req.setAttribute("favicon", favicon);
        req.setAttribute("linkIcon", linkIcon);
        req.setAttribute("logo", logo);
        req.setAttribute("qr", qrImage);
        req.setAttribute("photos",array);
        req.setAttribute("eventText", eventText);

        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req,resp);
    }
}
