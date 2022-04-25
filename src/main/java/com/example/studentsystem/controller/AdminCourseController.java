package com.example.studentsystem.controller;

import com.example.studentsystem.entity.AdminSelectedCourse;
import com.example.studentsystem.entity.Course;
import com.example.studentsystem.entity.SelectedCourse;
import com.example.studentsystem.entity.Student;
import com.example.studentsystem.pattern.decorator.BasicCourse;
import com.example.studentsystem.pattern.decorator.CSCourse;
import com.example.studentsystem.pattern.decorator.MathCourse;
import com.example.studentsystem.service.CourseService;
import com.example.studentsystem.service.FeeService;
import com.example.studentsystem.service.StudentService;
import com.example.studentsystem.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/admin")
public class AdminCourseController {
    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "studentServiceImpl")
    private StudentService studentService;

    @Resource(name = "feeServiceImpl")
    private FeeService feeService;

    @Resource(name = "teacherServiceImpl")
    private TeacherService teacherService;

    //TODO 前端需要修改出填学生号的地方done
    @RequestMapping(value = "/course")
    public String adminAllCourse(Model model) throws Exception {
        List<Course> courseList = courseService.findAllCourse();
        List<Student> studentList = studentService.findAllStudent();

        model.addAttribute("courseList",courseList);
        model.addAttribute("studentList",studentList);
        model.addAttribute("selectedcourse",new SelectedCourse());

        return "admin/course";
    }

    @RequestMapping(value = "/selectedCourse")
    public String adminAllSelectedCourse(Model model) throws Exception {
        //查找出所有选课记录
        List<SelectedCourse> allSelectedCourseList = courseService.findAllSelectedCourse();
        List<AdminSelectedCourse> adminSelectedCourseList = new ArrayList<AdminSelectedCourse>();
        for(SelectedCourse temp:allSelectedCourseList){
            String courseName = courseService.findCourseByCourseID(temp.getCourseid()).getCoursename();
            String studentName = studentService.findStudentByStudentID(temp.getStudentid()).getRealname();
            AdminSelectedCourse adminSelectedCourse = new AdminSelectedCourse(temp.getCourseid(),courseName,temp.getStudentid(),studentName,temp.getMark());
            adminSelectedCourseList.add(adminSelectedCourse);
        }
        model.addAttribute("adminSelectedCourseList",adminSelectedCourseList);

        return "admin/selectedcourse";
    }

    @RequestMapping("/deleteSelected")
    public String deleteSelectedCourse(@RequestParam("sid") Integer sid, @RequestParam("cid") Integer cid){

        courseService.deleteSelectedCourse(sid,cid);
        return "redirect:/admin/selectedCourse";
    }

    @RequestMapping("/addSelected")
    public String addSelectedCourse(@RequestParam Integer studentid,@RequestParam Integer courseid) throws Exception {
        //TODO 选课else处理
        Integer status = feeService.findFeeByUserName(studentid).getFeestatus();
        if(status.equals(1)){
            courseService.addSelectedCourse(studentid,courseid);
            return "redirect:/admin/course";
        }else{
            return "redirect:/admin/course";
        }
    }

    //TODO admin add course前端未修改完成done
    @RequestMapping("/toAddCoursePage")
    public String toAddCoursePage(Model model) throws Exception {
        //teacherid list
        List<Integer> teacheridList = teacherService.findAllTeacherID();

        //week list
        List<Integer> weekList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        //majorid list
        List<String> majoridList = new ArrayList<String>(Arrays.asList("Math", "CS"));

        model.addAttribute("teacheridList",teacheridList);
        model.addAttribute("weekList",weekList);
        model.addAttribute("majoridList",majoridList);

        return "admin/addcourse";
    }

    @RequestMapping("/addNewCourse")
    public String addNewCourse(@RequestParam Integer courseid,@RequestParam String coursename,@RequestParam Integer teacherid,
                               @RequestParam String coursetime,@RequestParam String classroom,@RequestParam Integer courseweek,
                               @RequestParam String coursetype,@RequestParam String majorname,@RequestParam Integer credit,
                               @RequestParam String coursestart,@RequestParam String courseend) throws Exception {


        Course newCourse = new Course();
        newCourse.setCourseid(courseService.indexNewCourse()+1);
        newCourse.setCoursename(coursename);
        newCourse.setTeacherid(teacherid);
        newCourse.setCoursetime(coursetime);
        newCourse.setClassroom(classroom);
        newCourse.setCourseweek(courseweek);
        newCourse.setCredit(credit);
        newCourse.setCoursetype(coursetype);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String tempCoursestart = "2022-03-02 12:17:33";
//        String tempCourseend = "2022-03-02 14:17:33";
        System.out.println("course start end---------------");
        System.out.println(format.parse(coursestart));
        System.out.println(format.parse(courseend));
        newCourse.setCoursestart(format.parse(coursestart));
        newCourse.setCourseend(format.parse(courseend));

        BasicCourse basicCourse = new BasicCourse();
        if(Objects.equals(majorname, "CS")){
            CSCourse csCourse = new CSCourse(basicCourse);
            newCourse = csCourse.courseMajor(newCourse);
        }else if(Objects.equals(majorname, "Math")){
            MathCourse mathCourse = new MathCourse(basicCourse);
            newCourse = mathCourse.courseMajor(newCourse);
        }
        courseService.addNewCourse(newCourse);


        return "admin/addcourse";
    }
}
