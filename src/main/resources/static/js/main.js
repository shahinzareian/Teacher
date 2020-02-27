function getTeachers() {
       $.get('api/teachers', function(teachers) {
           displayTeachers(teachers);
       });
   }
   $(document).ready(function() {
           $('#getTeacherButton').click(getTeachers);
   });
   function displayTeachers(teachers){
       var teacherContainer=$ ('#teacherContainer');
       teacherContainer.empty();
       $.each (teachers,function(index,teacher){
           $('#teacherContainer').append(' <tr><td>id: ' + teacher.id+ '   </td>     <td>teacher: '  +teacher.name+  '  <td></tr>');

       });
   }
   function getCourses() {
       $.get('api/courses', function(courses) {
           displayCourses(courses);
       });
   }
   $(document).ready(function() {
           $('#getCourseButton').click(getCourses);
   });
   function displayCourses(courses){
       var courseContainer=$ ('#courseContainer');
       courseContainer.empty();
       $.each (courses,function(index,course){
           $('#courseContainer').append(' <tr><td>id: ' + course.id+ '   </td>     <td>teacher: '  +course.name+  '  <td></tr>');

       });
   }