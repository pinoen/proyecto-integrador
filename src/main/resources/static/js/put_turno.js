$(document).ready(function(){
    $("#update_turno_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let odontologoId = $("#turno_id").val();

        let formData = {
            id: $("#turno_id").val(),
            fecha : $("#fecha").val(),
            paciente :  $("#paciente_id").val(),
            odontologo: $("#odontologo_id").val(),
        }

            $.ajax({
                url: '/turnos',
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function (response) {
                    let turno = response;

                    let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                            '<strong> Turno actualizado </strong></div>'


                    $("#tr_" + turnoId + " td.td_fecha").text(turno.fecha);
                    $("#tr_" + turnoId + " td.td_paciente_id").text(turno.paciente.id);
                    $("#tr_" + turnoId + " td.td_odontologo_id").text(turno.odontologo.id);

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                        '<strong> Error </strong></div>';

                    $("#response").empty();
                    $("#response").append(errorAlert);
                    $("#response").css({"display": "block"});
                    location.reload();
                }
            });
        } catch(error){
            console.log(error);
            alert(error);
        }
    });

    $(document).on("click", "table button.btn_id", function(){
        let id_of_button = (event.srcElement.id);
        let turnoId = id_of_button.split("_")[2];

        $.ajax({
            url: '/turnos/' + turnoId,
            type: 'GET',
            success: function(response) {
                let turno = response;
                $("#turno_id").val(turno.id);
                $("#fecha").val(turno.fecha);
                $("#paciente_id").val(turno.paciente.id);
                $("#odontologo_id").val(turno.odontologo.id);
                $("#div_turno_updating").css({"display": "block"});
            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });
    });
});