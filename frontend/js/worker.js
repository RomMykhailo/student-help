$(document).ready(function(){
    $('#showAllWorkersId').on('click',function(){
        showAllWorkers();
    });
    $('#showWorkerId').on('click',function(){
        let num= $('#inputWorkerId').val();
        showWorkerById(num);
    });
    $('#workerRegisterId').on('click',function(){
        signup();
    })
    $('#inputWorkerId').change(function(){
        let num= $('#inputWorkerId').val();
        showWorkerById(num);
    })
});

function signup(){
    let workerName = $('#workerNameId').val();
    let workerEmail = $('#workerEmailId').val();
    let workerPassword = $('#workerPasswordId').val();
    let workerConfirm = $('#workerConfirmId').val();
    let workerDeskription = $('#workerDescriptionId').val();
    
    let worker = {
        name: workerName,
        email: workerEmail,
        password: workerPassword,
        passwordConfirm: workerConfirm,
        description: workerDeskription
    }
    console.log(JSON.stringify(worker));
                
    $.ajax({
                url: SERVER_URL+'workers/add',
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(worker),
                complete: function(serverResponse){
                    console.log(serverResponse)
                }
            });
    
}

function showAllWorkers(){
    
     $.ajax({
                url: SERVER_URL+'workers',
                method: 'GET',
                contentType: 'application/json',
                complete: function(serverResponse){
                    console.log(serverResponse);
                    let workers =serverResponse.responseJSON;
                    let list="<tr> <td> Id </td> <td> Name </td> <td> Email </td> <td> Description </td> </tr>";
                    var i;
                    for (i=0; i<workers.length; i++){
                       list=list + "<tr> <td> " + workers[i].id + "</td> <td>"+ workers[i].name + "</td> <td>" + workers[i].email + "</td> <td>" + workers[i].description + "</td> </tr>"; 
                    }
                    
                     $("#tableWorkersId").html(list);
                
                }
            });
};

function showWorkerById (id){
    $.ajax({
        url: SERVER_URL+'workers/id/'+id,
        success: function(data){
            console.log(data);
            $("#workerId").text("Name worker: "+data.name+ ", email: " + data.email);
        },
        statusCode:{ 409:function(){
            $("#workerId").text("Worker with id " + id + " not exists");
        }
    }
        
   });
};
 