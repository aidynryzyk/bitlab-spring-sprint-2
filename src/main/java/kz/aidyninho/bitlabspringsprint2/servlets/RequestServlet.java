package kz.aidyninho.bitlabspringsprint2.servlets;

import kz.aidyninho.bitlabspringsprint2.entity.Course;
import kz.aidyninho.bitlabspringsprint2.entity.Request;
import kz.aidyninho.bitlabspringsprint2.repository.CourseRepository;
import kz.aidyninho.bitlabspringsprint2.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RequestServlet {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "none") String show, Model model) {
        List<Request> requests = null;
        switch (show) {
            case "handled" -> requests = requestRepository.findAllByHandled(true);
            case "unhandled" -> requests = requestRepository.findAllByHandled(false);
            case "none" -> requests = requestRepository.findAll();
        }
        model.addAttribute("requests", requests);
        return "index";
    }

    @GetMapping("/add")
    public String addGet(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "add";
    }

    @PostMapping("/add")
    public String addPost(Request request) {
        requestRepository.save(request);
        return "redirect:/";
    }

    @GetMapping("/addCourse")
    public String addCourseGet(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "addCourse";
    }

    @PostMapping("/addCourse")
    public String addCoursePost(Course course) {
        courseRepository.save(course);
        return "redirect:/";
    }

    @GetMapping("/details")
    public String detailsGet(@RequestParam Long id, Model model) {
        Request request = requestRepository.findById(id).get();
        model.addAttribute("request", request);
        return "details";
    }

    @PostMapping("/details")
    public String detailsPost(@RequestParam Long id, @RequestParam String action) {
        switch (action) {
            case "Delete" -> requestRepository.deleteById(id);
            case "Handle" -> {
                Request request = requestRepository.findById(id).get();
                request.setHandled(true);
                requestRepository.save(request);
            }
        }
        return "redirect:/";
    }
}
