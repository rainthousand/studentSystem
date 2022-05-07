package com.example.studentsystem.controller;

import com.example.studentsystem.entity.NewsLetter;
import com.example.studentsystem.pattern.factorymethod_visitor.UnitFactories.AdminUnitFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.UnitFactories.NotRegisteredUnitFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.UnitFactories.StudentUnitFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.UnitFactories.TeacherUnitFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.UnitFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.VisitorFactories.CoursePageVisitorFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.VisitorFactory;
import com.example.studentsystem.pattern.state_Role.Context_Role;
import com.example.studentsystem.pattern.strategy_redirect.Context_Redirect;
import com.example.studentsystem.pattern.strategy_redirect.Redirect;
import com.example.studentsystem.pattern.visitor.MainPageVisitor;
import com.example.studentsystem.pattern.visitor.ObjectStructure;
import com.example.studentsystem.pattern.visitor.Unit;
import com.example.studentsystem.pattern.visitor.UnitVisitor;
import com.example.studentsystem.pattern.visitor.unitClasses.AdminUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.NotRegisteredUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.StudentUnit;
import com.example.studentsystem.pattern.visitor.unitClasses.TeacherUnit;
import com.example.studentsystem.service.NewsletterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

import com.example.studentsystem.entity.NewsLetter;
import com.example.studentsystem.service.NewsletterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
public class RedirectController {
    @Resource(name = "newsletterServiceImpl")
    private NewsletterService newsletterService;

    //TODO Strategy Pattern to Redirect
    @RequestMapping(value = "/student/index", method = {RequestMethod.GET})
    public String studentToMainPage(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("name",session.getAttribute("username"));
        model.addAttribute("notificationList", notificationList);
        return "student/index";
    }

    @RequestMapping(value = "/notRegistered/index", method = {RequestMethod.GET})
    public String notRegisteredToMainPage(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("name",session.getAttribute("username"));
        model.addAttribute("notificationList", notificationList);
        return "notRegistered/index";
    }

    @RequestMapping(value = "/toCourse", method = {RequestMethod.GET})
    public String toCoursePage() throws Exception {
        Context_Redirect context_redirect=new Context_Redirect(new Redirect());
                HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        String role =(String) session.getAttribute("Role");
        VisitorFactory visitorFactory = new CoursePageVisitorFactory();
        ObjectStructure units = new ObjectStructure();
        List<String> url = new ArrayList<>();

        UnitVisitor mainPageVisitor = visitorFactory.createVisitor();
        switch (role){
            case "admin" -> {
                UnitFactory unitFactory = new AdminUnitFactory();
                Unit adminUnit = unitFactory.createUnit();
                units.add(adminUnit);
                url = units.accept(mainPageVisitor);
            }case "student" -> {
                UnitFactory unitFactory = new StudentUnitFactory();
                Unit studentUnit = unitFactory.createUnit();
                units.add(studentUnit);
                url = units.accept(mainPageVisitor);
            }case "notRegistered" -> {
                UnitFactory unitFactory = new NotRegisteredUnitFactory();
                Unit notRegisteredUnit = unitFactory.createUnit();
                units.add(notRegisteredUnit);
                url = units.accept(mainPageVisitor);
            }case "teacher" -> {
                UnitFactory unitFactory = new TeacherUnitFactory();
                Unit teacherUnit = unitFactory.createUnit();
                units.add(teacherUnit);
                url = units.accept(mainPageVisitor);
            }
        }

        return context_redirect.executeStrategy_Redirect(url.get(0));
    }


//    @RequestMapping(value = "/studentToCourse", method = {RequestMethod.GET})
//    public String studentToCoursePage() throws Exception {
//        Context_Redirect context_redirect=new Context_Redirect(new Redirect());
//        return context_redirect.executeStrategy_Redirect("course");
//    }

    @RequestMapping(value = "/studentToSelectedCourse", method = {RequestMethod.GET})
    public String studentToSelectedCoursePage() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
//        return "redirect:student/selectedCourse";
        return context_redirect.executeStrategy_Redirect("selectedCourse");
    }

    @RequestMapping(value = "/teacher/index", method = {RequestMethod.GET})
    public String teacherToMainPage(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        model.addAttribute("name",session.getAttribute("username"));
        return "teacher/index";
    }

    @RequestMapping(value = "/admin/index", method = {RequestMethod.GET})
    public String adminToMainPage(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        model.addAttribute("name",session.getAttribute("username"));
        return "admin/index";
    }

//    @RequestMapping(value = "/adminToCourse", method = {RequestMethod.GET})
//    public String adminToCoursePage() throws Exception {
//        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
//        return context_redirect.executeStrategy_Redirect("course");
////        return "redirect:admin/course";
//    }

    @RequestMapping(value = "/adminToSelectedCourse", method = {RequestMethod.GET})
    public String adminToSelectedCoursePage() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("selectedCourse");
//        return "redirect:admin/selectedCourse";
    }

    @RequestMapping(value = "/adminToAddCourse", method = {RequestMethod.GET})
    public String adminToAddCoursePage() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("toAddCoursePage");
//        return "redirect:admin/toAddCoursePage";
    }

    @RequestMapping(value = "/studentToCalendar", method = {RequestMethod.GET})
    public String studentToCalendarPage(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("notificationList", notificationList);
        return "student/calendar";
    }

    @RequestMapping(value = "/studentToFeePage",method = {RequestMethod.GET})
    public String studentToFeePage() throws Exception{
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("fee");
//        return "redirect:student/fee";
    }

    @RequestMapping(value = "/adminToFeePage",method = {RequestMethod.GET})
    public String adminToFeePage() throws Exception{
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("fee-list");
//        return "redirect:admin/fee-list";
    }

    @RequestMapping(value = "/studentToSubscribedNewsletter", method = {RequestMethod.GET})
    public String studentToSubscribeNewsletterPage() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("subscribedNewsletter");
//        return "redirect:student/subscribedNewsletter";
    }

    @RequestMapping(value = "/studentToSubscribe", method = {RequestMethod.GET})
    public String studentToSubscribePage() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("tosubscribe");
//        return "redirect:student/tosubscribe";
    }

    @RequestMapping(value = "/studentToManageSubscription", method = {RequestMethod.GET})
    public String studentToManageSubscriptionPage() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("managesubscription");
//        return "redirect:student/managesubscription";
    }

    @RequestMapping(value = "/adminToNewsletter", method = {RequestMethod.GET})
    public String adminToNewsletter() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("addnewsletter");
//        return "redirect:admin/addnewsletter";
    }

    @RequestMapping(value = "/adminToIndex", method = {RequestMethod.GET})
    public String adminToIndex(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        model.addAttribute("name",session.getAttribute("username"));
        return "admin/index";
    }

    @RequestMapping(value = "/studentToIndex", method = {RequestMethod.GET})
    public String studentToIndex(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("name",session.getAttribute("username"));
        model.addAttribute("notificationList", notificationList);
        return "student/index";
    }

    //Not Registered
    @RequestMapping(value = "/notRegisteredToIndex", method = {RequestMethod.GET})
    public String notRegitsteredToMainPage(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("name",session.getAttribute("username"));
        model.addAttribute("notificationList", notificationList);
        return "notRegistered/index";
    }

    @RequestMapping(value = "/notRegisteredToSelectedCourse", method = {RequestMethod.GET})
    public String notRegitsteredToSelectedCourse() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("selectedCourse");
//        return "redirect:notRegistered/selectedCourse";
    }

//    @RequestMapping(value = "/notRegisteredToCourse", method = {RequestMethod.GET})
//    public String notRegitsteredToCourse() throws Exception {
//        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
//        return context_redirect.executeStrategy_Redirect("course");
////        return "redirect:notRegistered/course";
//    }

    @RequestMapping(value = "/notRegisteredToFeePage", method = {RequestMethod.GET})
    public String notRegitsteredToFeePage() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("fee");
//        return "redirect:notRegistered/fee";
    }

    @RequestMapping(value = "/notRegisteredToSubscribedNewsletter", method = {RequestMethod.GET})
    public String notRegitsteredToSubscribedNewsletter() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("subscribedNewsletter");
//        return "redirect:notRegistered/subscribedNewsletter";
    }
}
