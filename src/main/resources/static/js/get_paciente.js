$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/pacientes",
            success: function(response){
              $.each(response, (i, paciente) => {
                let deleteButton = '<button ' +
                              'id=' +
                              '\"' + 'btn_delete_' + paciente.id + '\"'+
                              ' type="button" class="btn btn-danger btn_delete" data-toggle="modal"  data-target="#delete-modal"' +
                              '>&times</button>';

                let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                            ' type="button" class="btn btn-info btn_id">' +
                                            paciente.id +
                                            '</button>';

                let tr_id = 'tr_' + paciente.id;
                let pacienteRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + get_More_Info_Btn + '</td>' +
                          '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                           '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>' +
                           '<td class=\"td_dni\">' + paciente.dni + '</td>' +
                           '<td class=\"td_fechaIngreso\">' + paciente.fechaIngreso + '</td>' +
                           '<td class=\"td_email\">' + paciente.email + '</td>' +
                           '<td class=\"td_domicilio\"> ' + paciente.domicilio.calle + ' ' + paciente.domicilio.numero + ', '+ paciente.domicilio.localidad + ', ' + paciente.domicilio.provincia + '</td>' +
                          '<td>' + deleteButton + '</td>' +
                          '</tr>';
                $('#pacienteTable tbody').append(pacienteRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();

    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/pacientes.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});