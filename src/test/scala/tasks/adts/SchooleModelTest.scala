package tasks.adts

import org.junit.*
import org.junit.Assert.*
import tasks.adts.SchoolModel.*
import u03.extensionmethods.Sequences.*
import u03.extensionmethods.Sequences.Sequence.*

class SchooleModelTest:

  val schoolModelADT: SchoolModule = BasicSchoolModule
  import BasicSchoolModule.*

  @Test def testTeacherCreation(): Unit =
    assertEquals(teacher("John"), TeacherClass("John"))

  @Test def testCourseCreation(): Unit =
    assertEquals(course("Math"), CourseClass("Math"))

  @Test def testEmptySchoolCreation(): Unit =
    assertEquals(emptySchool, SchoolClass(courses = Nil(), teachers = Nil(), teacherToCourses = Nil()))

  @Test def testCourses(): Unit =
    assertEquals(emptySchool.courses, Nil())
    val john: Teacher = teacher("John")
    val math: Course = course("Math")
    val italian: Course = course("Italian")
    assertEquals(emptySchool.setTeacherToCourse(john, math).courses,  Cons("Math", Nil()))

  @Test def testTeacherToCourse(): Unit =
    assertEquals(emptySchool.setTeacherToCourse(teacher("John"), course("Math")), SchoolClass(courses = Cons(CourseClass("Math"), Nil()), teachers = Cons(TeacherClass("John"), Nil()), teacherToCourses = Cons((TeacherClass("John"), CourseClass("Math")), Nil())))
