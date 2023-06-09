package kz.aidyninho.bitlabspringsprint2.repository;

import kz.aidyninho.bitlabspringsprint2.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
