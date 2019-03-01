$(document).ready(function(){
    showAllWorkers();
    $('#workerRegisterId').on('click',function(){
        console.log('utihu');
        signup();
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
                    console.log(serverResponse)
                }
                });
}