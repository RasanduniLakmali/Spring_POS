$(document).ready(function () {
    loadCustomerIds();
    loadItemCodes();
});

function loadCustomerIds() {
    $.ajax({
        url: "http://localhost:8080/api/v1/order/getCuId",  // Correct backend endpoint
        method: "GET",
        success: function (data) {
            let cmbCustomer = $("#customerId");
            cmbCustomer.empty();
            cmbCustomer.append('<option value="">Select Customer Id</option>');  // Fixed syntax

            // Check if data is an array of IDs or objects
            data.forEach(customer => {
                cmbCustomer.append(`<option value="${customer}">${customer}</option>`); // Assuming data is [101, 102, 103]
            });
        },
        error: function () {
            alert("Error loading customer ids.");
        }
    });
}

function loadItemCodes() {
    $.ajax({
        url: "http://localhost:8080/api/v1/order/getCode",  // Correct backend endpoint
        method: "GET",
        success: function (data) {
            let cmbItem = $("#itemCode");
            cmbItem.empty();
            cmbItem.append('<option value="">Select Item Code</option>');  // Fixed syntax


            data.forEach(item => {
                cmbItem.append(`<option value="${item}">${item}</option>`); // Assuming data is [101, 102, 103]
            });
        },
        error: function () {
            alert("Error loading item codes.");
        }
    });
}

$('#customerId').change(function () { // Change event is better than click
    const customerId = $(this).val(); // Get selected customer ID

    if (!customerId) return;

    $.ajax({
        url: `http://localhost:8080/api/v1/order/getCuName/${customerId}`,
        method: "GET",
        success: function (data) {
            $("#customer_name").val(data); // Set the customer name
        },
        error: function () {
            alert("Error loading customer name.");
        }
    });
});


$('#itemCode').change(function (){
    const itemCode = $(this).val();

    if (!itemCode) return;

    $.ajax({
        url: `http://localhost:8080/api/v1/order/getItDetails/${itemCode}`,
        method: "GET",

        success: function (data) {
          $('#item_name').val(data.itemName);
          $('#item_price').val(data.itemPrice);
          $('#qtyOnHand').val(data.itemQuantity);
        },
        error: function () {
            alert("Error loading item details!");
        }
    })
})


$('#addToCartBtn').click(function () {

   const order_id = $('#orderId').val();
   const customer_id = $('#customerId').val();
   const item_code = $('#itemCode').val();
   const item_price = $('#item_price').val();
   const item_qty = $('#qty').val();
   const total = item_qty * item_price;

   $('#orderTableBody').append(`<tr>

         <td>${order_id}</td>
         <td>${customer_id}</td>
         <td>${item_code}</td>
         <td>${item_price}</td>
         <td>${item_qty}</td>
         <td>${total}</td>

   </tr>`)

})


$('#placeOrderBtn').click(function (){
    const order_id = $('#orderId').val();
    const customer_id = $('#customerId').val();
    const date = $('#orderDate').val();
    const item_code = $('#itemCode').val();
    const item_price = $('#item_price').val();
    const item_qty = $('#qty').val();
    const total = item_qty * item_price;

    $.ajax({
        url: `http://localhost:8080/api/v1/order/saveOrder`,
        method: "POST",

        contentType: "application/json",
        dataType: "json",

        data: JSON.stringify({
            orderId: order_id,
            orderDate: date,
            orderTotal: total,
            customerId: customer_id,
            orderDetails: [
                {
                    itemCode: item_code,
                    qty: item_qty,
                    unitPrice: item_price
                }
            ]
        }),

        success: function (resp) {
            alert(resp.msg);  // Show success message
            console.log("Success:", resp);
        },

        error: function (xhr) {
            let response = JSON.parse(xhr.responseText);
            alert("Error: " + response.message); // Show error message from backend
            console.log("Error:", response);
        }
    })
})
