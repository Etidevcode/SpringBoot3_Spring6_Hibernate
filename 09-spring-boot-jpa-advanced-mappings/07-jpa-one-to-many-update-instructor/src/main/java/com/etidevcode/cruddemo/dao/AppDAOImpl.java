package com.etidevcode.cruddemo.dao;

import com.etidevcode.cruddemo.entity.Course;
import com.etidevcode.cruddemo.entity.Instructor;
import com.etidevcode.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

	// define field for entity manager
	private EntityManager entityManager;

	// inject entity manager using constructor injection

	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
	}

	@Override
	public Instructor findInstructorById(int theId) {
		return entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int theId) {

		// retrieve the instructor
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);

		// delete the instructor
		entityManager.remove(tempInstructor);
	}

	@Override
	public InstructorDetail findInstructorDetailById(int theId) {
		return entityManager.find(InstructorDetail.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int theId) {

		// retrieve instructor detail
		InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

		// remove the associated object reference
		// break bi-directional link
		//
		tempInstructorDetail.getInstructor().setInstructorDetail(null);

		// detail the instructorDetail
		entityManager.remove(tempInstructorDetail);
	}

	@Override
	public List<Course> findCoursesByInstructorId(int theId) {

		// create query
		TypedQuery<Course> query = entityManager.createQuery(
				"from Course where instructor.id = :data",
				Course.class
		);

		query.setParameter("data", theId);

		// execute query
		List<Course> courses = query.getResultList();

		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {

		// create query
		Session session = entityManager.unwrap(Session.class);
		Query<Instructor> query = session.createQuery(
				"select i from Instructor i "
				+ "JOIN FETCH i.courses "
				+ "JOIN FETCH i.instructorDetail "
				+ "where i.id=:data",
				Instructor.class);

		query.setParameter("data", theId);

		// execute query
		Instructor instructor = query.getSingleResult();

		return instructor;
	}
}
