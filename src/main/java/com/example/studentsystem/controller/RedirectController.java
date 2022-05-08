package com.example.studentsystem.controller;

import com.example.studentsystem.entity.NewsLetter;
import com.example.studentsystem.pattern.factorymethod_visitor.UnitFactories.AdminUnitFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.UnitFactories.NotRegisteredUnitFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.UnitFactories.StudentUnitFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.UnitFactories.TeacherUnitFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.UnitFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.VisitorFactories.CoursePageVisitorFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.VisitorFactories.FeePageVisitorFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.VisitorFactories.IndexPageVisitorFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.VisitorFactories.SelectedCoursePageVisitorFactory;
import com.example.studentsystem.pattern.factorymethod_visitor.VisitorFactory;
import com.example.studentsystem.pattern.strategy_redirect.Context_Redirect;
import com.example.studentsystem.pattern.strategy_redirect.Direct;
import com.example.studentsystem.pattern.strategy_redirect.Redirect;
import com.example.studentsystem.pattern.visitor.ObjectStructure;
import com.example.studentsystem.pattern.visitor.Unit;
import com.example.studentsystem.pattern.visitor.UnitVisitor;
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

import java.util.List;
import java.util.Objects;

@Controller
public class RedirectController {
    @Resource(name = "newsletterServiceImpl")
    private NewsletterService newsletterService;

    //index
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

    //student and nor registered student to index
    @RequestMapping(value = "/allStudentToIndex", method = {RequestMethod.GET})
    public String toIndex(Model model) throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Direct());
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        String role =(String) session.getAttribute("Role");
        VisitorFactory visitorFactory = new IndexPageVisitorFactory();
        ObjectStructure units = new ObjectStructure();
        List<String> url = new ArrayList<>();

        UnitVisitor indexPageVisitor = visitorFactory.createVisitor();
        switch (role){
            case "student" -> {
                UnitFactory unitFactory = new StudentUnitFactory();
                Unit studentUnit = unitFactory.createUnit();
                units.add(studentUnit);
                url = units.accept(indexPageVisitor);
            }case "notRegistered" -> {
                UnitFactory unitFactory = new NotRegisteredUnitFactory();
                Unit notRegisteredUnit = unitFactory.createUnit();
                units.add(notRegisteredUnit);
                url = units.accept(indexPageVisitor);
            }
        }
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("name",session.getAttribute("username"));
        model.addAttribute("notificationList", notificationList);
//        return "student/index";

        return context_redirect.executeStrategy_Redirect(url.get(0));
    }

    //admin and teacher(possible) to index
    @RequestMapping(value = "/adminAndTeacherToIndex", method = {RequestMethod.GET})
    public String toIndex2(Model model) throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Direct());
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        String role =(String) session.getAttribute("Role");
        VisitorFactory visitorFactory = new IndexPageVisitorFactory();
        ObjectStructure units = new ObjectStructure();
        List<String> url = new ArrayList<>();

        UnitVisitor indexPageVisitor = visitorFactory.createVisitor();
        switch (role){
            case "admin" -> {
                UnitFactory unitFactory = new AdminUnitFactory();
                Unit adminUnit = unitFactory.createUnit();
                units.add(adminUnit);
                url = units.accept(indexPageVisitor);
            }case "teacher" -> {
                UnitFactory unitFactory = new TeacherUnitFactory();
                Unit teacherUnit = unitFactory.createUnit();
                units.add(teacherUnit);
                url = units.accept(indexPageVisitor);
            }
        }
        model.addAttribute("name",session.getAttribute("username"));
        return context_redirect.executeStrategy_Redirect(url.get(0));
    }

    //all roles to course page
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

    //all roles to fee page
    @RequestMapping(value = "/toFeePage",method = {RequestMethod.GET})
    public String ToFeePage() throws Exception{
        Context_Redirect context_redirect=new Context_Redirect(new Redirect());
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        String role =(String) session.getAttribute("Role");
        VisitorFactory visitorFactory = new FeePageVisitorFactory();
        ObjectStructure units = new ObjectStructure();
        List<String> url = new ArrayList<>();

        UnitVisitor feePageVisitor = visitorFactory.createVisitor();
        switch (role){
            case "admin" -> {
                UnitFactory unitFactory = new AdminUnitFactory();
                Unit adminUnit = unitFactory.createUnit();
                units.add(adminUnit);
                url = units.accept(feePageVisitor);
            }case "student" -> {
                UnitFactory unitFactory = new StudentUnitFactory();
                Unit studentUnit = unitFactory.createUnit();
                units.add(studentUnit);
                url = units.accept(feePageVisitor);
            }case "notRegistered" -> {
                UnitFactory unitFactory = new NotRegisteredUnitFactory();
                Unit notRegisteredUnit = unitFactory.createUnit();
                units.add(notRegisteredUnit);
                url = units.accept(feePageVisitor);
            }case "teacher" -> {
                UnitFactory unitFactory = new TeacherUnitFactory();
                Unit teacherUnit = unitFactory.createUnit();
                units.add(teacherUnit);
                url = units.accept(feePageVisitor);
            }
        }

        return context_redirect.executeStrategy_Redirect(url.get(0));
//        return "redirect:student/fee";
    }

    //all roles to selected course page
    @RequestMapping(value = "/toSelectedCourse", method = {RequestMethod.GET})
    public String toSelectedCourse() throws Exception {
        Context_Redirect context_redirect=new Context_Redirect(new Redirect());
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        String role =(String) session.getAttribute("Role");
        VisitorFactory visitorFactory = new SelectedCoursePageVisitorFactory();
        ObjectStructure units = new ObjectStructure();
        List<String> url = new ArrayList<>();

        UnitVisitor selectedCoursePageVisitor = visitorFactory.createVisitor();
        switch (role){
            case "admin" -> {
                UnitFactory unitFactory = new AdminUnitFactory();
                Unit adminUnit = unitFactory.createUnit();
                units.add(adminUnit);
                url = units.accept(selectedCoursePageVisitor);
            }case "student" -> {
                UnitFactory unitFactory = new StudentUnitFactory();
                Unit studentUnit = unitFactory.createUnit();
                units.add(studentUnit);
                url = units.accept(selectedCoursePageVisitor);
            }case "notRegistered" -> {
                UnitFactory unitFactory = new NotRegisteredUnitFactory();
                Unit notRegisteredUnit = unitFactory.createUnit();
                units.add(notRegisteredUnit);
                url = units.accept(selectedCoursePageVisitor);
            }case "teacher" -> {
                UnitFactory unitFactory = new TeacherUnitFactory();
                Unit teacherUnit = unitFactory.createUnit();
                units.add(teacherUnit);
                url = units.accept(selectedCoursePageVisitor);
            }
        }

        return context_redirect.executeStrategy_Redirect(url.get(0));
    }

    //admin
    @RequestMapping(value = "/adminToAddCourse", method = {RequestMethod.GET})
    public String adminToAddCoursePage() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("admin/toAddCoursePage");
//        return "redirect:admin/toAddCoursePage";
    }

    @RequestMapping(value = "/adminToNewsletter", method = {RequestMethod.GET})
    public String adminToNewsletter() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("admin/addnewsletter");
//        return "redirect:admin/addnewsletter";
    }
    @RequestMapping(value = "/adminToNewsletterUpdate", method = {RequestMethod.GET})
    public String adminToNewsletterUpdate() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Direct());
        return context_redirect.executeStrategy_Redirect("admin/adminToNewsletterUpdate");
//        return "admin/adminToNewsletterUpdate";
    }

    //student
    @RequestMapping(value = "/studentToCalendar", method = {RequestMethod.GET})
    public String studentToCalendarPage(Model model) throws Exception {
        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest().getSession();
        System.out.println(session.getAttribute("username"));
        List<NewsLetter> notificationList =
                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
        model.addAttribute("notificationList", notificationList);
        Context_Redirect context_redirect = new Context_Redirect(new Direct());
        return context_redirect.executeStrategy_Redirect("student/calendar");
    }

    @RequestMapping(value = "/studentToSubscribedNewsletter", method = {RequestMethod.GET})
    public String studentToSubscribeNewsletterPage() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("student/subscribedNewsletter");
//        return "redirect:student/subscribedNewsletter";
    }

    @RequestMapping(value = "/studentToSubscribe", method = {RequestMethod.GET})
    public String studentToSubscribePage() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("student/tosubscribe");
//        return "redirect:student/tosubscribe";
    }

    @RequestMapping(value = "/studentToManageSubscription", method = {RequestMethod.GET})
    public String studentToManageSubscriptionPage() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("student/managesubscription");
//        return "redirect:student/managesubscription";
    }

    //Not Registered
    @RequestMapping(value = "/notRegisteredToSubscribedNewsletter", method = {RequestMethod.GET})
    public String notRegitsteredToSubscribedNewsletter() throws Exception {
        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
        return context_redirect.executeStrategy_Redirect("notRegistered/subscribedNewsletter");
//        return "redirect:notRegistered/subscribedNewsletter";
    }


//    @RequestMapping(value = "/adminToIndex", method = {RequestMethod.GET})
//    public String adminToIndex(Model model) throws Exception {
//        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
//                .getRequestAttributes())).getRequest().getSession();
//        System.out.println(session.getAttribute("username"));
//        model.addAttribute("name",session.getAttribute("username"));
//        return "admin/index";
//    }

//    @RequestMapping(value = "/notRegisteredToIndex", method = {RequestMethod.GET})
//    public String notRegitsteredToMainPage(Model model) throws Exception {
//        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
//                .getRequestAttributes())).getRequest().getSession();
//        System.out.println(session.getAttribute("username"));
//        List<NewsLetter> notificationList =
//                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
//        model.addAttribute("name",session.getAttribute("username"));
//        model.addAttribute("notificationList", notificationList);
//        return "notRegistered/index";
//    }

//    @RequestMapping(value = "/studentToIndex", method = {RequestMethod.GET})
//    public String studentToIndex(Model model) throws Exception {
//        HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
//                .getRequestAttributes())).getRequest().getSession();
//        System.out.println(session.getAttribute("username"));
//        List<NewsLetter> notificationList =
//                newsletterService.findAllNewsLetterByStudentid(Integer.valueOf((String) session.getAttribute("username")));
//        model.addAttribute("name",session.getAttribute("username"));
//        model.addAttribute("notificationList", notificationList);
//        return "student/index";
//    }

//    @RequestMapping(value = "/studentToCourse", method = {RequestMethod.GET})
//    public String studentToCoursePage() throws Exception {
//        Context_Redirect context_redirect=new Context_Redirect(new Redirect());
//        return context_redirect.executeStrategy_Redirect("course");
//    }

//    @RequestMapping(value = "/studentToSelectedCourse", method = {RequestMethod.GET})
//    public String studentToSelectedCoursePage() throws Exception {
//        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
////        return "redirect:student/selectedCourse";
//        return context_redirect.executeStrategy_Redirect("selectedCourse");
//    }



//    @RequestMapping(value = "/adminToCourse", method = {RequestMethod.GET})
//    public String adminToCoursePage() throws Exception {
//        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
//        return context_redirect.executeStrategy_Redirect("course");
////        return "redirect:admin/course";
//    }

//    @RequestMapping(value = "/adminToSelectedCourse", method = {RequestMethod.GET})
//    public String adminToSelectedCoursePage() throws Exception {
//        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
//        return context_redirect.executeStrategy_Redirect("selectedCourse");
////        return "redirect:admin/selectedCourse";
//    }



//    @RequestMapping(value = "/studentToFeePage",method = {RequestMethod.GET})
//    public String studentToFeePage() throws Exception{
//        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
//        return context_redirect.executeStrategy_Redirect("fee");
////        return "redirect:student/fee";
//    }

//    @RequestMapping(value = "/adminToFeePage",method = {RequestMethod.GET})
//    public String adminToFeePage() throws Exception{
//        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
//        return context_redirect.executeStrategy_Redirect("fee-list");
////        return "redirect:admin/fee-list";
//    }



//    @RequestMapping(value = "/notRegisteredToSelectedCourse", method = {RequestMethod.GET})
//    public String notRegitsteredToSelectedCourse() throws Exception {
//        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
//        return context_redirect.executeStrategy_Redirect("selectedCourse");
////        return "redirect:notRegistered/selectedCourse";
//    }

//    @RequestMapping(value = "/notRegisteredToCourse", method = {RequestMethod.GET})
//    public String notRegitsteredToCourse() throws Exception {
//        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
//        return context_redirect.executeStrategy_Redirect("course");
////        return "redirect:notRegistered/course";
//    }

//    @RequestMapping(value = "/notRegisteredToFeePage", method = {RequestMethod.GET})
//    public String notRegitsteredToFeePage() throws Exception {
//        Context_Redirect context_redirect = new Context_Redirect(new Redirect());
//        return context_redirect.executeStrategy_Redirect("fee");
////        return "redirect:notRegistered/fee";
//    }

}
