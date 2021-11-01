$(document).ready(function () {
    $("#date-form").hide();
})

// Mostrar informacion status
function traerInformacionStatus() {
    $("#table-container").show();
    $("#date-form").hide();
    showSpinner()
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/Reservation/report-status",
        dataType: "JSON",
        success: function (response) {
            console.log(response)
            listarRespuestaStatus(response)
            hideSpinner();
        },
        error: function (xhr, status) {
            console.log(status);
        }
    });
}

function listarRespuestaStatus(items) {

    var tabla = `<table class="table table-bordered">
    <thead class="thead-dark">
              <tr>
                <th>COMPLETED</th>
                <th>CANCELLED</th>
              </tr>
              </thead>
              `;

    tabla += `<tr>
                             <td>${items.completed}</td>
                             <td>${items.cancelled}</td>
                </tr>
        `;
    tabla += `</table>`;

    $("#table-container").html(tabla);

}

// Mostrar informacion client
function traerInformacionClient() {
    $("#table-container").show();
    $("#date-form").hide();
    showSpinner()
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/Reservation/report-clients",
        dataType: "JSON",
        success: function (response) {
            console.log(response)
            listarRespuestaClient(response)
            hideSpinner();
        },
        error: function (xhr, status) {
            console.log(status);
        }
    });
}

function listarRespuestaClient(items) {

    var tabla = `<table class="table table-bordered">
    <thead class="thead-dark">
              <tr>
              <th>ID</th>
                <th>CLIENT</th>
                <th>RESERVATION</th>
              </tr>
              </thead>
              `;
    for (let i = 0; i < items.length; i++) {
        tabla += `<tr>
                             <td>${items[i].client.idClient}</td>
                             <td>${items[i].client.name}</td>
                             <td>total: ${items[i].total}</td>
                </tr>
        `;
    }
    tabla += `</table>`;

    $("#table-container").html(tabla);

}
//Traer informacion fecha
// Mostrar informacion fecha
function traerForm() {
    $("#table-container").hide();
    $("#date-form").show();
}

function traerInformacionFecha() {
    $("#table-container").show();
    $("#date-form").hide();
    let startDate = $("#startDate").val();
    let devolutionDate = $("#devolutionDate").val();
    console.log(devolutionDate)
    showSpinner()
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/Reservation/report-dates/${startDate}/${devolutionDate}`,
        dataType: "JSON",
        success: function (response) {
            console.log(response)
            listarRespuestaFecha(response)
            hideSpinner();
        },
        error: function (xhr, status) {
            console.log(status);
        }
    });
}

function listarRespuestaFecha(items) {

    var tabla = `<table class="table table-bordered">
    <thead class="thead-dark">
              <tr>
              <th>ID</th>
                <th>CLIENT</th>
                <th>FECHA INICIO</th>
                <th>FECHA DEVOLUCION</th>
                <th>STATUS</th>
              </tr>
              </thead>
              `;
    for (let i = 0; i < items.length; i++) {
        tabla += `<tr>
                             <td>${items[i].idReservation}</td>
                             <td>${items[i].client.name}</td>
                             <td>${items[i].startDate}</td>
                             <td>${items[i].devolutionDate}</td>
                             <td>${items[i].status}</td>
                </tr>
        `;
    }
    tabla += `</table>`;

    $("#table-container").html(tabla);

}


// Function to hide the Spinner
function hideSpinner() {
    document.getElementById('spinner')
        .style.display = 'none';
}

function showSpinner() {
    document.getElementById('spinner')
        .style.display = 'block';
}

