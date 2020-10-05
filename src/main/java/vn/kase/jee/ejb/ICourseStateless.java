package vn.kase.jee.ejb;

import java.util.List;

import vn.kase.jee.ejb.pojo.Course;

public interface ICourseStateless {
    List<Course> getAllCourses();
}
