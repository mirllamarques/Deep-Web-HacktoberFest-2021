$( document ).ready(function() {
    $("#btn_verificar").click(function(){
        var a = $("#lado_a").val();
        var b = $("#lado_b").val();
        var c = $("#lado_c").val();

        if(a == '' || b == '' || c == '') {
            $("#mensagem").html("<b> <font color='red'>Todos os campos são obrigatórios. </b>");
            setTimeout(function() {
                $("#mensagem").html("");
            }, 5000);
        }
        else if(a <= 0 || b <= 0 || c<=0) {
            $("#mensagem").html("<b> <font color='red'>Os lados do triângulo deve ser maior que 0. </b>");
            setTimeout(function() {
                $("#mensagem").html("");
            }, 5000);
        }
        else if(parseInt(a) < parseInt(b)+parseInt(c) && parseInt(b) < parseInt(a)+parseInt(c) && parseInt(c) < parseInt(a)+parseInt(b)) {
            
            if(parseInt(a)*parseInt(a) == parseInt(b)*parseInt(b) + parseInt(c)*parseInt(c) ||
                    parseInt(b)*parseInt(b) == parseInt(c)*parseInt(c) + parseInt(a)*parseInt(a) ||
                    parseInt(c)*parseInt(c) == parseInt(b)*parseInt(b) + parseInt(a)*parseInt(a)) {
                        $("#resultado").html("<b>Triângulo retângulo.</b>");
                    }
            else if(parseInt(a)*parseInt(a) > parseInt(b)*parseInt(b) + parseInt(c)*parseInt(c) ||
                    parseInt(b)*parseInt(b) > parseInt(c)*parseInt(c) + parseInt(a)*parseInt(a) ||
                    parseInt(c)*parseInt(c) > parseInt(b)*parseInt(b) + parseInt(a)*parseInt(a)) {
                        $("#resultado").html("<b>Triângulo obstusângulo.</b>"); 
            }
            else if(parseInt(a)*parseInt(a) < parseInt(b)*parseInt(b) + parseInt(c)*parseInt(c) ||
                    parseInt(b)*parseInt(b) < parseInt(c)*parseInt(c) + parseInt(a)*parseInt(a) ||
                    parseInt(c)*parseInt(c) < parseInt(b)*parseInt(b) + parseInt(a)*parseInt(a)) {
                        $("#resultado").html("<b>Triângulo acutângulo.</b>");
            }
        }
        else if(a == b && b == c) {
            $("#resultado").html("<b>Triângulo Equilátero.</b>");
        }
        else if(a == b || a == c || b == c) {
            $("#resultado").html("<b>Triângulo Isosceles.</b>");
        }
        else if(a !=b && a != c && b !=c ) {
            $("#resultado").html("<b>Triânculo Escaleno</b>");
        }
    });
});