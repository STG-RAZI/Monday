package com.stg.services;

import java.util.List;

import com.stg.entity.Course;

public interface CourseService {

	
	public List<Course> getCourse();
	
	  Course getCourseById(long courseId);
	
	  Course saveCourse(Course course);
	  
	  Course updatedCourse(Course course);
	  
	  public void deleteCourseById(long parseLong);
	
	
}
