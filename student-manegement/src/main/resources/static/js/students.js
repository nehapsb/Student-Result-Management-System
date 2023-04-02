 function view_students() {
         $(document).ready(function(){
            $.getJSON("http://localhost:8080/api/v1/student", function(result){
               $.each(result, function(key,value) {
                  $("#students").append(value.id+" "+value.name+" ");
               });
            });
     });
 }

function addStudent() {
             $(document).ready(function() {
                   var studentModel = {
                      firstName : document.getElementById("fname"),
                      lastName : document.getElementById("lname"),
                      dateOfBirth: document.getElementById("dob"),
                   };
                   var requestJSON = JSON.stringify(studentModel);
                   $.ajax({
                      type : "POST",
                      url : "http://localhost:9090/api/v1/student/save",
                      headers : {
                         "Content-Type" : "application/json"
                      },
                      data : requestJSON,
                      success : function(response) {
                         alert("The data has been added successfully");
                      },
                      error : function(data) {
                         alert("Failed to add the data.");
                      }
                   });
                });
}
