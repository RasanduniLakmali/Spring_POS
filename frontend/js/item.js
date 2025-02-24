

$('#saveBtn').click(function() {

    console.log("Save button clicked");

    const itemCode = $('#itemCode').val();
    const name = $('#name').val();
    const price = $('#price').val();
    const quantity = $('#quantity').val();

    console.log("Data to send:", { id: itemCode, name: name, price: price, quantity: quantity });

    $.ajax({
        url: "http://localhost:8080/api/v1/item/save", // FIXED: Correct API URL
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            itemCode: itemCode,
            itemName:  name,
            itemPrice: price,
            itemQuantity: quantity,
        }),
        success: function (resp) {
            alert("Item saved successfully!");
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
        url: `http://localhost:8080/api/v1/item/getAll`,
        type: "GET",

        success: (res) =>{
            $('#itemTableBody').empty();
            res.forEach(item =>{
                $('#itemTableBody').append(`<tr>
                           <td>${item.itemCode}</td>
                           <td>${item.itemName}</td>
                           <td>${item.itemPrice}</td>
                           <td>${item.itemQuantity}</td>

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


$('#itemTableBody').on('click','tr',function (){
    const item_code = $(this).find('td').eq(0).text();
    const item_name = $(this).find('td').eq(1).text();
    const item_price = $(this).find('td').eq(2).text();
    const item_quantity = $(this).find('td').eq(3).text();

    $('#itemCode').val(item_code);
    $('#name').val(item_name);
    $('#price').val(item_price);
    $('#quantity').val(item_quantity);

});

$('#updateBtn').click(function () {
    const itemCode = $('#itemCode').val();
    const name = $('#name').val();
    const price = $('#price').val();
    const quantity = $('#quantity').val();


    $.ajax({
        url: "http://localhost:8080/api/v1/item/update",
        type: "PUT",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
            itemCode: itemCode,
            itemName:  name,
            itemPrice: price,
            itemQuantity: quantity,
        }),

        success: function (resp) {
            alert("Item updated successfully!");
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


$('#deleteBtn').click((e) =>{

    const item_code = $('#itemCode').val();

    if (confirm("Are you sure ?")) {

        $.ajax({
            url: `http://localhost:8080/api/v1/item/delete/${item_code}`,
            type: "DELETE",

            success: (res) =>{
                alert("Item deleted successfully!")
                clearFields();
                // $('#customerTableBody').empty()
                fetchCustomerData();
            },
            error: (err) =>{
                alert("Item not deleted!")
            }
        })
    }
});


const clearFields = () =>{
    $('#itemCode').val('');
    $('#name').val('');
    $('#price').val('');
    $('#quantity').val('');
}


