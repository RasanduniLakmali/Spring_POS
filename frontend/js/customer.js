
$('#saveBtn').click(function() {

    console.log("Save button clicked");

    const customerId = $('#customerId').val();
    const name = $('#name').val();
    const address = $('#address').val();

    console.log("Data to send:", { id: customerId, name: name, address: address });

    $.ajax({
        url: "http://localhost:8080/api/v1/customer/save", // FIXED: Correct API URL
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            id: customerId,
            name: name,
            address: address
        }),
        success: function (resp) {
            alert("Customer saved successfully!");
            clearFields();
            console.log("Response:", resp);
        },
        error: function (xhr) {
            alert("Error: " + xhr.responseText);
            console.error(xhr.responseText);
        }
    });
});


const fetchCustomerData = () =>{
    $.ajax({
        url: `http://localhost:8080/api/v1/customer/getAll`,
        type: "GET",

        success: (res) =>{
            $('#customerTableBody').empty();
            res.forEach(customer =>{
                $('#customerTableBody').append(`<tr>
                           <td>${customer.id}</td>
                           <td>${customer.name}</td>
                           <td>${customer.address}</td>

                   </tr>`)
            });
        },
        error: (err) =>{
            console.error(err);
        }
    })
}

$('#loadBtn').click(function () {
    fetchCustomerData();
});


$('#updateBtn').click(function () {
    const customerId = $('#customerId').val();
    const name = $('#name').val();
    const address = $('#address').val();


    $.ajax({
        url: "http://localhost:8080/api/v1/customer/update",
        type: "PUT",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            id: customerId,
            name: name,
            address: address
        }),

        success: function (resp) {
            alert("Customer updated successfully!");
            clearFields();
            fetchCustomerData();
            console.log("Response:", resp);
        },
        error: function (xhr) {
            alert("Error: " + xhr.responseText);
            console.error(xhr.responseText);
        }
    })
});

$('#customerTableBody').on('click','tr',function (){
    const customer_id = $(this).find('td').eq(0).text();
    const customer_name = $(this).find('td').eq(1).text();
    const address = $(this).find('td').eq(2).text();

    $('#customerId').val(customer_id);
    $('#name').val(customer_name);
    $('#address').val(address);

});

$('#deleteBtn').click((e) =>{

    const customer_id = $('#customerId').val();

    if (confirm("Are you sure ?")) {

        $.ajax({
            url: `http://localhost:8080/api/v1/customer/delete/${customer_id}`,
            type: "DELETE",

            success: (res) =>{
                alert("Customer deleted successfully!")
                clearFields();
                // $('#customerTableBody').empty()
                fetchCustomerData();
            },
            error: (err) =>{
                alert("Customer not deleted!")
            }
        })
    }
});


const clearFields = () =>{
    $('#customerId').val('');
    $('#name').val('');
    $('#address').val('');
}

