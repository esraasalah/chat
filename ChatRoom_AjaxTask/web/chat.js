            $(document).ready(function () {
                $("#sendbtn").click(function () {
                    var name = $("#name").val();
                    var message = $("#message").val();
                    var jsonData = {"name": name, "message": message};
                    $.ajax({url: 'Chatservelt', type: 'Get', contentType: 'application/json',
                        data: jsonData,
                        dataType: 'json',
                        success: function (data) {
                            alert("data send");
                        }});
                });
            });