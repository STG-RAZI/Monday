package com.stg.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.stg.entity.Course;
import com.stg.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(101, "Java", "this course is for java"));
		list.add(new Course(102, "Spring boot", "this is for spring boot"));
		list.add(new Course(103, "react", "this is for react js"));
		
	}
	
	@Override
	public List<Course> getCourse() {
		return list;

	
	}

	@Override
	public Course getCourseById(long courseId) {
		
		Course  c = null;
		for(Course course : list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		
		return c;
	}

	@Override
	public Course saveCourse(Course course) {
		
		list.add(course);
		
		return course;
	}

	@Override
	public Course updatedCourse(Course course) {
		list.forEach(e->{
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(e.getDescription());
			}
		});
		
		return course;
	}

	@Override
	public void deleteCourseById(long parseLong) {
		list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	}
}
